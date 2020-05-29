package oopsconcept.inheritance;

class Sum {
    int sum(int[] args) {
        int total = 0;
        for (int item : args) {
            total += item;
        }
        return total;
    }
}

class Average {
    Sum sum; // HAS-A relation

    double average(int[] args) {
        sum = new Sum();
        int total = sum.sum(args);
        return (double) total / args.length;
    }
}

public class Aggregation {
    public static void main(String[] args) {
        Average average = new Average();
        System.out.println("Average is " + average.average(new int[]{1, 2, 7, 4, 5, 9}));
    }
}