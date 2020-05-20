package oopsConcepts.encapsulation;

class Bird {
    private String birdName;
    private String birdType;

    public String getBirdName() {
        return birdName;
    }

    public String getBirdType() {
        return birdType;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }

    public void setBirdType(String birdType) {
        this.birdType = birdType;
    }
}

public class EncapsulationExample {

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.setBirdName("Jack");
        bird.setBirdType("Crow");
        System.out.println(bird.getBirdName());
        System.out.println(bird.getBirdType());
    }
}