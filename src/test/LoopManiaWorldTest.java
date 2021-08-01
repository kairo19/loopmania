package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import org.javatuples.Pair;

import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.CampfireBuilding;
import unsw.loopmania.Buildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.ZombiePitBuilding;
import unsw.loopmania.Buildings.HerosCastleBuilding;
import unsw.loopmania.Cards.Card;
import unsw.loopmania.Cards.VampireCastleCard;
import unsw.loopmania.Cards.ZombiePitCard;
import unsw.loopmania.Cards.TowerCard;
import unsw.loopmania.Cards.VillageCard;
import unsw.loopmania.Cards.BarracksCard;
import unsw.loopmania.Cards.TrapCard;
import unsw.loopmania.Cards.CampfireCard;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.goal.GoalGold;
import unsw.loopmania.item.consumable.HealthPotion;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;
import unsw.loopmania.item.weapon.Staff;
import unsw.loopmania.item.weapon.Stake;
import unsw.loopmania.item.weapon.Sword;
import unsw.loopmania.item.weapon.Weapon;
import unsw.loopmania.Character;

public class LoopManiaWorldTest {


    @Test
    public void TestpossiblySpawnEnemies(){
        int checker = 0;
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        for (int i = 0; i < 60; i++) {
            List<BasicEnemy> basicEnemies = d.possiblySpawnEnemies();
            if (basicEnemies.size() == 1) {
                checker ++;
            }
        }
        
        assertEquals(checker, 2);
    }
    @Test
    public void TestrunBattles(){
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        d.possiblySpawnEnemies();
        d.setGoal(new GoalGold(d, 10000));
        Staff staff = new Staff(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        character.setWeapon(staff);
        for (int i = 0; i < 20; i ++) {
            character.gainAlly();
        }
        
        
        for (int i = 0; i < 150; i++) {
            d.possiblySpawnGold();
            d.possiblySpawnPotion();
            d.runTickMoves();
            d.possiblySpawnEnemies();
            d.runBattles();
        }


        assertEquals(0, character.getHealth());
    }

    @Test
    public void boughtItemsTest(){
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);
        d.possiblySpawnEnemies();
        d.setGoal(new GoalGold(d, 10000));
        Sword sword = new Sword (new SimpleIntegerProperty(), new SimpleIntegerProperty());
        Staff staff = new Staff(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        Stake stake = new Stake(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        Armour armour = new Armour(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        Helmet helmet = new Helmet(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        Shield shield = new Shield(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        HealthPotion healthPotion = new HealthPotion(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        
        character.setWeapon(staff);

        d.generateRandomStore();
        
        d.boughtItem(sword);
        d.boughtItem(staff);
        d.boughtItem(stake);
        d.boughtItem(armour);
        d.boughtItem(helmet);
        d.boughtItem(shield);
        d.boughtItem(healthPotion);
        d.updateSellingItems();
        d.sellSword();
        d.sellStaff();
        d.sellStake();
        d.sellArmour();
        d.sellHelmet();
        d.sellShield();

        assertEquals(staff, character.getWeapon());
    }

    @Test
    public void TestloadCard() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
         
        d.setCharacter(character);
        for (int i = 0; i < 10; i++) {
            d.loadCard();
        }
    
        assertEquals(d.getGold(), 60);
        
    }

    @Test
    public void TestaddUnequippedItem(){
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        for (int i = 0; i < 17; i++) {
            d.addUnequippedItem();
        }
    
        assertEquals(d.getGold(), 10);
    }

    @Test
    public void TestaddCharacterDraggedEntity(){
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        Armour armour = new Armour(null, null);
        Shield shield = new Shield(null, null);
        Helmet helmet = new Helmet(null, null);
        Sword sword = new Sword(null, null);
        d.addCharacterDraggedEntity(armour);
        d.addCharacterDraggedEntity(shield);
        d.addCharacterDraggedEntity(helmet);
        d.addCharacterDraggedEntity(sword);

        assertEquals(character.getArmour(), armour);

        assertEquals(character.getShield(), shield);

        assertEquals(character.getHelmet(), helmet);

        assertEquals(character.getWeapon(), sword);

    }


    @Test
    public void TestconvertCardToBuildingByCoordinate() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        SimpleIntegerProperty zeroProperty = new SimpleIntegerProperty(0);
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);

        Card card = new VampireCastleCard(zeroProperty, oneProperty);
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(card);
        d.setCardEntities(cardList);
        Building newBuilding = d.convertCardToBuildingByCoordinates(0, 1, 1, 1);
        List<Building> buildingEntities = d.getBuildingEntities();
        assertEquals(newBuilding, buildingEntities.get(0));
    }

    @Test
    public void TestconvertCardToBuildingByCoordinate2() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        SimpleIntegerProperty zeroProperty = new SimpleIntegerProperty(0);
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);

        Card card = new ZombiePitCard(zeroProperty, oneProperty);
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(card);
        d.setCardEntities(cardList);
        Building newBuilding = d.convertCardToBuildingByCoordinates(0, 1, 1, 1);
        List<Building> buildingEntities = d.getBuildingEntities();
        assertEquals(newBuilding, buildingEntities.get(0));
    }

    @Test
    public void TestconvertCardToBuildingByCoordinate3() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        SimpleIntegerProperty zeroProperty = new SimpleIntegerProperty(0);
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);

        Card card = new TowerCard(zeroProperty, oneProperty);
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(card);
        d.setCardEntities(cardList);
        Building newBuilding = d.convertCardToBuildingByCoordinates(0, 1, 1, 1);
        List<Building> buildingEntities = d.getBuildingEntities();
        assertEquals(newBuilding, buildingEntities.get(0));
    }

    @Test
    public void TestconvertCardToBuildingByCoordinate4() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        SimpleIntegerProperty zeroProperty = new SimpleIntegerProperty(0);
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);

        Card card = new CampfireCard(zeroProperty, oneProperty);
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(card);
        d.setCardEntities(cardList);
        Building newBuilding = d.convertCardToBuildingByCoordinates(0, 1, 1, 1);
        List<Building> buildingEntities = d.getBuildingEntities();
        assertEquals(newBuilding, buildingEntities.get(0));
    }

    @Test
    public void TestconvertCardToBuildingByCoordinate5() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        SimpleIntegerProperty zeroProperty = new SimpleIntegerProperty(0);
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);

        Card card = new VillageCard(zeroProperty, oneProperty);
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(card);
        d.setCardEntities(cardList);
        Building newBuilding = d.convertCardToBuildingByCoordinates(0, 1, 1, 1);
        List<Building> buildingEntities = d.getBuildingEntities();
        assertEquals(newBuilding, buildingEntities.get(0));
    }

    @Test
    public void TestconvertCardToBuildingByCoordinate6() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        SimpleIntegerProperty zeroProperty = new SimpleIntegerProperty(0);
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);

        Card card = new BarracksCard(zeroProperty, oneProperty);
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(card);
        d.setCardEntities(cardList);
        Building newBuilding = d.convertCardToBuildingByCoordinates(0, 1, 1, 1);
        List<Building> buildingEntities = d.getBuildingEntities();
        assertEquals(newBuilding, buildingEntities.get(0));
    }

    @Test
    public void TestconvertCardToBuildingByCoordinate7() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        SimpleIntegerProperty zeroProperty = new SimpleIntegerProperty(0);
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);

        Card card = new TrapCard(zeroProperty, oneProperty);
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(card);
        d.setCardEntities(cardList);
        Building newBuilding = d.convertCardToBuildingByCoordinates(0, 1, 1, 1);
        List<Building> buildingEntities = d.getBuildingEntities();
        assertEquals(newBuilding, buildingEntities.get(0));
    }

    @Test
    public void TestHeroCastleEnemiesZombie() {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        //System.out.println("position: " + character.getX() + "  "  + character.getY());
        d.setCharacter(character);

        SimpleIntegerProperty zeroProperty = new SimpleIntegerProperty(0);
        SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);
        SimpleIntegerProperty twoProperty = new SimpleIntegerProperty(2);

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(oneProperty, oneProperty);
        d.setHerosCastleBuilding(herosCastleBuilding);

        ZombiePitBuilding zombieBuilding = new ZombiePitBuilding(zeroProperty, oneProperty);
        VampireCastleBuilding vampireBuilding = new VampireCastleBuilding(zeroProperty, oneProperty);
        CampfireBuilding campfireBuilding = new CampfireBuilding(oneProperty, twoProperty);

        List<Building> buildingEntities = d.getBuildingEntities();
        buildingEntities.add(zombieBuilding);
        buildingEntities.add(vampireBuilding);
        buildingEntities.add(campfireBuilding);

        d.setBuildingEntities(buildingEntities);
        d.ApplyAttackDamage();
        
        // increase cycles count
        //System.out.println("step 1");
        //d.setRound(2);
        //System.out.println("step 2");

        // this is meant to add enemies
        for (int i = 0; i < 100; i++) {
            d.HeroCastleEnemies();
            d.ApplyBuildingEffects();
        }
        

        //System.out.println("step 3");

        List<BasicEnemy> enemyList = d.getEnemiesEntity();

        //System.out.println("step 4");

        assertEquals(enemyList.get(0).getType(), "Zombie");
        assertEquals(101, d.getRound());
        //System.out.println("step 5");


    }
    @Test
    public void ConsumablesOnPathTest () {
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        for (int i = 0; i < 200; i++) {
            d.possiblySpawnPotion();
            d.possiblySpawnGold();
            character.moveDownPath();
            d.ConsumablesOnPath();
        }
        
        boolean checker = false;
        if (d.getGold() > 0) {
            checker = true;
        }

        assertEquals(true, checker);

    }

    @Test
    public void TestaddUnequippedRareItem(){
        List<Pair<Integer, Integer>> orderedpath  = new ArrayList<>();
        orderedpath.add(new Pair<Integer, Integer>(1, 1));
        orderedpath.add(new Pair<Integer, Integer>(2, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 1));
        orderedpath.add(new Pair<Integer, Integer>(3, 2));
        orderedpath.add(new Pair<Integer, Integer>(3, 3));
        orderedpath.add(new Pair<Integer, Integer>(2, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 3));
        orderedpath.add(new Pair<Integer, Integer>(1, 2));
        LoopManiaWorld d = new LoopManiaWorld(4, 4, orderedpath);
        Character character = new Character(new PathPosition(0, orderedpath));
        d.setCharacter(character);

        for (int i = 0; i < 10000; i++) {
            d.addUnequippedRareItem();
        }
        boolean checker = false;
        if (d.getGold() > 0) {
            checker = true;
        }
    
        assertEquals(true, checker);
    }



    

    



}