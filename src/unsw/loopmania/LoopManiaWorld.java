package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Buildings.BarracksBuilding;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.CampfireBuilding;
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
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.item.weapon.Sword;
import unsw.loopmania.item.weapon.Weapon;

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

    /**
     * list of x,y coordinate pairs in the order by which moving entities traverse them
     */
    private List<Pair<Integer, Integer>> orderedPath;

    private int round;
    private int gold; 
    private int experience;
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
        this.round = 1;
        this.gold = 0;
        this.experience = 0;
        this.goal = null;
        this.gameOver = false;
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
        // TODO = expand this very basic version
        Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (pos != null){
            int indexInPath = orderedPath.indexOf(pos);
            //BasicEnemy enemy = new BasicEnemy(new PathPosition(indexInPath, orderedPath));

            
            Random r = new Random();
            int num = r.nextInt(2);

            // TODO: SUSS OUT ON THE SPAWNING LOCATION!!!!!!
            
            switch(num) {
                // Slugs spawning
                case 0:
                    Slug slug = new Slug(new PathPosition(indexInPath, orderedPath));
                    enemies.add(slug);
                    spawningEnemies.add(slug);
                    return spawningEnemies;

                // Zombies spawning
                case 1:
                    Zombie zombie = new Zombie(new PathPosition(indexInPath, orderedPath));
                    enemies.add(zombie);
                    spawningEnemies.add(zombie);
                    return spawningEnemies;

            }

            //enemies.add(enemy);
            //spawningEnemies.add(enemy);
        }
        return spawningEnemies;
        
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
        // BasicEnemy firstEnemy;
        // int extraDamage = 0;
        // boolean campfirePresent = false;

        // Stores all the defeated enemies
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();

        
        // Stores all the enemies within battle and support radius (no duplicates)
        //List<BasicEnemy> queuedEnemies = new ArrayList<BasicEnemy>();


        /*
        // Loop through the enemy list for battle radius, then get the battling enemy
        // Only need one enemy from the list to lessen its complications
        for (BasicEnemy e: enemies) {
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < Math.pow(e.getBattleRadius(), 2)) {
                // queue battle enemies
                queuedEnemies.add(e);
                firstEnemy = e;
                break;
            }
        }
        
        // Only vampires have support radius
        // Find all the enemies for which character is within support radius
        for (BasicEnemy e: enemies) {
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < Math.pow(e.getSupportRadius(), 2)
                && e != firstEnemy) {
                // queue battle enemies
                queuedEnemies.add(e);
                break;
            }
        }

        // Finding character buffs available in the characters radius for battle
        for (Building b: buildingEntities) {
            if (b.toString() == "Tower") {
                extraDamage += b.getDamage();
            } else if (b.toString() == "Campfire") {
                // current implementation is to double the base damage
                // can do total damage otherwise.
                extraDamage += character.getDamage();
            }
        }



        // time for the battle
        for (BasicEnemy e: queuedEnemies) {

            while (e.getHealth() > 0 && character.getHealth() > 0) {
                // character attacks enemy first
                
                character.dealDamage(e);
                //character.dealDamage(e, bonusDamage);

                // check if enemy is alive, if not skip and remove from queue + kill
                if (e.getHealth() <= 0) {
                    gold += e.getGold();
                    xp += e.getXP();
                    killEnemy(e);
                } else {
                    // if enemy alive, then it deals damage to character
                    e.dealDamage(character);

                }
            }
        }
        

        return queuedEnemies;
        */
        

        // drop items/weapons here if you want


        




        /*
            Adjustments Request:
            dealDamage(character, extraDamage);

            extraDamage -> buffs received from the extra damage



        */

        
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
        character.moveDownPath();
        moveBasicEnemies();
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
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }

    public void setRound(int round) {
        this.round = round;
    }
    public int getRound() {
        return round;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public int getGold() {
        return gold;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getExperience() {
        return experience;
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
            controller.gameOver("YOU WON!");
        } else {
            controller.gameOver("YOU LOST!");
        }
    }
}
