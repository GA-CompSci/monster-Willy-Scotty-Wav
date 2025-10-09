import java.util.Scanner;

public class App {
    // calss variable
    private static Monster[] monsters;
    // player stats - starts at max
    private static int health = 100;
    private static int speed = 10;
    private static int shield = 50;
    private static int damage = 50;
    private static int heal = 50;
    // player state vars
    private static boolean isDefending = false;

    public static void main(String[] args) throws Exception {
        System.out.println("*MONSTER BATTLE*");

        Scanner input = new Scanner(System.in);
        System.out.print("How many Monsters will you take on: ");
        int num = input.nextInt(); // todo handle non number crash
        monsters = new Monster[num];
        // build all monsters
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Monster(); // todo add specials
        }

        // build picking
        System.out.println("*CHOOSE YOUR CHARITER*");
        System.out.println("1) FIGHTER");
        System.out.println("2) TANK");
        System.out.println("3) HEALER");
        System.out.println("4) ASSASIN");
        System.out.println("CHOICE:");
        int choice = input.nextInt(); // todo error handle on non int input

        // classes
        if (choice == 1) {
            shield -= (int) (Math.random() * 45 + 1) + 5;
            heal -= (int) (Math.random() * 46) + 5;

        } else if (choice == 2) {
            speed -= (int) (Math.random() * 9) + 1;
            heal -= (int) (Math.random() * 46) + 5;

        } else if (choice == 3) {
            damage -= (int) (Math.random() * 26) + 5;
            shield -= (int) (Math.random() * 46) + 5;

        } else {
            shield -= (int) (Math.random() * 46) + 5;
            heal -= (int) (Math.random() * 21) + 5;

        }

        // what is the % of defeated monsters?
        double result = percentComplete();

        System.out.println("Current progress: " + result + "%");

        // display monster status
        reportMonsters();

        // pick monster
        Monster currentMonster = getNextMonster();

        // game loop
        while (monsterCount(0) > 0) {
            // reset shield
            isDefending = false;
            // who goes first

            // give options
            System.out.println("OPTIONS");
            System.out.println("1) ATTACK");
            System.out.println("2) DEFEND");
            System.out.println("3) HEAL");
            System.out.println("4) REST");
            System.out.println("CHOICE:");
            choice = input.nextInt(); // todo error handle on non int input

            // actions
            if (choice == 1) {
                int dmg = (int) (Math.random() * damage + 1);
                if (dmg == damage)
                    dmg = currentMonster.health();// instaill
                else if (dmg == 0) {
                    System.out.println("*CRITICAL FAIL*");
                    System.out.println("[damage taken to self (- 10 health)]");
                    health -= 10;
                } else
                    currentMonster.takeDamage(dmg);
                    System.out.println("*THE MONSTER TOOK: " + dmg + " DAMAGE* [Current Monster Health: " + currentMonster.health() + "]");

            } else if (choice == 2) {
                isDefending = true;
                System.out.println("-SHIELD UP-");

            } else if (choice == 3) {
                int h = (int) (Math.random() * heal + 1);
                health += h;
                System.out.println("[You Healed For " + h + " Points. Current Health: " + health + "]");

            } else {
                speed++;
                System.out.println("[Your Speed Has Increased. Current Speed: " + speed + "]");

            }

            // do i need a new monster
            if (currentMonster.health() <= 0) {
                System.out.println("\n*YOU HAVE SLAIN A MONSTER*\n");
                currentMonster = getNextMonster();
                reportMonsters();
                continue; // retart loop
            }

            // monsters turn
            int speedCheck = (int) (Math.random() * 100);
            if (speedCheck <= speed) {
                System.out.println("*BOUNUS TURN*");
                continue;
            } else {
                int incomingDamage = (int) (Math.random() * currentMonster.damage() + 1);
                if (isDefending) {
                    incomingDamage -= shield;
                    if (incomingDamage < 0)
                        incomingDamage = 0;
                    System.out.println("[Your Shield Blocked " + shield + "  Damage");
                }
                health -= incomingDamage;
                System.out.println("*YOU TOOK: " + incomingDamage + " DAMAGE* [current health]:" + health);
            }

            if (health <= 0) {
                reportMonsters();
                System.out.println("*GAME OVER*");
            }
        }
    }

    public static void reportMonsters() {
        System.out.println("\n *PLAYER REPORT*");
        System.out.println("HEALTH: " + health);
        System.out.println("ATTACK POWER: " + damage);
        System.out.println("SPEED: " + speed);
        System.out.println("HEAL: " + heal);

        System.out.println("\n *MONSTER REPORT*");
        int i = 0;
        for (Monster m : monsters) {
            System.out.print("[" + i + "]");
            System.out.print("- Health: " + m.health());
            System.out.print("- Dmg: " + m.damage());
            System.out.print("- Speed: " + m.speed());
            if (!m.special().equals(""))
                System.out.print("- Special: " + m.special());

            i++;
            System.out.println();
        }
        // health bars
        int starCount = Math.max(0, (health / 5));
        String stars = "*".repeat(starCount);
        String dashes = "-".repeat(20 - starCount);
        System.out.println("[" + stars + dashes + "] - Player Health");
        System.out.print("[");
        for (int k = 0; k < monsters.length; k++)
            if (monsters[k].health() > 0) {
                System.out.print("*");
            } else {
                System.out.print("-");
            }
        System.out.println("] - Monsters left");

    }

    public static double percentComplete() {
        return (double) (100.0 - monsterCount(0) / monsters.length * 100.0);

    }

    /**
     * how many monsters have over the given health
     * 
     * @param health number to check
     * @return number of monsters above that health
     */
    public static int monsterCount(int health) {
        // how many monsters have more than 50 health
        int count = 0;
        // traverse the monsters array and find out how many have < 50 health
        for (Monster m : monsters) {
            if (m.health() > health)
                count++;
        }
        return count;
    }

    public static Monster getNextMonster() {

        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i].health() > 0)
                return monsters[i];
        }
        return null;
    }

    /**
     * returns monster from array with lowest helth
     * returns null if no monster have over 0 health
     */

    public static Monster getWeakestMonster() {
        Monster weakestMonster = getNextMonster();
        if (weakestMonster == null)
            return null;
        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i].health() > 0 && monsters[i].health() < weakestMonster.health()) {
                weakestMonster = monsters[i];
            }
        }
        return weakestMonster;
    }

}
