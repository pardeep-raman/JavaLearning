package oopsConcepts.abstraction;

interface Utensils{
    void useBowl();
}

interface Ingredients extends Utensils{
    void addWater();
    void addRice();
}

interface Spices{
    void addSalt();

    default void addPepper(){
        System.out.println("Pepper added.");
    }

    static void addGinger(){
        System.out.println("Ginger added.");
    }
}

abstract class Food {
    Food() {
        System.out.println("Make food.");
    }

    abstract void cook();

    final void foodReady(){
        System.out.println("Food ready.");
    }

    void serveFood() {
        System.out.println("Food served.");
    }
}

class Rice extends Food implements Spices,Ingredients {
    void cook() {
        System.out.println("Cooking rice..");
    }

    @Override
    public void addSalt() {
        System.out.println("Salt added.");
    }

    @Override
    public void addRice() {
        System.out.println("Rice added.");
    }

    @Override
    public void addWater() {
        System.out.println("Water added.");
    }

    @Override
    public void useBowl() {
        System.out.println("Bowl used.");
    }
}

public class AbstractionExample {
    public static void main(String args[]) {
        Rice obj = new Rice();
        obj.cook();
        obj.useBowl();
        obj.addWater();
        obj.addRice();
        obj.addSalt();
        Spices.addGinger();
        obj.addPepper();
        obj.foodReady();
        obj.serveFood();
    }
}