
GoalAssumptions:
	Game is won when:
		50 loops are made 
		or 100 000 experience points is earned
		or the player currently has 50 000 gold or more
-----------------------------------------------------------------------------------------------------------------------------------
CharacterAssumptions:
	- Character starts with 100 health points.
	- Character start with 0 gold and experience points.
	- Character starts with a default attack value of X.
	- Character can hold at most 1 weapon, 1 armour, 1 shield and 1 helmet.
	- Character can hold at most 16 items in inventory.
	- Character can have at most 10 allies at a time.
	- Character can hold at most 10 cards at a time.

	- When the character picks up a piece of equipment (with a full inventory) the oldest piece of equipment is sold
		for the same amount of gold as when selling item at the Hero's Castle and an additional X amount of experience.

	- When the character picks up a card (whilst already holding the max number of cards) the oldest card is sold
		for X amount of gold, an additional X amount of experience and has a X chance of dropping a piece of equipment.

-----------------------------------------------------------------------------------------------------------------------------------
EnemiesAssumptions:
	- EnemyHealthPointAssumptions:
		- A slug will have X amount of health points.
		- A zombie will have X amount of health points.
		- A vampire will have X amount of health points.

	- EnemyDamangeAssumptions:
		- A slug will do X amount of damage each attack.
		- A zombie will do X amount of damage each attack.
		- A vampire will do X amount of damage each attack.

	- EnemeyEquipmentDropRateAssumptions:
		When killing an enemy, it has a X chance of dropping a piece of equipment.	
		- A slug has X change of dropping a piece of equipment.
		- A zombie has X change of dropping a piece of equipment.
		- A vampire has X change of dropping a piece of equipment.


	- EnemeyCardDropRateAssumptions:
		When killing an enemy, it has a X chance of dropping a card.
		- The VampireCastleCard has X change of dropping.
		- The ZombiePitCard has X change of dropping.
		- The TowerCard has X change of dropping.
		- The VillageCard has X change of dropping.
		- The BarracksCard has X change of dropping.
		- The TrapCard has X change of dropping.
		- The CampfireCard has X change of dropping.

	- EnemyGoldDropAssumptions:
		When killing an enemy, it drops X amount of gold.	
		- A slug drops X amount of gold.
		- A zombie drops X amount of gold.
		- A vampire dropx X amount of gold.

	- EnemyExperienceEarnedAssumptions:
		When killing an enemy, the hero received X amount of experience.	
		- Killing a slug will reward the character with X amount of experience.
		- Killing a zombie will reward the character with X amount of experience.
		- Killing a vampire will reward the character with X amount of experience.

	- EnemySpecialAbilitiesAssumptions:
		- Zombies will have a X change of applying a critical bite against an allied soldier.
		- Vampires will have a X change of appying a critical bite.
			- 
	
	- EnemyBattleSupportRadius:
		???
		- slug - equal battle and support radius of 1 tile
		- slugs spawn randomly on 


	- GeneralEnemyAssumptions:
		- The damage delt by enemeies and health points of enemies will increase every X rounds by X amount.

-----------------------------------------------------------------------------------------------------------------------------------
BuildingAssumptions:
	- TowerBuildingAssumptions:
		- A tower will do X amount of damage to enemies.
		- A tower has a battle radius of X.
	
	- VillageBuildingAssumptions:
		- When passsing through the village, the hero will regain X amount of health points.

	- TrapBuildingAssumptions:
		- When an enemy steps on a trap, X damage is inflicted onto the enemy.

	- HeroCastleBuildingAssumptions:
		- The hero will be able to purchase and sell equipment after every ... loop.

-----------------------------------------------------------------------------------------------------------------------------------
Item Assumptions:
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
Reward Assumptions:






-----------------------------------------------------------------------------------------------------------------------------------
Interaction Assumptions:
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
Misc Assumptions:
	- There can only exist one enemy per tile path, at any point in the game.
	- Once the battle starts, all entities are halted until the battle is finished.

