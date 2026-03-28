package TP_1;


 public class Warrior extends Character {
	    int strength;  // increases damage
	    private int defense;   // reduces incoming damage
	    
	    
	            public Warrior(String name, int level, int maxHP, int strength, int defense) {
	                super(name, level, maxHP);
	                // Ensure strength and defense are at least 1
	                this.strength = Math.max(strength, 1);
	                this.defense = Math.max(defense, 1);
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

					int targetDefense = 0;
			        if (target instanceof Warrior) targetDefense = ((Warrior) target).getDefense();

			        int damage = Math.max(strength - targetDefense / 2, 0); // damage reduced by half of target's defense
			        System.out.println(name + " strikes " + target.getName() + " for " + damage + " damage!");
			        target.takeDamage(damage);
			    }

			    public int getDefense() { return defense; }

			    public void increaseDefense(int amount) {
			        defense += amount;
			        System.out.println(name + "'s defense increased to " + defense);
			    
	            }
	    

}
