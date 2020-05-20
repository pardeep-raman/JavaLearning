package oopsConcepts.inheritance;

class GrandFather {
    void gfName() {
        System.out.println("Grandfather");
    }
}

class Father extends GrandFather {
    void fName() {
        System.out.println("Father");
    }
}

class Son extends Father {
    void name() {
        System.out.println("Son");
    }
}

public class MultiLevelInheritance {

    public static void main(String[] args) {
        Son son = new Son();
        son.gfName();
        son.fName();
        son.name();
    }
}