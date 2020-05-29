package javaeightfeature.collectors;

import javaeightfeature.streams.Department;
import javaeightfeature.streams.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> someNumbers = Arrays.asList("B01", "A11", "b21", "B17", "D09", "A23", "G15");

        Employee john = new Employee("John", 20);
        Employee jack = new Employee("Jack", 31);
        Employee peter = new Employee("Peter", 26);
        Employee nick = new Employee("Nick", 18);
        Employee michael = new Employee("Michael", 31);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jack);
        hr.addEmployee(peter);

        Department account = new Department("Accounting");
        account.addEmployee(nick);
        account.addEmployee(michael);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(account);

        double average = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.averagingDouble(Employee::getAge));
        System.out.println("Average age is : " + average);

        long count = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
//                .count()
                .collect(Collectors.counting());
        System.out.println("Total employees are : " + count);

        int sumAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
//                .mapToInt(Employee::getAge)
//                .sum();
                .collect(Collectors.summingInt(Employee::getAge));
        System.out.println("Sum of age is : " + sumAge);


        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println(groupByAge);

        Map<Integer, Long> groupByAgeCount = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(Employee::getAge,Collectors.counting()));
        System.out.println(groupByAgeCount);

        List<String> sortedNumbers = someNumbers.stream()
                .map(String::toUpperCase)
                .filter((number) -> number.startsWith("B"))
                .sorted()
                .collect(ArrayList::new //supplier to provide the result container
                        , ArrayList::add //accumulator to add or process element into result container
                        , ArrayList::addAll // combiner to add or process elements of one result container into other result container and must be compatible with accumulator.
                );

        for (String s : sortedNumbers) {
            System.out.println(s);
        }

        List<Employee> employeeList = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.toList());
        System.out.println(employeeList);

        Set<Employee> employeeSet = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.toSet());
        System.out.println(employeeSet);

        TreeSet<Employee> employeeTreeSet = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(employeeTreeSet);

        String employees = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println(employees);

        Map<Boolean,List<Employee>> partioningEmployees = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.partitioningBy(employee -> employee.getAge()>30,Collectors.toList()));
        System.out.println(partioningEmployees);
    }
}
