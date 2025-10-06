public class Monster {
    // instance variables (properties)
    private int health;
    private double damage; 
    private int speed; 
    private String special;

    // constructor
    public Monster(){
        // random generator for health, damage, and speed
        health = (int)(Math.random() * 81) + 20;
        // random 10-50
        damage = (Math.random() * 41) + 10;
        //speed 1-10
        speed = (int)(Math.random() * 10) + 1;
        // by deful the moster doesnt have special move
        special = "";
    }
    // overloaded constructor
    public Monster(String special){
        this();
        this.special = special;
    }

    // accessor methods
    public int health () { return health;}
    public double damage() {return Math.round(damage * 100.0) / 100.0;}
    public int speed () {return this.speed;}
    public String special() {return this.special;}

    //mutator methods
    public void takeDamage(int dmg){
        health -= dmg;
        
    }
    

}
