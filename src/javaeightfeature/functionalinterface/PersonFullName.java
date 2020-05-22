package javaeightfeature.functionalinterface;

@FunctionalInterface
public interface PersonFullName {
    String fullname(String firstName, String lastName);

    default String ageInYears(int age){
        return age + " years";
    }

    default String ageInMonths(int age){
        return (age * 12 )+ " months";
    }
}
