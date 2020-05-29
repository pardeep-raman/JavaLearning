package serialization;

import java.io.Serializable;

/*
 * Points to remember for Serialization :
 * 1. If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true.
 * 2. Only non-static data members are saved via Serialization process.
 * 3. Static data members and transient data members are not saved via Serialization process.So, if you don’t want to save value of a non-static data member then make it transient.
 * 4. Constructor of object is never called when an object is deserialized.
 * 5. Associated objects must be implementing Serializable interface.
 * */
public class CompanyEmployee implements Serializable {

    private static final long serialversionUID = 129348938L; // it is used during Deserialization to verify that sender and reciever of a serialized object have loaded classes
    // for that object which are compatible with respect to serialization. If the reciever has loaded a class for the object that has different UID
    // than that of corresponding sender’s class, the Deserialization will result in an InvalidClassException.

    private final int id;
    private final String name;
    private final transient String address;
    public static String companyName = "CompanyABC";

    public CompanyEmployee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Id: " + id);
        System.out.println("Address: " + address);
        System.out.println("Company: " + companyName);
    }
}
