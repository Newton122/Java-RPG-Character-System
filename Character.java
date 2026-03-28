package TP_1;

public abstract class Character {
	
	    protected String name;
	    protected int level;
	    protected int currentHP;
	    protected int maxHP;
	    protected Ability[] abilities = new Ability[2]; // max 2 abilities

	    public Character(String name, int level, int maxHP) {
	        this.name = name;
	        this.level = Math.max(level, 1);
	        this.maxHP = Math.max(maxHP, 1);
	        this.currentHP = this.maxHP;
	    }

	    // Getters
	    public String getName() { return name; }
	    public int getLevel() { return level; }
	    public boolean isAlive() { return currentHP > 0; }

	    // Take damage (cannot go below 0)
	    public void takeDamage(int dmg) {
	        if (dmg < 0) dmg = 0;
	        currentHP -= dmg;
	        if (currentHP < 0) currentHP = 0;
	        System.out.println(name + " now has " + currentHP + "/" + maxHP + " HP.");
	    }

	    // Heal character (cannot exceed maxHP)
	    public void heal(int hp) {
	        if (!isAlive()) {
	            System.out.println(name + " cannot be healed because out of combat!");
	            return;
	        }
	        currentHP += hp;
	        if (currentHP > maxHP) currentHP = maxHP;
	        System.out.println(name + " now has " + currentHP + "/" + maxHP + " HP.");
	    }

	    // Add an ability (max 2)
	    public void addAbility(Ability ab) {
	        for (int i = 0; i < abilities.length; i++) {
	            if (abilities[i] == null) {
	                abilities[i] = ab;
	                System.out.println(name + " learned ability: " + ab.getName());
	                return;
	            }
	        }
	        System.out.println(name + " cannot learn " + ab.getName() + " (slots full)!");
	    }

	    // Use an ability by index on target
	    public void useAbility(int index, Character target) {
	        if (index < 0 || index >= abilities.length) {
	            System.out.println("Invalid ability slot!");
	            return;
	        }
	        if (abilities[index] == null) {
	            System.out.println("No ability in this slot!");
	            return;
	        }
	        abilities[index].apply(this, target);
	    }

	    // Display status
	    public void displayStatus() {
	        System.out.println("------ " + name + " ------");
	        System.out.println("Level: " + level);
	        System.out.println("HP: " + currentHP + "/" + maxHP);
	        System.out.print("Abilities: ");
	        for (Ability ab : abilities) {
	            if (ab != null) System.out.print(ab.getName() + " ");
	        }
	        System.out.println("\n");
	    }

	    // Abstract attack method (role-specific)
	    public abstract void attack(Character target);
	

}
