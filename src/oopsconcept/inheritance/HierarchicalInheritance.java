package oopsconcept.inheritance;

class Flower {
    void name() {
        System.out.println("Flower");
    }
}

class Rose extends Flower {
    void fName() {
        System.out.println("Rose");
    }
}

class Lotus extends Flower {
    void fName() {
        System.out.println("Lotus");
    }
}

public class HierarchicalInheritance {

    public static void main(String[] args) {
        Rose rose = new Rose();
        rose.name();
        rose.fName();
        Lotus lotus = new Lotus();
        lotus.name();
        lotus.fName();
    }
}