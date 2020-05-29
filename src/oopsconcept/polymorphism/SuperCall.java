package oopsconcept.polymorphism;

class Person {
    String id;
    String name;

    Person(String id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Name and Id are " + name+" & "+id);
    }

    void printName() {
        System.out.println("Name is: " + name);
    }

    void printId() {
        System.out.println("Id is: " + id);
    }
}

class Employee extends Person {
    String profile;

    Employee(String id, String name, String profile) {
        super(id, name);
        this.profile = profile;
        super.printId();
        super.printName();
        System.out.println("The name of employee is " + name + " having id: " + id + " working as " + profile + ".");
    }

    {System.out.println("instance initializer block is invoked");}
}

public class SuperCall {
    public static void main(String[] args) {
        Employee employee = new Employee("HK001", "Batman", "Superhero");
    }
}