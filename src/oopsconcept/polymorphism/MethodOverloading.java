package oopsconcept.polymorphism;

class Addition {
    int sum(int a, int b) {
        int sum = a + b;
        System.out.println("Both int sum is " + sum);
        return sum;
    }

//    long sum(int a, int b) {   // ambiguity
//        return a + b;
//    }

    int sum(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println("Three int sum is " + sum);
        return sum;
    }

    long sum(long a, long b) {
        long sum = a + b;
        System.out.println("Both long sum is " + sum);
        return sum;
    }

    long sum(int a, long b) {
        long sum = a + b;
        System.out.println("First int and second long sum is " + sum);
        return sum;
    }

    long sum(long a, int b) {
        long sum = a + b;
        System.out.println("First long and second int sum is " + sum);
        return sum;
    }
}

public class MethodOverloading {

    public static void main(String[] args) { // JVM will run only this main method with String[] as argument
        Addition addition = new Addition();
        addition.sum(10, 10);
        addition.sum(15L, 10);
        addition.sum(10, 12, 20);
        addition.sum(12, 5L);
        addition.sum(15L, 3L);
    }

    public static void main(String arg) {

    }

    public static void main(int[] args) {

    }
}