package javaeightfeature.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        Person anu = new Person("Anu", "Rani", 23);
        Person anup = new Person("Anup", "Kumar", 21);
        Person sonia = new Person("Sonia", "Dutta", 31);
        Person rahul = new Person("Rahul", "Singh", 27);
        Person vishal = new Person("Vishal", "Sethi", 35);

        List<Person> people = new ArrayList<>();
        people.add(anu);
        people.add(anup);
        people.add(sonia);
        people.add(rahul);
        people.add(vishal);

        String fullName = getFullname(personFullName, people.get(0).getFirstName(), people.get(0).getLastName());
        System.out.println(fullName);

        printPeopleByAge(people, "\nThe people with age over 30 : ", person -> person.getAge() > 30);
        printPeopleByAge(people, "\nThe people with age less than or equal 30 : ", person -> person.getAge() <= 30);
        printPeopleByAge(people, "\nThe people with age less than or equal 30 : ", new Predicate<Person>() { // can use annonymous class also instead of lambda
            @Override
            public boolean test(Person person) {
                return person.getAge() <= 30;
            }
        });

        //consumer interface accepts argument but doesn't return any value
        people.forEach((person -> System.out.println(person.getFirstName()+" "+person.getLastName()+" : "+person.getAge())));

        // predicate interface returns true or false based on condition or lambda expression
        IntPredicate greaterThan20Predicate = i -> i > 20;
        IntPredicate lessThan100Predicate = i -> i < 100;
        System.out.println(greaterThan20Predicate.test(30));
        System.out.println(greaterThan20Predicate.test(15));
        System.out.println(greaterThan20Predicate.and(lessThan100Predicate).test(50)); // chaining of predicates
        System.out.println(greaterThan20Predicate.or(lessThan100Predicate).test(50));
        System.out.println(greaterThan20Predicate.negate().test(50));
        System.out.println(greaterThan20Predicate.equals(lessThan100Predicate));

        Random random = new Random();
        // supplier interface doesn't accepts any argument but return a value
        Supplier<Integer> supplier = () -> random.nextInt(100);
        for (int i = 0; i < 10; i++) {
            System.out.println(supplier.get());
        }

        // function interface accepts a single argument and return a single value as defined respectively
        Function<Person, String> getFirstName = Person::getFirstName;
        System.out.println("First name is: " + getName(getFirstName, people.get(1)));

        Function<Person, String> getLastName = Person::getLastName;
        System.out.println("Lastname is: " + getName(getLastName, people.get(1)));

        Function<String, String> getFirstNameUpper = String::toUpperCase;
        Function chainedFunction = getFirstName.andThen(getFirstNameUpper);
        System.out.println(chainedFunction.apply(people.get(0)));

        // bifunction interface which accepts two arguments and return a single value
        BiFunction<String, Person, String> concatAge = (name, person) -> name.concat(" " + person.getAge());
        String upperName = getFirstNameUpper.apply(people.get(0).getFirstName());
        System.out.println(concatAge.apply(upperName, people.get(0)));

        // this interface accepts a argument and returns a same type of value as of argument
        IntUnaryOperator intUnaryOperator = i->i+5;
        System.out.println(intUnaryOperator.applyAsInt(10));
    }

    static PersonFullName personFullName = (firstName, lastName) -> {
        return firstName.toUpperCase() + " " + lastName.toUpperCase();
    };

    private static String getName(Function<Person, String> getName, Person person) {
        return getName.apply(person);
    }

    public static String getFullname(PersonFullName personFullName, String firstName, String lastName) {
        return personFullName.fullname(firstName, lastName);
    }

    private static void printPeopleByAge(List<Person> people, String ageText, Predicate<Person> ageCondition) {
        System.out.println(ageText);
        System.out.println("======================");
        for (Person person : people) {
            if (ageCondition.test(person)) {
                System.out.println(getFullname(personFullName, person.getFirstName(), person.getLastName()));
            }
        }
    }
}
