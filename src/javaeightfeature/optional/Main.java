package javaeightfeature.optional;

import javaeightfeature.streams.Employee;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String string = "This is String";

        Optional<String> empty = Optional.empty();
        System.out.println(empty);

//        String name = null;  // null value not allowed
//        Optional.of(name);

        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt); // returns empty
        System.out.println(opt.isPresent());
        opt.ifPresent(System.out::println);

        // when the wrapped value is not present, then both orElse() and orElseGet() work exactly the same way.
        // when value is present, orElseGet lambda not even invoked but for orElse whether the wrapped value is present or not, the default object is created
        String optionalOrElse = Optional.ofNullable(name).orElse("No value orElse");
        String optionalOrElseGet = Optional.ofNullable(name).orElseGet(() -> "No value orElseGet");
        try {
            String optionalOrElseThrow = Optional.ofNullable(name).orElseThrow(()-> new IllegalStateException("Illegal state exception"));
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

        System.out.println(Optional.of(new Employee("Jack",12))
                .map(Employee::getAge)
                .filter(e -> e >= 10)
                .filter(p -> p <= 13)
                .isPresent());

//        Optional<String> optional = Optional.ofNullable(null);
//        String s = opt.get();  // if value is null it will throw no such element exception


        System.out.println(optionalOrElse);
        System.out.println(optionalOrElseGet);

        Optional<String> value = Optional.of(string);
        System.out.println("Filtered value: " + value.filter((s) -> s.equals("Abc")));
        System.out.println("Filtered value: " + value.filter((s) -> s.equals("This is String")));

        System.out.println("Getting value: " + value.get());

        System.out.println("Getting hashCode: " + value.hashCode());

        System.out.println("Is value present: " + value.isPresent());

        System.out.println("Nullable Optional: " + Optional.ofNullable(string));

        System.out.println("orElse: " + value.orElse("Value is not present"));

        System.out.println("orElse: " + empty.orElse("Value is not present"));

        value.ifPresent(System.out::println);

        // chaining in optional
        Optional<?> found = Stream.of(Optional.empty(), Optional.of("Hello"), Optional.of("Optional"))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
        System.out.println(found);
    }
}
