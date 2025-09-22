import java.util.Scanner;

public class App {
    // calss variable
    private static Monster[] monsters;
    public static void main(String[] args) throws Exception {
        System.out.println("*MONSTER BATTLE*");

        Scanner input = new Scanner(System.in);
        System.out.print("How many Monsters will you take on: ");
        int num = input.nextInt(); // todo handle non number crash
        Monster[] monster = new Monster[num];
        // build all monsters
        for(int i = 0; i < monster.length; i ++){
            monster[i] = new Monster(); // todo add specials
        }
        System.out.println(count + " monsters have more thatn 50 health");
    }
    /**
     * how many monsters have over the given health
     * @param health number to check
     * @return number of monsters above that health
     */
    public static int monsterCount(int healt, Monster[] arr){
  // how many monsters have more than 50 health
        int count = 0;
        // traverse the monsters array and find out how many have < 50 health
        for(Monster m : monsters){
           if (m.health() > health) count ++; 
        }
        return count;
    }
    public static Monster getNextMonster(){

        for(int i = 0; i, monsters.lenght; i++){
        if(monsters{i}.health() > 0) return monsters[i];
        }
        return null;
    }
}
