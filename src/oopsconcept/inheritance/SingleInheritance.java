package oopsconcept.inheritance;

class Animal {
    void breathe() {
        System.out.println("oopsConcepts.inheritance.Animal can breathe");
    }
}

class Dog extends Animal{
    // Dog is a animal, so IS-A relationship.

    void bark() {
        System.out.println("oopsConcepts.inheritance.Dog can bark");
    }
}

public class SingleInheritance {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.breathe();
        dog.bark();
    }
}