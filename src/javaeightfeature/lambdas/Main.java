package javaeightfeature.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Its runnable");
            System.out.println("Runnable is running...");
        }).start();

        Employee anu = new Employee("Anu", 23);
        Employee anup = new Employee("Anup", 21);
        Employee sonia = new Employee("Sonia", 31);
        Employee rahul = new Employee("Rahul", 27);

        List<Employee> employees = new ArrayList<>();
        employees.add(anu);
        employees.add(anup);
        employees.add(sonia);
        employees.add(rahul);

        Collections.sort(employees, (employee, employee2) -> {
            return employee.getName().compareTo(employee2.getName());
        });

        for (Employee employee : employees) {
            System.out.println(employee.getName());
            new Thread(()-> System.out.println(employee.getAge())).start(); // lambda expression, outside scope variable must be declared final or effectively final
        }

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        Employee employee;
//        for (int i=0;i<employees.size();i++) {
//            employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(()-> System.out.println(employee.getAge())).start(); // lambda expression,  so here is an error as outside scope variable must be declared final or effectively final
//        }

//        UpperConcat upperConcat = (s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase();
        UpperConcat upperConcat = (s1, s2) -> {
            String s1Upper = s1.toUpperCase();
            String s2Upper = s2.toUpperCase();
            return s1Upper + " " + s2Upper;
        };
        String newString = getConcatString(upperConcat, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(newString);

        LambdaClass lambdaClass = new LambdaClass();
        System.out.println(lambdaClass.doSomething());
    }

    public static String getConcatString(UpperConcat upperConcat, String s1, String s2) {
        return upperConcat.upperAndConcat(s1, s2);
    }
}
