package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Buildings.BarracksBuilding;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.CampfireBuilding;
import unsw.loopmania.Buildings.HerosCastleBuilding;
import unsw.loopmania.Buildings.TowerBuilding;
import unsw.loopmania.Buildings.TrapBuilding;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.VillageBuilding;
import unsw.loopmania.Buildings.ZombiePitBuilding;
import unsw.loopmania.Cards.BarracksCard;
import unsw.loopmania.Cards.CampfireCard;
import unsw.loopmania.Cards.Card;
import unsw.loopmania.Cards.TowerCard;
import unsw.loopmania.Cards.TrapCard;
import unsw.loopmania.Cards.VampireCastleCard;
import unsw.loopmania.Cards.VillageCard;
import unsw.loopmania.Cards.ZombiePitCard;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.goal.GoalNode;
import unsw.loopmania.item.weapon.Sword;
import unsw.loopmania.item.weapon.Weapon;
import unsw.loopmania.item.consumable.HealthPotion;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;
import unsw.loopmania.item.weapon.Staff;
import unsw.loopmania.item.weapon.Stake;
import unsw.loopmania.item.weapon.Sword;
import unsw.loopmania.item.weapon.Weapon;

/**
 * A backend world.
 *
 * A world can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 */
public class LoopManiaWorld {
    // TODO = add additional backend functionality

    public static final int unequippedInventoryWidth = 4;
    public static final int unequippedInventoryHeight = 4;

    /**
     * width of the world in GridPane cells
     */
    private int width;

    /**
     * height of the world in GridPane cells
     */
    private int height;

    /**
     * generic entitites - i.e. those which don't have dedicated fields
     */
    private List<Entity> nonSpecifiedEntities;

    private Character character;

    // TODO = add more lists for other entities, for equipped inventory items, etc...

    // TODO = expand the range of enemies
    private List<BasicEnemy> enemies;

    // TODO = expand the range of cards
    private List<Card> cardEntities;

    // TODO = expand the range of items
    private List<Entity> unequippedInventoryItems;

    // TODO = expand the range of buildings
    private List<Building> buildingEntities;

    private HerosCastleBuilding herosCastleBuilding;

    /**
     * list of x,y coordinate pairs in the order by which moving entities traverse them
     */
    private List<Pair<Integer, Integer>> orderedPath;

    private IntegerProperty round;
    private IntegerProperty gold; 
    private IntegerProperty experience;
    private IntegerProperty allyNumbers;
    private GoalNode goal;
    private boolean gameOver;
    private LoopManiaWorldController controller;

    /**
     * create the world (constructor)
     * 
     * @param width width of world in number of cells
     * @param height height of world in number of cells
     * @param orderedPath ordered list of x, y coordinate pairs representing position of path cells in world
     */
    public LoopManiaWorld(int width, int height, List<Pair<Integer, Integer>> orderedPath) {
        this.width = width;
        this.height = height;
        nonSpecifiedEntities = new ArrayList<>();
        character = null;
        enemies = new ArrayList<>();
        cardEntities = new ArrayList<>();
        unequippedInventoryItems = new ArrayList<>();
        this.orderedPath = orderedPath;
        buildingEntities = new ArrayList<>();
        this.round = new SimpleIntegerProperty(1);
        this.gold = new SimpleIntegerProperty(0);
        this.allyNumbers = new SimpleIntegerProperty(0);
        this.experience = new SimpleIntegerProperty(0);
        this.goal = null;
        this.gameOver = false;
        this.herosCastleBuilding = null;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * set the character. This is necessary because it is loaded as a special entity out of the file
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * add a generic entity (without it's own dedicated method for adding to the world)
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
        // TODO = if more specialised types being added from main menu, add more methods like this with specific input types...
        nonSpecifiedEntities.add(entity);
    }

    /**
     * spawns enemies if the conditions warrant it, adds to world
     * @return list of the enemies to be displayed on screen
     */
    public List<BasicEnemy> possiblySpawnEnemies(){

        Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (pos != null){
            int indexInPath = orderedPath.indexOf(pos);

            Slug slug = new Slug(new PathPosition(indexInPath, orderedPath));
            enemies.add(slug);
            spawningEnemies.add(slug);
            return spawningEnemies;
        }
        return spawningEnemies;
    }

    // function to spawn a zombie if ally was bit by zombie
    private void spawnZombieCrit(Zombie zombie) {
        
    }

    /**
     * kill an enemy
     * @param enemy enemy to be killed
     */
    private void killEnemy(BasicEnemy enemy){
        enemy.destroy();
        enemies.remove(enemy);
    }

    /**
     * run the expected battles in the world, based on current world state
     * @return list of enemies which have been killed
     */
    public List<BasicEnemy> runBattles() {
        // TODO = modify this - currently the character automatically wins all battles without any damage!
        BasicEnemy firstEnemy = null;
        int bonusDamage = 0;
        //boolean campfirePresent = false;
        System.out.println("CHARACTER DAMAGE: " + character.getDamage());
        for (Building b: buildingEntities) {
            if (b.checkInRange(character.getX(), character.getY())) {
                bonusDamage += b.CharacterBattleBuffAbility(character);
                System.out.println("BONUS DAMAGE: " + bonusDamage);
            }
        }
        // Stores all the defeated enemies
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();

        
        // Stores all the enemies within battle and support radius (no duplicates)
        List<BasicEnemy> queuedEnemies = new ArrayList<BasicEnemy>();

        
        
        // Loop through the enemy list for battle radius, then get the battling enemy
        // Only need one enemy from the list to lessen its complications
        for (BasicEnemy e: enemies) {
            System.out.println("looking for enemy");
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < Math.pow(e.getBattleRadius(), 2)) {
                // queue battle enemies
                queuedEnemies.add(e);
                firstEnemy = e;
                System.out.println("Found enemy");
                //break;
                // Only vampires have support radius
                // Find all the enemies for which character is within support radiu
                for (BasicEnemy s: enemies) {

                    System.out.println("looking for support");
                    // TODO: Also did not work, need to fix
                    if (Math.pow((character.getX()-s.getX()), 2) +  Math.pow((character.getY()-s.getY()), 2) < Math.pow(s.getSupportRadius(), 2)
                        && s != firstEnemy) {
                        // queue battle enemies
                        System.out.println("found support enemy");
                        queuedEnemies.add(s);
                            
                    }
                
                }
                break;
            }
        }
        
        
        // time for the battle
        for (BasicEnemy e: queuedEnemies) {


            while (e.getHealth() > 0 && character.getHealth() > 0) {
                // character attacks enemy first
                
                
                character.dealDamage(e, bonusDamage);
                System.out.println("CHARACTER DAMAGE: " + character.getDamage());

                //character.dealDamage(e, bonusDamage);
                

                // check if enemy is alive, if not skip and remove from queue + kill
                if (e.getHealth() <= 0) {
                    setGold(getGold() + e.getGold());
                    setExperience(getExperience() + e.getXP());

                    killEnemy(e);

                    
                } else {
                    // if enemy alive, then it deals damage to character
                    e.dealDamage(character);
                    //character.setHealth(100);
                    // somewhere here that we will spawn the enemy out of ally soldiers
                    
                }
            }
            
        }
        

        return queuedEnemies; 
        

        // drop items/weapons here if you want


        /*
        for (BasicEnemy e: enemies){
            // Pythagoras: a^2+b^2 < radius^2 to see if within radius
            // TODO = you should implement different RHS on this inequality, based on influence radii and battle radii
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 4){
                // fight...
                defeatedEnemies.add(e);
            }
        }

        for (BasicEnemy e: defeatedEnemies){
            // IMPORTANT = we kill enemies here, because killEnemy removes the enemy from the enemies list
            // if we killEnemy in prior loop, we get java.util.ConcurrentModificationException
            // due to mutating list we're iterating over
            killEnemy(e);
        }
        return defeatedEnemies;
        */

        /*
            finish: 
            zombie.docrit() --> do later, it is way too complicated
            vampire docrit() -> do later, too complicated
            implement staff dospecial
            make backend for equipping items
            
            later:
            building damage
            connect front end with equipping items

        */ 
    }
    

/*
    // x & y are character positions
    public isCharacterInBattleRange(int x, int y) {
        int d;

        d = (x - super.battleRadius)^2 + (y - super.battleRadius)^2

        // if inside the circle
        if (d <= battleRadius^2) {
            return true;
        } else {
            return false;
        }
    }

    public isCharacterInSupportRange(int x, int y) {
        d = (x - super.getX())^2 + (y - super.getY())^2

        // if inside the circle
        if (d <= supportRadius^2) {
            return true;
        } else {
            return false;
        }
    }

    // William Request:
    - Add in these functions
    - Change naming scheme as they're not good
    - Change from protected to private variables

*/

    /**
     * spawn a card in the world and return the card entity
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public Card loadCard(){
        // if adding more cards than have, remove the first card...
        if (cardEntities.size() >= getWidth()){
            // TODO = give some cash/experience/item rewards for the discarding of the oldest card
            removeCard(0);
        }
        Random r = new Random();
        int random = r.nextInt(7);
        
        switch(random) {
            case 0:
                VampireCastleCard vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                cardEntities.add(vampireCastleCard);
                return vampireCastleCard;
            case 1:
                ZombiePitCard zombiePitCard = new ZombiePitCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                cardEntities.add(zombiePitCard);
                return zombiePitCard;
            case 2:
                TowerCard towerCard = new TowerCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                cardEntities.add(towerCard);
                return towerCard;
            case 3:
                VillageCard villageCard = new VillageCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                cardEntities.add(villageCard);
                return villageCard;
            case 4:
                BarracksCard BarracksCard = new BarracksCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                cardEntities.add(BarracksCard);
                return BarracksCard;
            case 5:
                TrapCard trapCard = new TrapCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                cardEntities.add(trapCard);
                return trapCard;
            case 6:
                CampfireCard campfireCard = new CampfireCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
                cardEntities.add(campfireCard);
                return campfireCard;
        }
        return null;
    }

    /**
     * remove card at a particular index of cards (position in gridpane of unplayed cards)
     * @param index the index of the card, from 0 to length-1
     */
    private void removeCard(int index){
        Card c = cardEntities.get(index);
        int x = c.getX();
        c.destroy();
        cardEntities.remove(index);
        shiftCardsDownFromXCoordinate(x);
    }

    /**
     * spawn a sword in the world and return the sword entity
     * @return a sword to be spawned in the controller as a JavaFX node
     */
    
    public StaticEntity addUnequippedItem(){
        // TODO = expand this - we would like to be able to add multiple types of items, apart from swords
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest sword
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }

        Random r = new Random();
        int num = r.nextInt(6);

        switch(num) {
            case 0: 
                Sword sword = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(sword);
                return sword;
            case 1: 
                Staff staff = new Staff(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(staff);
                return staff;
            case 2:
                Stake stake = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(stake);
                return stake;
            case 3:
                Armour armour = new Armour(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(armour);
                return armour;
            case 4:
                Helmet helmet = new Helmet(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(helmet);
                return helmet;
            case 5:
                Shield shield = new Shield(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(shield);
                return shield;
                
        }
        return null;
    }

    



    public void addCharacterDraggedEntity(StaticEntity items) {
        String store = items.toString();

        /*
        switch(store) {
            case "Staff":
                System.out.println("try staff");
                Weapon staffClass = (Weapon) items;
                character.setWeapon(staffClass); 
            case "Stake":
                System.out.println("try stake");
                Weapon stakeClass = (Weapon) items;
                character.setWeapon(stakeClass);   
            case "Sword":
                System.out.println("try sword");
                Weapon swordClass = (Weapon) items;
                character.setWeapon(swordClass); 
            case "Armour":
                System.out.println("try armour");
                Armour armourClass = (Armour) items;
                character.equipArmour(armourClass);     
            case "Shield":
                System.out.println("try shield");
                Shield shieldClass = (Shield) items;
                character.equipShield(shieldClass);
        }
        */

        if (store.equals("Staff") || store.equals("Stake") || store.equals("Sword")) {
            Weapon weaponClass = (Weapon) items;
            character.setWeapon(weaponClass); 
        } else if (store.equals("Armour")) {
            Armour armourClass = (Armour) items;
            character.equipArmour(armourClass);
        } else if (store.equals("Shield")) {
            Shield shieldClass = (Shield) items;
            character.equipShield(shieldClass);
        }

    }

    

    /*
    public Sword addUnequippedSword(){
        // TODO = expand this - we would like to be able to add multiple types of items, apart from swords
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest sword
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        
        // now we insert the new sword, as we know we have at least made a slot available...
        Sword sword = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        unequippedInventoryItems.add(sword);

        return sword;
    }
    */

    /**
     * remove an item by x,y coordinates
     * @param x x coordinate from 0 to width-1
     * @param y y coordinate from 0 to height-1
     */
    public void removeUnequippedInventoryItemByCoordinates(int x, int y){
        Entity item = getUnequippedInventoryItemEntityByCoordinates(x, y);
        removeUnequippedInventoryItem(item);
    }

    /**
     * run moves which occur with every tick without needing to spawn anything immediately
     */
    public void runTickMoves() {
        if (hasMetGoal()) {
            endGame();
        }
        ApplyBuildingEffects();
        character.moveDownPath();
        moveBasicEnemies();
    }

    /**
     * Loops through current buildings and applies affects if applicable
     */
    public void ApplyBuildingEffects() {
        for (Building b : buildingEntities) {
            if (b.getX() == character.getX() && b.getY() == character.getY()) {
                System.out.println();
                System.out.println("Character on building");
                System.out.println();
                b.CharacterBuffAbility(character);
            }
            if (b.toString().equals("TrapBuilding")) {
                for (BasicEnemy e: enemies) {
                    if (e.getX() == b.getX() && e.getY() == b.getY()) {
                        b.DealDamageEnemies(e); 
                        if(e.getHealth() <= 0) killEnemy(e);
                        b.destroy();
                        break;
                    }                               
                }
            }
            
        }
    }

    /**
     * Creates a list of all the enemies created from vampire and zombie buildings.  
     * This occurs once character reaches the herocastle.
     * It then checks if the vampire buildings and zombie buildings should spawn an enemy depending on rounds building was alive.
     * @return
     */
    public List<BasicEnemy> HeroCastleEnemies() {
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (herosCastleBuilding.getX() == character.getX() && herosCastleBuilding.getY() == character.getY()) {
            setRound(herosCastleBuilding.AddCycle(getRound()));
            for (Building b: buildingEntities) {
                if (b.toString().equals("VampireCastleBuilding") && b.getBuildingAliveRounds() % 5 == 0 && b.getBuildingAliveRounds() != 0) {
                    BasicEnemy vampireEnemy = b.SpawnAbility(orderedPath);
                    enemies.add(vampireEnemy);
                    spawningEnemies.add(vampireEnemy);
                    
                } else if (b.toString().equals("ZombiePitBuilding")) {
                   BasicEnemy zombieEnemy = b.SpawnAbility(orderedPath);
                   enemies.add(zombieEnemy);
                   spawningEnemies.add(zombieEnemy);
                }
            }     
        }
        return spawningEnemies;
    }



    public List<StaticEntity> generateRandomStore() {
        // Add 7 items into the list
        List<StaticEntity> shop = new ArrayList<>();

        StaticEntity armour = new Armour(null, null);
        shop.add(armour);
        StaticEntity helmet = new Helmet(null, null);
        shop.add(helmet);
        StaticEntity shield = new Shield(null, null);
        shop.add(shield);
        StaticEntity staff = new Staff(null, null);
        shop.add(staff);
        StaticEntity stake = new Stake(null, null);
        shop.add(stake);
        StaticEntity sword = new Sword(null, null);
        shop.add(sword);
        StaticEntity healthPotion = new HealthPotion(null, null);
        shop.add(healthPotion);
        
        return shop;
    }


    public void boughtItem(StaticEntity itemBought) {
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest sword
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }

        String name = itemBought.toString();

        switch(name) {
            case "Sword": 
                Sword sword = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(sword);
            case "Staff": 
                Staff staff = new Staff(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(staff);
            case "Stake":
                Stake stake = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(stake);
            case "Armour":
                Armour armour = new Armour(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(armour);
            case "Helmet":
                Helmet helmet = new Helmet(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(helmet);
            case "Shield":
                Shield shield = new Shield(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(shield); 
            case "HealthPotion":
                Shield healthPotion = new Shield(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(healthPotion);  
                
        }

    }




        

    /**
     * remove an item from the unequipped inventory
     * @param item item to be removed
     */
    private void removeUnequippedInventoryItem(Entity item){
        item.destroy();
        unequippedInventoryItems.remove(item);
    }

    /**
     * return an unequipped inventory item by x and y coordinates
     * assumes that no 2 unequipped inventory items share x and y coordinates
     * @param x x index from 0 to width-1
     * @param y y index from 0 to height-1
     * @return unequipped inventory item at the input position
     */
    private Entity getUnequippedInventoryItemEntityByCoordinates(int x, int y){
        for (Entity e: unequippedInventoryItems){
            if ((e.getX() == x) && (e.getY() == y)){
                return e;
            }
        }
        return null;
    }

    /**
     * remove item at a particular index in the unequipped inventory items list (this is ordered based on age in the starter code)
     * @param index index from 0 to length-1
     */
    private void removeItemByPositionInUnequippedInventoryItems(int index){
        Entity item = unequippedInventoryItems.get(index);
        item.destroy();
        unequippedInventoryItems.remove(index);
    }

    /**
     * get the first pair of x,y coordinates which don't have any items in it in the unequipped inventory
     * @return x,y coordinate pair
     */
    private Pair<Integer, Integer> getFirstAvailableSlotForItem(){
        // first available slot for an item...
        // IMPORTANT - have to check by y then x, since trying to find first available slot defined by looking row by row
        for (int y=0; y<unequippedInventoryHeight; y++){
            for (int x=0; x<unequippedInventoryWidth; x++){
                if (getUnequippedInventoryItemEntityByCoordinates(x, y) == null){
                    return new Pair<Integer, Integer>(x, y);
                }
            }
        }
        return null;
    }

    /**
     * shift card coordinates down starting from x coordinate
     * @param x x coordinate which can range from 0 to width-1
     */
    private void shiftCardsDownFromXCoordinate(int x){
        for (Card c: cardEntities){
            if (c.getX() >= x){
                c.x().set(c.getX()-1);
            }
        }
    }

    /**
     * move all enemies
     */
    private void moveBasicEnemies() {
        // TODO = expand to more types of enemy
        for (BasicEnemy e: enemies){
            e.move();
        }
    }

    /**
     * get a randomly generated position which could be used to spawn an enemy
     * @return null if random choice is that wont be spawning an enemy or it isn't possible, or random coordinate pair if should go ahead
     */
    private Pair<Integer, Integer> possiblyGetBasicEnemySpawnPosition(){
        // TODO = modify this
        
        // has a chance spawning a basic enemy on a tile the character isn't on or immediately before or after (currently space required = 2)...
        Random rand = new Random();
        int choice = rand.nextInt(2); // TODO = change based on spec... currently low value for dev purposes...
        // TODO = change based on spec
        if ((choice == 0) && (enemies.size() < 2)){
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(rand.nextInt(orderedPathSpawnCandidates.size()));

            return spawnPosition;
        }
        return null;
    }

    /**
     * remove a card by its x, y coordinates
     * @param cardNodeX x index from 0 to width-1 of card to be removed
     * @param cardNodeY y index from 0 to height-1 of card to be removed
     * @param buildingNodeX x index from 0 to width-1 of building to be added
     * @param buildingNodeY y index from 0 to height-1 of building to be added
     */
    public Building convertCardToBuildingByCoordinates(int cardNodeX, int cardNodeY, int buildingNodeX, int buildingNodeY) {
        // start by getting card
        Card card = null;
        for (Card c: cardEntities){
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)){
                card = c;
                break;
            }
        }
        // if (!card.checkPlacable(buildingNodeX, buildingNodeY, orderedPath)) {
        //     return null;
        // }

        switch (card.toString()) {
            case "VampireCastleCard":
                VampireCastleBuilding vampireCastle = new VampireCastleBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
                buildingEntities.add(vampireCastle);
                DestroyCard(card, cardNodeX);
                return vampireCastle;

            case "ZombiePitCard":
                ZombiePitBuilding zombiePit = new ZombiePitBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
                buildingEntities.add(zombiePit);
                DestroyCard(card, cardNodeX);
                return zombiePit;
            case "TowerCard":
                TowerBuilding tower = new TowerBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
                buildingEntities.add(tower);
                DestroyCard(card, cardNodeX);
                return tower;
            case "VillageCard":
                VillageBuilding village = new VillageBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
                buildingEntities.add(village);
                DestroyCard(card, cardNodeX);
                return village;
            case "BarracksCard":
                BarracksBuilding barracks = new BarracksBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
                buildingEntities.add(barracks);
                DestroyCard(card, cardNodeX);
                return barracks;
            case "TrapCard":
                TrapBuilding trap = new TrapBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
                buildingEntities.add(trap);
                DestroyCard(card, cardNodeX);
                return trap;
            case "CampfireCard":
                CampfireBuilding campfire = new CampfireBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
                buildingEntities.add(campfire);
                DestroyCard(card, cardNodeX);
                return campfire;
        }
        // now spawn building
        System.out.println("PLS BRO ");
        return null;

        // destroy the card
        

        
    }

    public void DestroyCard(Card card, int cardNodeX) {
        card.destroy();
        cardEntities.remove(card);
        shiftCardsDownFromXCoordinate(cardNodeX);
    }

    public List<Pair<Integer, Integer>> getOrderedPath() {
        return orderedPath;
    }

    public IntegerProperty getCharacterHealthProperty() {
        return character.getHealthProperty();
    }
    public int getRound() {
        return round.get();
    }
    public void setRound(int round) {
        this.round.set(round);
    }
    public IntegerProperty getRoundProperty() {
        return round;
    }
    public void setGold(int gold) {
        this.gold.set(gold);
    }
    public int getGold() {
        return gold.get();
    }
    public IntegerProperty getgoldProperty() {
        return gold;
    }
    public void setExperience(int experience) {
        this.experience.set(experience);
    }
    public int getExperience() {
        return experience.get();
    }
    public IntegerProperty getExperienceProperty() {
        return experience;
    }


    public IntegerProperty getNumberAlliesProperty() {
        allyNumbers.set(character.getAllies());
        System.out.println("Ally numbers are: " + allyNumbers);
        return allyNumbers;
    }



    public void setGoal(GoalNode goal) {
        this.goal = goal;
    }
    public GoalNode getGoal() {
        return goal;
    }

    public boolean hasMetGoal() {
        return goal.hasMetGoal(this);
    }

    public boolean isGameover() {
        return gameOver;
    }

    public void endGame() {
        gameOver = true;
        if (hasMetGoal()) {
            controller.gameOver(true);
        } else {
            controller.gameOver(false);
        }
    }

    public void setHerosCastleBuilding(HerosCastleBuilding herosCastleBuilding) {
        this.herosCastleBuilding = herosCastleBuilding;
    }

    public HerosCastleBuilding getHerosCastleBuilding() {
        return herosCastleBuilding;
    }
}
