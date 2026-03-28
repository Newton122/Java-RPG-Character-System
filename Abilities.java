package TP_1;

//Archer Abilities
class WindShot implements Ability {
 public String getName() { return "WindShot"; }
 public void apply(Character user, Character target) {
     if (!user.isAlive() || !target.isAlive()) return;
     int damage = 10 + ((Archer) user).agility; // scales with agility
     System.out.println(user.getName() + " uses WindShot on " + target.getName() + " for " + damage + " damage!");
     target.takeDamage(damage);
 }
}

class ForestJump implements Ability {
 public String getName() { return "ForestJump"; }
 public void apply(Character user, Character target) {
     if (!user.isAlive()) return;
     int heal = 10 + (user.getLevel() * 2); // scales with level
     System.out.println(user.getName() + " uses ForestJump to restore " + heal + " HP!");
     user.heal(heal);
 }
}

//Warrior Abilities
class Punch implements Ability {
 public String getName() { return "Punch"; }
 public void apply(Character user, Character target) {
     if (!user.isAlive() || !target.isAlive()) return;
     int damage = ((Warrior) user).strength + (user.getLevel() * 2);
     System.out.println(user.getName() + " uses Punch on " + target.getName() + " for " + damage + " damage!");
     target.takeDamage(damage);
 }
}

class StoneGuard implements Ability {
 public String getName() { return "StoneGuard"; }
 public void apply(Character user, Character target) {
     if (!user.isAlive()) return;
     int boost = 5 + (user.getLevel() / 2); // scales with level
     ((Warrior) user).increaseDefense(boost);
 }
}

//Mage Abilities
class VineTrap implements Ability {
 public String getName() { return "VineTrap"; }
 public void apply(Character user, Character target) {
     if (!user.isAlive() || !target.isAlive()) return;
     Mage m = (Mage) user;
     if (m.getMana() < 15) {
         System.out.println(m.getName() + " does not have enough mana to cast VineTrap!");
         return;
     }
     int damage = m.magicPower + (user.getLevel() * 3);
     System.out.println(m.getName() + " casts VineTrap on " + target.getName() + " for " + damage + " damage!");
     target.takeDamage(damage);
     m.consumeMana(15);
 }
}

class ManaHeal implements Ability {
 public String getName() { return "Mana Heal"; }
 public void apply(Character user, Character target) {
     if (!user.isAlive()) return;
     Mage m = (Mage) user;
     int restore = 10 + (user.getLevel() * 2); // scales with level
     System.out.println(m.getName() + " uses Mana Heal to restore " + restore + " mana!");
     m.restoreMana(restore);
 }
}