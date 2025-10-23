
import java.util.ArrayList;


public class NumSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ROUND 1 tests
        */
        
        // Create a random int array of a given length, low and high end of range
        int[] randArray = randArray(15, 0, 100);
        
        // Create a random Integer ArrayList of given length, low and high range
        ArrayList<Integer> randArrL = randArrL(8, 5, 50);
        
        // How many similar elements are in a given array and ArrayList
        System.out.print("There are this many similar elements: ");
        System.out.println(compareNums(randArray, randArrL));
        
        // printPretty takes an int array and prints it out nicely
        printPretty(randArray);
        // printPretty takes an Integer ArrayList and prints it out nicely
        printPretty(randArrL);
        
        /*
        ROUND 2 tests
        */
        
        // shuffle randomizes an int array (then calls printPretty)
        shuffle(randArray);
        
        // shuffle randomizes an Integer ArrayList (then calls printPretty)
        shuffle(randArrL);
        
        // divide all numbers by two
        divByTwo(randArray);
        divByTwo(randArrL);
        
        //sumArray
        sumArray(randArray);
        sumArray(randArrL);
        
    }
    /*
    ROUND 1 code
    */
    
    // TODO: randArray
    public static int[] randArray(int length, int low, int high){
        int[] result = new int[length];
        for(int i = 0; i < result.length; i++){
            int rand = (int)(Math.random() * (high - low + 1)) + low;
            result[i] = rand;
        }

        return result;
    }
    
    // TODO: randArrL
    public static ArrayList<Integer> randArrL(int length, int low, int high){
        ArrayList<Integer> result = new ArrayList<>();
        //traversal
        for(int i = 0; i < length; i++){
            //
            int rand = (int)(Math.random() * (high - low + 1)) + (low);
            result.add(rand);
        }

        return result;
    }
    
    // TODO: compareNums
    public static int compareNums(int[] arr, ArrayList<Integer> intMc){
        int count = 0;
        ArrayList<Integer> same = new ArrayList<>();
        // traverse array
        for(int num1 : arr){
            //OPTION 1
            if(intMc.contains(num1)) count++;

            //OPTION 2
            //find if there is a match and count it
            for(int num2 : intMc){
                if(num1 == num2) {
                    count ++;
                    break; // stop to not hav repeats and move to next int
            }
        }

        return count;
    }
    

    // TODO: prettyPretty (overloaded)
    public static void printPretty((int[] arr){
        //traverse and print well organized
        for(int i = 0; i < result.length; i++){
            System.out.println( i );
        }
       
       

    }

    public static void printPretty((ArrayList<Integer> arr){
        for(int num : arr){
            System.out.println( num + " " );
        }
        System.out.println();
    }
    
    /*
    ROUND 2 code
    */
    
    // TODO: shuffle array
    public static void shuffle(int[] arr){
        //traversal with 4 loop
        for(int i = 0; i < arr.length; i++){
           //pick random indes locatio 0 -> arr.lenght
           int r = (int)(Math.random() * arr.length);
            //THREE PART SWAP:
             //copy arr[random] to a temp
            int temp = arr[r];  
            //move arr[i] to arr[random]
            arr[r] = arr[i];
            //move temp to arr[i] 
            arr[i] = temp;
        }
    }
    
    // TODO: shuffle ArrayList
    public static void shuffle(ArrayList <Integer> aList) {
        for(int i = 0; i < aList.size(); i++)){
            int r = (int)(Math.random() * aList.size());
            //three part swap
            int temp = aList.get(r);
            aList.set(r, aList.get(i));
            aList.set(i, temp);
        }
    }
    
    // TODO: divByTwo (overloaded)
    public static void divByTwo(int[] arr){
        for(int i = 0; i < arr.length; i++) arr[i] /= 2;
    }
    

    public static void divByTwo(ArrayList<Integer> aList){
        for(int i = 0; i < aList.size(); i++) aList.set(i, aList.get(i)/2);
    }
    
    
    // TODO: sumArray (overloaded)
    public static int sumArray(int[] arr){
        int sum = 0;
        for(int num:arr) sum += num;
        return sum;
    }

    public static int sumArray(ArrayList<Integer> aList){
        int sum = 0;
        for(int num:aList) sum += num;
        return sum;
    }
}