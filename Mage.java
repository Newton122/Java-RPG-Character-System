package TP_1;

public class Mage extends Character {
	    private int mana;
	    private int maxMana;
	    int magicPower;
	    
		public Mage(String name, int level, int maxHP, int maxMana, int magicPower) {
			super(name, level, maxHP);
			this.maxMana = Math.max(maxMana, 1);
			this.mana = this.maxMana; /*Start with full mana*/
			this.magicPower = Math.max(magicPower, 1);
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

			int damage = magicPower + (level * 2);
			System.out.println(name + " casts a spell on " + target.getName() + " for " + damage + " damage!");
			target.takeDamage(damage);
			consumeMana(10); // Basic attack consumes 10 mana
		}
		
		public int getMana() { return mana; }
		
		public void consumeMana(int amount) {
			if (amount < 0) amount = 0;
			mana -= amount;
			if (mana < 0) mana = 0;
			System.out.println(name + " now has " + mana + "/" + maxMana + " mana.");
			if (mana == 0) {
				System.out.println(name + " is out of mana!");
			}
		}
		
		//restore mana
		public void restoreMana(int amount) {
			if (!isAlive()) {
				System.out.println(name + " cannot restore mana because out of combat!");
				return;
			}
			if (amount < 0)
				amount = 0;
			mana += amount;
			if (mana > maxMana)
				mana = maxMana;
			System.out.println(name + " now has " + mana + "/" + maxMana + " mana.");
		}
		
		
		
		

}
