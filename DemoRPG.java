package TP_1;

public class DemoRPG {
    
        public static void main(String[] args) {

            // 1. Create characters
            Archer archer1 = new Archer("Arina", 1, 100, 80, 20);
            Warrior warrior1 = new Warrior("Nora", 1, 120, 25, 10);
            Mage mage1 = new Mage("Thor", 1, 80, 50, 30);

            // 2. Assign abilities
            archer1.addAbility(new WindShot());
            archer1.addAbility(new ForestJump());
            warrior1.addAbility(new Punch());
            warrior1.addAbility(new StoneGuard());
            mage1.addAbility(new VineTrap());
            mage1.addAbility(new ManaHeal());

            // 3. Display initial status
            System.out.println("\n--- Initial Status ---");
            archer1.displayStatus();
            warrior1.displayStatus();
            mage1.displayStatus();

            // 4. Combat simulation: 3 turns
            for (int turn = 1; turn <= 3; turn++) {
                System.out.println("\n--- Turn " + turn + " ---");

                // Archer's turn
                System.out.println("\nArcher's turn:");
                archer1.attack(warrior1);
                archer1.useAbility(0, mage1);

                // Warrior's turn
                System.out.println("\nWarrior's turn:");
                warrior1.attack(mage1);
                warrior1.useAbility(1, warrior1);

                // Mage's turn
                System.out.println("\nMage's turn:");
                mage1.attack(archer1);
                mage1.useAbility(1, mage1);

                // Display status at end of turn
                System.out.println("\n--- Status End of Turn " + turn + " ---");
                archer1.displayStatus();
                warrior1.displayStatus();
                mage1.displayStatus();
            }

            // 5. Final results
            System.out.println("\n--- Combat Finished ---");
            System.out.println("Final Status:");
            archer1.displayStatus();
            warrior1.displayStatus();
            mage1.displayStatus();
        }
    

}