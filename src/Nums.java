import java.util.ArrayList;
import java.util.Scanner;

public class Nums {
    public static void main(String[] args){
        //array list are upgraded and flexable arrays with xtra tools
        ArrayList<String> names = new ArrayList<>();

        Scanner s = new Scanner (System.in);
        System.out.println("Enter Name: ");
        String input = s.nextLine();
        while(!input.equals("")){
            names.add(input);
            System.out.println("Enter Next Name: ");
            input = s.nextLine();
        }

         while(!input.equalsIgnoreCase("quit")|| names.size() == 0){
            int r = (int)(Math.random() * names.size());
            System.out.println("Random Name Selected: " + names.get(r));
            names.remove(r);
            System.out.println("Enter For Another Name | or QUIT To Exit");
            input = s.nextLine();
        }
    }
}
