## Assumptions
 ***Note: current values are only placeholder values and are subject to change.***

### CharacterAssumptions:
- Character starts with **100** health points.
- Character start with **0** gold and experience points.
- Character starts with a default attack value of **5**.
- Character can hold at most **1 weapon, 1 armour, 1 shield and 1 helmet.**
- Character can hold at most **16** items in inventory.
- Character can have at most **10** allies at a time.
- Character can hold at most **5** cards at a time.
- When the character picks up a piece of equipment (with a full inventory) the oldest piece of equipment is sold for **5** gold and an additional **10** experience.
- When the character picks up a card (whilst already holding the max number of cards) the oldest card is sold for **5** gold, an additional **10** experience is received and there is a **10%** change dropiing a piece of equipment.
- Every loop completed, the character received **20** experience.
- For every 200 experience, the character's damage is increased by **2**.

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
- 70% chance to drop one of the 7 cards.

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
- Vampires' critical attacks are specified by a **20%** chance and causes random additional damage between 1-5 with every vampire attack, for a random number **1-5** of vampire attacks.

#### EnemyBattleSupportRadius:
- Slugs have equal battle and support radii of **1** tile.
- Zombies have an equal support radius as slugs, but a higher battle radius of **2** tiles.
- Vampires have a support radius of **4** tiles and a battle radius of **3** tiles.

#### EnemyMovementRateAssumptions:
- Slugs do not move from the path tile they spawn.
- Zombies move at a slow rate on the path of **1 tile per 5 character moves**.
- Vampires move at a fast rate on the path of **1 tile per 2 character moves**.

#### GeneralEnemyAssumptions:
- For every **10** loops completed, the health points and attack damage of *all* enemies are increased by **5**.

-----------------------------------------------------------------------------------------------------------------------------------
### BuildingAssumptions:
- Allow Buildings to be placed over existing buildings. Effects will still continue
#### TowerBuildingAssumptions:
- During a battle within a shooting radius of **5** tiles, enemies will be attacked by the tower for **20** damage.

#### VillageBuildingAssumptions:
- When passsing through the village, the hero will regain **20** health points.
- villagebuilding can overheal character

#### TrapBuildingAssumptions:
- When an enemy steps on a trap, **50** damage is inflicted onto the enemy.

#### CampfireBuildingAssumptions:
- The campfire has an effect radius of **5** tiles.
- When stacking campfires, each campfire stores the double the characters damage at that point in time and will 
  not reset until character is out of range.
#### HeroCastleBuildingAssumptions:
- The hero will be able to purchase all types of items in the hero's castle building.

-----------------------------------------------------------------------------------------------------------------------------------
### Item Assumptions:
***All pieces of equipment destroyed will reward the character with half the gold it is purchased for.***
#### WeaponAssumptitions:
##### SwordAssumptions:
- A sword can be purchased for **20** gold from the hero's castle.
- A sword adds **15** additional damage to the character's attack.

##### StakeAssumptions:
- A stake can be purchased for **40** gold from the hero's castle.
- A stake adds **5** additional damage to the character's attack.
- A stake increases that character's attack damage significantly by **50%** when combating vampires.

##### StaffAssumptions:
- A staff can be purchased for **40** gold from the hero's castle.
- A staff adds **2** additional damage to the character's attack.
- A staff has a 10% chance of temporarily converting an enemy into an allied soldier, during combat.


#### DefensiveItemAssumptions:
##### ArmourAssumptions:
- Armour can be purchased for **40** gold from the hero's castle.

##### ShieldAssumptions:
- A shield can be purchased for **50** gold from the hero's castle.

##### HelmetAssumptions:
- A helmet can be purchased for **20** gold from the hero's castle.
- A helmet reduces enemy attack by **10**.
- A helmet reduced the character's attack by **10**.

#### ConsumableItemAssumptions:
- Health potions can be purchased for **20** gold from the hero's castle.
- Health potions heal the character for **40** health points.
- Health potions are consumed immediately when stepped over or purchased from the hero's castle.
- Health potions can overheal character.

#### RareItemAssumptions:
- The One Ring has a **1%** chance of dropping from a defeated enemy.
-----------------------------------------------------------------------------------------------------------------------------------
### Interaction Assumptions:
#### AllyAssumptions:
- Each allied soldier adds **2** attack damage to the characters attack.
- Each allied soldier has **25** health points.
- At the end of each enemy combat, there is a **5%** chance of losing one allied soldier.
- When an ally is struck with a critical hit, from a zombie, the ally is transformed into a zombie, with ***full health points.***
- The hero will fight the closest enemy **ONLY** (hero will not be fighting the supporting enemies) and the battle will be finished ***once the initial enemy is defeated.*** The supporting enemy will not be defeated - but will initiate a battle with hero soon after (if within the range of the enemies battle radius.
- When in battle, any damage taken by the hero, ***will be first applied to allies and then the hero***. 
-----------------------------------------------------------------------------------------------------------------------------------
### Misc Assumptions:
- There can only exist ***one enemy per tile path***, at any point in the game.
- Once the battle starts, *all* entities are halted until the battle is finished.
- An equipped item is destroyed if another supporting item card is used to replace the currently equipped item. The specified amount of gold and experience (above) is received by the character in return.
- An equipped item is destroyed after being equiped for **5** combats.
