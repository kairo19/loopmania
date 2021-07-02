## Assumptions
### GoalAssumptions:
Game is won when:
- **50** loops are made 
- and/or **100 000** experience points is earned
- and/or the player currently has **50 000** gold or more
-----------------------------------------------------------------------------------------------------------------------------------
### CharacterAssumptions:
- Character starts with **100** health points.
- Character start with **0** gold and experience points.
- Character starts with a default attack value of **X**.
- Character can hold at most **1 weapon, 1 armour, 1 shield and 1 helmet.**
- Character can hold at most **16** items in inventory.
- Character can have at most **10** allies at a time.
- Character can hold at most **5** cards at a time.
- When the character picks up a piece of equipment (with a full inventory) the oldest piece of equipment is sold for **5** gold and an additional **10** experience.
- When the character picks up a card (whilst already holding the max number of cards) the oldest card is sold for **5** gold, an additional **10** experience is received and there is a **10%** change dropiing a piece of equipment.
- Every loop completed, the character received 20 experience.
- For every 200 experience, the character's damage is increased by 2.

-----------------------------------------------------------------------------------------------------------------------------------
### EnemiesAssumptions:
#### EnemyHealthPointAssumptions:
- A slug will have **25** health points.
- A zombie will have **25** health points.
- A vampire will have **50** health points.

#### EnemyDamangeAssumptions:
- A slug will do **5** damage each attack.
- A zombie will do **10** damage each attack.
- A vampire will do **20** damage each attack.

#### EnemeyEquipmentDropRateAssumptions:
When killing an enemy, it has a chance of dropping a piece of equipment.	
- A slug has a **10%** change of dropping a piece of equipment.
- A zombie has a **20%** change of dropping a piece of equipment.
- A vampire has a **30%** change of dropping a piece of equipment.

#### EnemeyCardDropRateAssumptions:
When killing an enemy, it has a specified chance of dropping a card.
- The VampireCastleCard has a **10%** chance of dropping.
- The ZombiePitCard has a **20%** chance of dropping.
- The TowerCard has a **10%** chance of dropping.
- The VillageCard has a **10%** chance of dropping.
- The BarracksCard has a **10%** chance of dropping.
- The TrapCard has a **10%** chance of dropping.
- The CampfireCard has a **10%** chance of dropping.

#### EnemyGoldDropAssumptions:
When killing an enemy, it drops a specified amount of gold.
- A slug drops **10** amount of gold.
- A zombie drops **20** amount of gold.
- A vampire drop **100** X amount of gold.

#### EnemyExperienceEarnedAssumptions:
When killing an enemy, the hero received a specified amount of experience.	
- Killing a slug will reward the character with **10** experience.
- Killing a zombie will reward the character with **20** experience.
- Killing a vampire will reward the character with **100** experience.

#### EnemySpecialAbilitiesAssumptions:
- Zombies will have a **10%** chance of applying a critical bite against an allied soldier.
- Vampires' critical attacks are specified by a **20%** chance and causes random additional damage between 1-5 with every vampire attack, for a random number 1-5 of vampire attacks.

#### EnemyBattleSupportRadius:
- Slugs have equal battle and support radii of 1 tile.
- Zombies have an equal support radius as slugs, but a higher battle radius of 2 tiles.
- Vampires have a support radius of 4 tiles and a battle radius of 3 tiles.

#### EnemyMovementRateAssumptions:
- Slugs do not move from the path tile they spawn.
- Zombies move at a slow rate on the path of 1 tile per 5 character moves.
- Vampires move at a fast rate on the path of 1 tile per 2 character moves.

#### GeneralEnemyAssumptions:
- The damage delt by enemeies and health points of enemies will increase every X rounds by X amount.

-----------------------------------------------------------------------------------------------------------------------------------
### BuildingAssumptions:
- TowerBuildingAssumptions:
- A tower will do X amount of damage to enemies.
- A tower has a battle radius of X.
During a battle within a shooting radius of 5 tiles, enemies will be attacked by the tower for 20 damage.
An enemy passing through the trap tile is damaged for 50 HP.
Character regains 20 health when passing through the tile.
he character when within the campfire radius of 5 tiles gains double attack damage.
Prompts the player to optionally purchase items when 3 cycles is completed.
the 3 items able to be purchased at the heros castle is generated at random

- VillageBuildingAssumptions:
- When passsing through the village, the hero will regain X amount of health points.

- TrapBuildingAssumptions:
- When an enemy steps on a trap, X damage is inflicted onto the enemy.

- HeroCastleBuildingAssumptions:
- The hero will be able to purchase and sell equipment after every ... loop.

-----------------------------------------------------------------------------------------------------------------------------------
### Item Assumptions:
- Weapons are bought for X amount of gold.
- Helmets are bought for X amount of gold.
- Shields are bought for X amount of gold.
- Armour are bought for X amount of gold.

- Weapons are sold for X amount of gold.
- Helmets are sold for X amount of gold.
- Shields are sold for X amount of gold.
- Armour are sold for X amount of gold.

- Health potions are consumed when walked over.
- one ring assumptions
-----------------------------------------------------------------------------------------------------------------------------------
### Reward Assumptions:

each allied soldier adds 2 attack damage to the characters attack
2: At the end of each enemy combat, there is a 5% chance of losing one allied soldier.
the one ring has a 1% chance of dropping from a defeated enemy
health pot purchaseable for 20 gold
heals 40 character hp
has a specified chance of dropping
can be activated when cliced on 

1% chance of spawing 10 gold on a path tile
-----------------------------------------------------------------------------------------------------------------------------------
### Interaction Assumptions:
- When an ally is struck with a critical hit, from a zombie, the ally is transformed into a zombie, with full health points.
- The hero will fight the closest enemy ONLY (hero will not be fighting the supporting enemies) and the battle will be finished once the initial enemy is defeated.
Supporting enemy will not be defeated - but will initiate a battle with hero soon after (if within the range of the enemies battle radius.

- When in battle, any damage taken by the hero, will be first applied to allies and then the hero.
- The hero will have the chance to purchase equipment

- The way it's phrased indicates that it's cycles 1, 3, 6, 10. i.e. the first cycle, then you wait for 2 MORE cycles thus the third cycle, then another 3 cycles to wait thus the 6th cycle.


- an ally will tanking dmg first?
- an 
- an ally will have X amount of HP 
- enemies do a certain amount of damage
- dracula crits for ...

-----------------------------------------------------------------------------------------------------------------------------------
### Misc Assumptions:
- There can only exist one enemy per tile path, at any point in the game.
- Once the battle starts, all entities are halted until the battle is finished.

An equipped item is destroyed if another supporting item card is used to replace the currently equipped item. + sold + experience

the one ring does not occupy any of the 16 inventory slots

An equipped item is destroyed after being equiped for 5 combats.
