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
import unsw.loopmania.Cards.Card;
import unsw.loopmania.Cards.VampireCastleCard;
import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;
import unsw.loopmania.goal.GoalGold;
import unsw.loopmania.item.defensiveitem.Armour;
import unsw.loopmania.item.defensiveitem.Helmet;
import unsw.loopmania.item.defensiveitem.Shield;
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

        for (int i = 0; i < 20; i++) {
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
        d.setGoal(new GoalGold(d, 50));
        Vampire vampire = new Vampire(new PathPosition(2, orderedpath));
        Zombie zombie = new Zombie(new PathPosition(1, orderedpath));
        
        d.runTickMoves();

        List<BasicEnemy> basicEnemies = d.runBattles();

        assertEquals(basicEnemies.size(), 0);
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
    public void TestheroCastleEnemies(){

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

        //VampireCastleCard vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
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


}