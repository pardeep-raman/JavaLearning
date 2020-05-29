package serialization;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        CompanyEmployee companyEmployee = new CompanyEmployee(111, "Vijay Pratap", "RajMahal, Jaipur, Rajasthan");
        String fileName = "vijay.txt";

        // Serialization
        if (FileUtils.serializeObject(companyEmployee, fileName)) {
            System.out.println("Object has been serialized");
            companyEmployee.display();
            CompanyEmployee.companyName = "CompanyXYZ";
        } else
            System.out.println("IOException occured");

        // Deserialization
        Optional<Object> optionalSerializableClass = Optional.ofNullable(FileUtils.deserializeObject(fileName));
        optionalSerializableClass.ifPresent((object) -> {
                    if (object instanceof CompanyEmployee) {
                        System.out.println("Object has been deserialized");
                        ((CompanyEmployee) object).display();
                    }
                }
        );
    }

//    Output :
//    You have seen while deserializing the object the values of address and company has changed. The reason being address was marked as transient and company was static.
//    In case of transient variables:- A variable defined with transient keyword is not serialized during serialization process.
//                 This variable will be initialized with default value during deserialization. (e.g: for objects it is null like address, for int it is 0).
//    In case of static Variables:- A variable defined with static keyword is not serialized during serialization process.
//                 This variable will be loaded with current value defined in the class during deserialization.
}
