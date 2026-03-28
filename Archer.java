package TP_1;

import java.util.Random;

public class Archer extends Character {
	
	  private int precision;  // chance to hit
	  int agility;    // affects damage
	  private Random rand = new Random();
	  
		public Archer(String name, int level, int maxHP, int precision, int agility) {
			super(name, level, maxHP);
			// Ensure precision and agility are at least 1
			this.precision = Math.max(precision, 1);
			// Ensure precision and agility are at least 1
			this.agility = Math.max(agility, 1);
		}
		
		@Override
		public void attack(Character target) {
			if (!isAlive()) {
				System.out.println(name + " cannot attack because out of combat!");
				return;
			}
			if (!target.isAlive()) {
				System.out.println(target.getName() + " is already out of combat!");
				return;
			}

			int hitChance = rand.nextInt(100) + 1; // 1 to 100
			if (hitChance <= precision) {
				int damage = agility + (level * 2);
				System.out.println(name + " shoots an arrow at " + target.getName() + " for " + damage + " damage!");
				target.takeDamage(damage);
			} else {
				System.out.println(name + "'s attack missed!");
			}
		}
		
		


}
