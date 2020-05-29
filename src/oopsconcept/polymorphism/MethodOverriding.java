package oopsconcept.polymorphism;

class Vehicle {
    void run() {
        System.out.println("Vehicle is running");
    }
}

class Bike extends Vehicle {
    void run() {
        System.out.println("Bike is running");
    }
}

// static methods can't be overriden because static is bound with class and instance method is bound with object
// we can't override main method as it is static


class MethodOverriding {

    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.run();
        Vehicle vehicle = new Vehicle();
        vehicle.run();
        Vehicle vehicle1 = new Bike(); //
        vehicle1.run();
    }
}