package unsw.loopmania;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.javatuples.Pair;
//import org.junit.jupiter.api.DisplayNameGenerator.Simple;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
import unsw.loopmania.Enemies.Doggie;
import unsw.loopmania.Enemies.ElanMuske;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.goal.GoalNode;
import unsw.loopmania.item.weapon.Sword;
import unsw.loopmania.item.weapon.Weapon;
import unsw.loopmania.item.DoggieCoin;
import unsw.loopmania.item.Gold;
import unsw.loopmania.item.ItemFactory;
import unsw.loopmania.item.consumable.HealthPotion;
import unsw.loopmania.item.consumable.TheOneRing;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.Block;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;
import unsw.loopmania.item.defensiveitem.TreeStump;
import unsw.loopmania.item.weapon.Anduril;
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
    private boolean bossSpawn = false;
    private List<Gold> goldSpawned;
    private List<HealthPotion> potionSpawned;
    private DoggieCoin doggieCoin;
    private boolean doggieDefeated;
    private boolean dogeCoinSold;
    private boolean theOneRing;

    private IntegerProperty defeatedBosses;

    // shop related fields
    private IntegerProperty nSwords;
    private IntegerProperty nStakes;
    private IntegerProperty nStaffs;
    private IntegerProperty nArmours;
    private IntegerProperty nShields;
    private IntegerProperty nHelmets;
    private IntegerProperty nPotions;


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
        this.defeatedBosses = new SimpleIntegerProperty(0);
        this.goal = null;
        this.gameOver = false;
        this.herosCastleBuilding = null;
        this.goldSpawned = new ArrayList<>();
        this.potionSpawned = new ArrayList<>();
        this.nSwords = new SimpleIntegerProperty(0);    
        this.nStakes = new SimpleIntegerProperty(0);    
        this.nStaffs = new SimpleIntegerProperty(0);    
        this.nArmours = new SimpleIntegerProperty(0);    
        this.nShields = new SimpleIntegerProperty(0);    
        this.nHelmets = new SimpleIntegerProperty(0);    
        this.nPotions = new SimpleIntegerProperty(0);    
        this.doggieCoin = new DoggieCoin(null, null);
        this.doggieDefeated = false;
        this.dogeCoinSold = false;
        this.theOneRing = false;
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

    public void setCardEntities(List<Card> listCardEntities) {
        this.cardEntities = listCardEntities;
    }

    public List<Building> getBuildingEntities() {
        return this.buildingEntities;
    }

    /**
     * add a generic entity (without it's own dedicated method for adding to the world)
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
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
            System.out.println("Spawning");
            return spawningEnemies;
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
        boolean elanExist = false;
        BasicEnemy firstEnemy = null;
        int bonusDamage = 0;
        //System.out.println("CHARACTER DAMAGE: " + character.getDamage());
        for (Building b: buildingEntities) {
            if (b.checkInRange(character.getX(), character.getY())) {
                bonusDamage += b.CharacterBattleBuffAbility(character);
                //System.out.println("BONUS DAMAGE: " + bonusDamage);
            }
        }
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();        
        List<BasicEnemy> queuedEnemies = new ArrayList<BasicEnemy>();

        
        
        // Loop through the enemy list for battle radius, then get the battling enemy
        // Only need one enemy from the list to lessen its complications
        for (BasicEnemy e: enemies) {
            System.out.println("looking for enemy");
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < Math.pow(e.getBattleRadius(), 2)) {
                queuedEnemies.add(e);
                firstEnemy = e;
                System.out.println("Found enemy");
                // Find all the enemies for which character is within support radius
                for (BasicEnemy s: enemies) {

                    System.out.println("looking for support");
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

        for (BasicEnemy b : queuedEnemies) {
            if (b.getType() == "ElanMuske") {
                elanExist = true;
            }
        }
        
        
        // time for the battle
        for (ListIterator<BasicEnemy> queuedEnemiesItr = queuedEnemies.listIterator(); queuedEnemiesItr.hasNext();) {
            BasicEnemy e = queuedEnemiesItr.next();
            int enemiesTraunched = 0;

            // System.out.println("BATTLING NOW!!");
            while (e.getHealth() > 0 && character.getHealth() > 0) {
                // character attacks enemy first
                character.dealDamage(e, bonusDamage);
                if (character.getWeapon() != null) {
                    if (character.getWeapon().toString() == "Staff" && e.getHealth() > 0) {
                        if (e.getType() == "Doggie") {
                            checkDoggieCoinFluctuate();
                        }
                        Staff staff = (Staff) character.getWeapon();
                        if (staff.getTranchedBool()) {
                            character.gainAlly();
                            killEnemy(e);
                            staff.resetTrancedBool();
                            break;
                        }
    
                    }
                }
                


                
                // check if enemy is alive, if not skip and remove from queue + kill
                if (e.getHealth() <= 0) {
                    setGold(getGold() + e.getGold());
                    setExperience(getExperience() + e.getXP());
                    
        
                    if (e.getType() == "Doggie") {

                        doggieCoin = new DoggieCoin(null,null);
                        doggieDefeated = true;
                    } 

                    
                    killEnemy(e);
 
                    
                } else {
                    // if enemy alive, then it deals damage to character
                    e.dealDamage(character);
                    
                    if (e.getType() == "Zombie" && character.getAllies() > 0 && e.doSpecial(character)) {
                        //should be  to add onto list while iterating through it
                        System.out.println("Spawning and adding zombie to list");
        
                        BasicEnemy allyZombie = new Zombie(new PathPosition(2, orderedPath));
                        queuedEnemiesItr.add(allyZombie);
                        queuedEnemiesItr.previous();
                        queuedEnemiesItr.previous();
    
          
                    }else if (e.getType() == "Vampire" && e.critDamage(character)) {
                        character.setHealth(character.getHealth() - 5);
                        System.out.println("Character health:" + character.getHealth() + " - 5 CriticalSTRIKE");
                    }

                    if (elanExist == true) {
                        if (e.getType() != "ElanMuske") {
                            // heal
                            e.setHealth(e.getHealth() + 20);
                            System.out.println("Healing this baboon: " + e.getType());
                        } else {
                            // If it is elan muske's turn, set elanExist to false and prevent healing
                            elanExist = false;

                        }
                    }
                    // somewhere here that we will spawn the enemy out of ally soldiers
                    
                }
            }
            
            
        }

        if (character.getWeapon() != null) {
            if (character.getWeapon().toString() == "Staff") {
                Staff staff = (Staff) character.getWeapon();
                int numAllies = character.getAllies() - staff.getTranched();
                if (numAllies < 0) {
                    character.setAllies(0);
                } else {
                    character.setAllies(numAllies);
                }
                
                staff.resetTranced();
            }
        }
        

        return queuedEnemies; 
        
    }

    /**
     * spawn a card in the world and return the card entity
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public Card loadCard(){
        // if adding more cards than have, remove the first card...
        if (cardEntities.size() >= getWidth()){
            // TODO = give some cash/experience/item rewards for the discarding of the oldest card
            removeCard(0);
            setGold(getGold() + 10);
            setExperience(getExperience() + 10);
            Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
            
            //addUnequippedItem();
            
            
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

            setGold(getGold() + 10);
            setExperience(getExperience() + 10);
        }

        ItemFactory itemFactory = new ItemFactory();

        StaticEntity item = itemFactory.makeItems(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));

        unequippedInventoryItems.add(item);
        

        return item;

    }
    
    public StaticEntity addUnequippedRareItem(){
        // TODO = expand this - we would like to be able to add multiple types of items, apart from swords
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest sword
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();

            setGold(getGold() + 10);
            setExperience(getExperience() + 10);
        }

        ItemFactory itemFactory = new ItemFactory();

        StaticEntity item = itemFactory.makeRareItems(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));

        if (item != null) {

            if (item.toString() == "TheOneRing") {
                System.out.println("Attached TheOneRing");
                theOneRing = true;
                return null;
            }

            unequippedInventoryItems.add(item);
            return item;
        }  

        return item;
    }

    public boolean getTheOneRingBool() {
        return theOneRing;
    }

    public void useTheOneRingBool() {
        theOneRing = false;
        character.setHealth(100);
    }

    public List<BasicEnemy> getEnemiesEntity() {
        return this.enemies;
    }

    public void setBuildingEntities(List<Building> buildingEntities) {
        this.buildingEntities = buildingEntities;
    }

    public void addCharacterDraggedEntity(StaticEntity items) {
        String store = items.toString();


        if (store.equals("Staff") || store.equals("Stake") || store.equals("Sword") || store.equals("Anduril")) {
            Weapon weaponClass = (Weapon) items;
            character.setWeapon(weaponClass); 
        } else if (store.equals("Armour")) {
            Armour armourClass = (Armour) items;
            character.equipArmour(armourClass);
        } else if (store.equals("Shield") || store.equals("TreeStump")) {
            Block shieldClass = (Block) items;
            character.equipShield(shieldClass);
        } else if (store.equals("Helmet")) {
            Helmet helmetClass = (Helmet) items;
            character.equipHelmet(helmetClass);
        }else if (store.equals("HealthPotion")) {
            HealthPotion healthpotion = (HealthPotion) items;
            healthpotion.consume(character);
            System.out.println("HEALING CHARACTER");
            // VVVV something wrong with this destroy function
            // ed forum could rpovide solution
            //healthpotion.destroy();
        }   
    }


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
        ApplyAttackDamage();
        character.moveDownPath();
        moveBasicEnemies();
        checkDoggieCoinFluctuate();        
    }

    public void ApplyAttackDamage() {
        int totalBuff = 0;
        //System.out.println("totalBuff Beginning" + totalBuff);
        for (Building b : buildingEntities) {
            System.out.println("checking for buffs");
            if (b instanceof CampfireBuilding && b.checkInRange(character.getX(), character.getY()) && !((CampfireBuilding) b).getActive()) {
                System.out.println("buffing!");
                ((CampfireBuilding) b).CharacterBattleBuffAbility(character);
                ((CampfireBuilding) b).setActive(true);
            } else if (b instanceof CampfireBuilding && ((CampfireBuilding) b).getActive() && !b.checkInRange(character.getX(), character.getY())) {
                System.out.println("debuffing...");
                ((CampfireBuilding) b).setActive(false);
                ((CampfireBuilding) b).CharacterBattleDebuffAbility(character);
            }
            if (b instanceof CampfireBuilding) {
                System.out.println("attack bonus" + character.getAlliesDamage());
                System.out.println("number of allies" + character.getAllies());
                totalBuff += ((CampfireBuilding) b).getAttackBonus();
            }
            
 
        }
        if (character.getWeapon() != null) {
            character.getWeapon().damageBoost(character);
        }
        character.setTotalDamage(totalBuff);
        //System.out.println("Total Buff is " + totalBuff);
    }

    /**
     * Loops through current buildings and applies affects if applicable
     */
    public void ApplyBuildingEffects() {
        for (Iterator<Building> iterator = buildingEntities.iterator(); iterator.hasNext();) {
            Building b = iterator.next();
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
                        iterator.remove();
                        b.destroy();
                        break;
                    }                               
                }
            } 
            
        }
    }

    public List<Gold> possiblySpawnGold() {
   
        Pair<Integer, Integer> pos = possiblyGetGoldSpawnPosition();
        List<Gold> spawningGold = new ArrayList<>();
        if (pos != null){
            SimpleIntegerProperty x = new SimpleIntegerProperty(pos.getValue0());
            SimpleIntegerProperty y = new SimpleIntegerProperty(pos.getValue1());
            Random rand = new Random();
            int chance = rand.nextInt(100);
            int value = ThreadLocalRandom.current().nextInt(20,51);

            if (chance < 4) {
                Gold drop = new Gold(x, y);
                drop.setDrop(value);
                goldSpawned.add(drop);
                spawningGold.add(drop);
                return spawningGold;
            }
        }
        return spawningGold;
    }

    public List<HealthPotion> possiblySpawnPotion() {
   
        Pair<Integer, Integer> pos = possiblyGetPotionSpawnPosition();
        List<HealthPotion> spawningPotion = new ArrayList<>();
        if (pos != null){
            SimpleIntegerProperty x = new SimpleIntegerProperty(pos.getValue0());
            SimpleIntegerProperty y = new SimpleIntegerProperty(pos.getValue1());
            Random rand = new Random();
            int chance = rand.nextInt(100);
            if (chance < 1) {
                HealthPotion drop = new HealthPotion(x, y);

                potionSpawned.add(drop);
                spawningPotion.add(drop);
                return spawningPotion;
            }
        }
        return spawningPotion;
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
            for(Building b: buildingEntities) b.addBuildingAlive();


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
            if (round.get() == 21) {
                bossSpawn = true;        
                Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
                BasicEnemy bossEnemy = herosCastleBuilding.SpawnDoggie(orderedPath, pos); 
                enemies.add(bossEnemy);
                spawningEnemies.add(bossEnemy);
                bossSpawn = false;
            } else if (round.get() == 41) {
                bossSpawn = true;        
                Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
                BasicEnemy bossEnemy = herosCastleBuilding.SpawnElanMuske(orderedPath, pos); 
                enemies.add(bossEnemy);
                spawningEnemies.add(bossEnemy);
                bossSpawn = false;    
            }

        }
        return spawningEnemies;
    }

    public void ConsumablesOnPath(){
        
        for (Iterator<Gold> iterator = goldSpawned.iterator(); iterator.hasNext();) {
            Gold goldIterator = iterator.next();
            if (goldIterator.getX() == character.getX() && goldIterator.getY() == character.getY()) {
                gold.set(gold.get() + goldIterator.getDrop()); 
                iterator.remove();
                goldIterator.destroy();
            }
        }

        for (Iterator<HealthPotion> iterator = potionSpawned.iterator(); iterator.hasNext();) {
            HealthPotion potionIterator = iterator.next();
            if (potionIterator.getX() == character.getX() && potionIterator.getY() == character.getY()) {
                potionIterator.consume(character);
                iterator.remove();
                potionIterator.destroy();
            }
        }
    }



    public List<StaticEntity> generateRandomStore() {
        // Add 7 items into the list
        List<StaticEntity> shop = new ArrayList<>();

        StaticEntity sword = new Sword(null, null);
        shop.add(sword);
        StaticEntity stake = new Stake(null, null);
        shop.add(stake);
        StaticEntity staff = new Staff(null, null);
        shop.add(staff);
        StaticEntity armour = new Armour(null, null);
        shop.add(armour);
        StaticEntity shield = new Shield(null, null);
        shop.add(shield);
        StaticEntity helmet = new Helmet(null, null);
        shop.add(helmet);
        StaticEntity healthPotion = new HealthPotion(null, null);
        shop.add(healthPotion);
        
        return shop;
    }


    public StaticEntity boughtItem(StaticEntity itemBought) {
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
                return sword;
            case "Staff": 
                Staff staff = new Staff(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(staff);
                return staff;
            case "Stake":
                Stake stake = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(stake);
                return stake;

            case "Armour":
                Armour armour = new Armour(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(armour);
                return armour;

            case "Helmet":
                Helmet helmet = new Helmet(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(helmet);
                return helmet;

            case "Shield":
                Shield shield = new Shield(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(shield); 
                return shield;

            case "HealthPotion":
                HealthPotion healthPotion = new HealthPotion(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
                unequippedInventoryItems.add(healthPotion);  
                return healthPotion;
                
        }
        return null;
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
        if (((choice == 0) && (enemies.size() < 2)) || bossSpawn){
            
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
     * get a randomly generated position which could be used to spawn gold on the map
     * @return null if random choice is that wont be spawning gold or it isn't possible, or random coordinate pair if should go ahead
     */
    private Pair<Integer, Integer> possiblyGetGoldSpawnPosition(){
        Random rand = new Random();
        if (goldSpawned.size() < 4){
            
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
    private Pair<Integer, Integer> possiblyGetPotionSpawnPosition(){        
        Random rand = new Random();
        if (potionSpawned.size() < 2){
            
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }
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
    /**
     * Figure out whether ElanMuske is alive and fluctuate doggieCoin accordingly.
     */
    public void checkDoggieCoinFluctuate(){
        boolean elanMuskeAlive = false;

        for (BasicEnemy e: enemies) {
            if (e.getType() == "ElanMuske") {
                elanMuskeAlive = true;
            }
        }
        //System.out.println("dog coin exist or nah: " + doggieCoin);
        if (doggieCoin != null) {
            //doggieCoin.fluctuate(elanMuskeAlive, getRound());
            doggieCoin.fluctuate(elanMuskeAlive, getRound());
        }
        
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
    public DoubleProperty getCharacterShieldProperty() {
        if (character.getShield() != null) {
            System.out.println("Shield Damage" + character.getShield().getDamageReduction());
            return new SimpleDoubleProperty(character.getShield().getDamageReduction());
        }
        return new SimpleDoubleProperty(0);
        
    }

    public DoubleProperty getCharacterArmourProperty() {
        if (character.getArmour() != null) {
            return new SimpleDoubleProperty(character.getArmour().getDamageReduction());
        } 
        return new SimpleDoubleProperty(0);
    }
    public DoubleProperty getCharacterHelmetProperty() {
        if (character.getHelmet() != null) {
            return new SimpleDoubleProperty(character.getHelmet().getDamageReduction());
        } 
        return new SimpleDoubleProperty(0);
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

    
    // New DoggieCoin resource.
    public int getDoggieCoin() {
        return doggieCoin.getValueProperty();
    }
    public IntegerProperty getDoggieProperty() {
        return doggieCoin.getValue();
    }
    

    public IntegerProperty getNumberAlliesProperty() {
        allyNumbers.set(character.getAllies());
        System.out.println("Ally numbers are: " + allyNumbers);
        return allyNumbers;
    }


    public IntegerProperty getCharacterDamageProperty() {
        return character.getTotalDamageProperty();  
    }

    public IntegerProperty getDefeatedBossesProperty() {
        return defeatedBosses;
    }

    public int getDefeatedBosses() {
        return defeatedBosses.get();
    }

    public void addDefeatedBoss() {
        defeatedBosses.set(defeatedBosses.get() + 1);
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

    // methods relating to sell shop functionality 
    // ===========================================
    public void updateSellingItems() {
        // initialise to 0
        nSwords.set(0);
        nStakes.set(0);
        nStaffs.set(0);
        nArmours.set(0);
        nShields.set(0);
        nHelmets.set(0);
        nPotions.set(0);

        // update number of swords, stakes, ...
        for (Entity item : unequippedInventoryItems) {
            switch(item.toString()) {
                case "Sword":
                    nSwords.set(nSwords.get() + 1);
                    break;
                case "Stake":
                    nStakes.set(nStakes.get() + 1);
                    break;
                case "Staff":
                    nStaffs.set(nStaffs.get() + 1);
                    break;
                case "Armour":
                    nArmours.set(nArmours.get() + 1);
                    break;
                case "Shield":
                    nShields.set(nShields.get() + 1);
                    break;
                case "Helmet":
                    nHelmets.set(nHelmets.get() + 1);
                    break;
                case "HealthPotion":
                    nPotions.set(nPotions.get() + 1);
                    break;
            }
        }
    }

    public IntegerProperty getnSwords() {
        return nSwords;
    }
    public IntegerProperty getnStakes() {
        return nStakes;
    }
    public IntegerProperty getnStaffs() {
        return nStaffs;
    }
    public IntegerProperty getnArmours() {
        return nArmours;
    }
    public IntegerProperty getnShields() {
        return nShields;
    }
    public IntegerProperty getnHelmets() {
        return nHelmets;
    }
    public IntegerProperty getnPotions() {
        return nPotions;
    }

    public void sellSword() {
        nSwords.set(nSwords.get() - 1);
        gold.set(gold.get() + generateItemPriceByType("Sword")/2);
    }
    public void sellStake() {
        nStakes.set(nStakes.get() - 1);
        gold.set(gold.get() + generateItemPriceByType("Stake")/2);
    }
    public void sellStaff() {
        nStaffs.set(nStaffs.get() - 1);
        gold.set(gold.get() + generateItemPriceByType("Staff")/2);
    }
    public void sellArmour() {
        nArmours.set(nArmours.get() - 1);
        gold.set(gold.get() + generateItemPriceByType("Armour")/2);
    }
    public void sellShield() {
        nShields.set(nShields.get() - 1);
        gold.set(gold.get() + generateItemPriceByType("Shield")/2);
    }
    public void sellHelmet() {
        nHelmets.set(nHelmets.get() - 1);
        gold.set(gold.get() + generateItemPriceByType("Helmet")/2);
    }
    public void sellPotion() {
        nPotions.set(nPotions.get() - 1);
        gold.set(gold.get() + generateItemPriceByType("HealthPotion")/2);
    }

    public void sellDogieCoin() {
        gold.set(gold.get() + doggieCoin.getValueProperty());
        dogeCoinSold = true;
    }

    public void removeItemByTypeInUnequippedInventoryItems(String itemType) {
        Entity deletedItem = null;
        for (Entity item : unequippedInventoryItems) {
            if (item.toString().equals(itemType)) {
                deletedItem = item;
                break;
            }
        }
        deletedItem.destroy();
        unequippedInventoryItems.remove(deletedItem);
    } 

    public int generateItemPriceByType(String itemType) {
        switch(itemType) {
            case("Sword"):
                return 20;
            case("Stake"):
                return 30;
            case("Staff"):
                return 40;
            case("Armour"):
                return 40;
            case("Shield"):
                return 50;
            case("Helmet"):
                return 20;
            case("HealthPotion"):
                return 100;
            default:        // makes ze compiler happy
                return 0;
        }
    }

    public boolean isDoggieDefeated() {
        return doggieDefeated;
    }

    public boolean isDogeCoinSold() {
        return dogeCoinSold;
    }

}
