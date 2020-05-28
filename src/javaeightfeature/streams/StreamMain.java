package javaeightfeature.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        List<String> someNumbers = Arrays.asList("B01", "A11", "b21", "B17", "D09", "A23", "G15");

        /*
         * this is implemented without stream
         * */
        {
            List<String> bNumbers = new ArrayList<>();
            someNumbers.forEach((number) -> {
                if (number.toUpperCase().startsWith("B")) {
                    System.out.println(number);
                    bNumbers.add(number);
                }
            });
            bNumbers.sort(String::compareTo);
            bNumbers.forEach(System.out::println);
        }

        // this is using stream
        someNumbers.stream()
                .map(String::toUpperCase)
                .filter((number) -> number.startsWith("B"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioStream = Stream.of("I11", "I07", "I15", "O12");
        Stream<String> inStream = Stream.of("N13", "N10", "I11", "I07", "I15", "O12");
        Stream<String> concatStream = Stream.concat(ioStream, inStream);
//        System.out.println(concatStream.count());
        System.out.println("===========================");
        System.out.println(concatStream.distinct() // distinct is used to remove the duplicates
                .peek(System.out::println) // not the terminal operation, just used for debugging or evaluating something at each step in the stream
                .count());

        Employee john = new Employee("John", 20);
        Employee jack = new Employee("Jack", 31);
        Employee peter = new Employee("Peter", 26);
        Employee nick = new Employee("Nick", 18);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jack);
        hr.addEmployee(peter);

        Department account = new Department("Accounting");
        account.addEmployee(nick);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(account);

        // flatmap used to flatten the multiple list into single one
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        //simple collect method example
//        List<String> sortedNumbers=someNumbers.stream()
//                .map(String::toUpperCase)
//                .filter((number)->number.startsWith("B"))
//                .sorted()
//                .collect(Collectors.toList());

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        // nothing will print because stream is lazy evaluated and doesnt do anything if not terminated
        // or ended with terminal operation
        Stream.of("ABC", "XYZ", "JK", "MN", "L", "PQR")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                });

        // here intermediate operations are evaluated as terminal operation is used
        Stream.of("ABC", "XYZ", "JK", "MN", "L", "PQR")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();

        Stream.iterate(1, e -> e + 3)
                .limit(10)
                .forEach(System.out::println);
    }
}
