import java.util.Scanner;

public class App {
    // calss variable
    private static Monster[] monsters;

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

        System.out.println(monsterCount(50) + " monsters have more thatn 50 health");

        // what is the % of defeated monsters?
        double result = percentComplete();

        System.out.println("Current progress: " + result + "%");

        // display monster status
        reportMonsters();
    }

    public static void reportMonsters(){
        int i = 0;
        for(Monster m : monsters){
            System.out.print("[" + i + "]");
            System.out.print("- Health: " + m.health());
            System.out.print("- Dmg: " + m.damage());
            System.out.print("- Speed: " + m.speed());
            if(!m. special().equals(""))
                System.out.print("- Special: " + m.special());

            i++;
            System.out.println();
        }
    }

    public static double percentComplete() {
        return 100 - monsterCount(0) / monsters.length * 100;

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

}
