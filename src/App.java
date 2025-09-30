import java.util.Scanner;

public class App {
    // calss variable
    private static Monster[] monsters;
    //player stats
    private static int health = 100;
    private static int speed = 10;
    private static int shield = 50;
    private static int damage = 50;
    private static int heal = 50;

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
        System.out.println("*1) FIGHTER*");
        System.out.println("*2) TANK*");
        System.out.println("*3) HEALER*");
        System.out.println("*4) ASSASIN*");
        System.out.println("*CHOICE:");
        int choice = input.nextInt(); //todo error handle on non int input

        //classes
        if(choice == 1){


        }else if (choice == 2){

        }else if (choice == 3){

        }else {

        }

        // what is the % of defeated monsters?
        double result = percentComplete();

        System.out.println("Current progress: " + result + "%");

        // display monster status
        reportMonsters();

        // pick monster
        Monster currentMonster = getNextMonster();

        //game loop
    while(monsterCount(0) > 0){
        //who goes first

        //give options
        System.out.println("*OPTIONS*");
        System.out.println("*1) ATTACK*");
        System.out.println("*2) DEFEND*");
        System.out.println("*3) HEAL*");
        System.out.println("*4) REST*");
        System.out.println("*CHOICE:");
        choice = input.nextInt(); //todo error handle on non int input

        //actions
        if(choice == 1){

        }else if (choice == 2){

        }else if (choice == 3){

        }else {

        }

        //do i need a new monster
        if(currentMonster.health() <= 0)
        System.out.println("\n*YOU HAVE SLAIN A MONSTER*\n");
        currentMonster = getNextMonster();
        reportMonsters();


    }

    public static void reportMonsters(){
        System.out.println("\n *MONSTER REPORT*");
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
