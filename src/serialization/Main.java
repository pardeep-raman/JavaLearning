package serialization;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        SerializableClass serializableClass = new SerializableClass(111,"Vijay Pratap", "RajMahal, Jaipur, Rajasthan");
        String fileName = "vijay.txt";

        // Serialization
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializableClass);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Object has been serialized!\n\n"
                    + "Data before Deserialization: ");
            printDetails(serializableClass);
            SerializableClass.companyName = "CompanyXYZ";
        }
        catch (IOException e){
            System.out.println("IOException occured");
        }

        // Deserialization
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            serializableClass = (SerializableClass) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Object has been deserialized!\n\n"
                    + "Data after Deserialization: ");
            printDetails(serializableClass);
        }
        catch (Exception e){
            System.out.println("Exception occured");
        }
    }

    public static void printDetails(SerializableClass serializableClass) {
        System.out.println("Name: " + serializableClass.getName());
        System.out.println("Id: " + serializableClass.getId());
        System.out.println("Address: " + serializableClass.getAddress());
        System.out.println("Company: " + SerializableClass.companyName);
        System.out.println("===========================================\n");
    }

//    Output :
//    You have seen while deserializing the object the values of address and company has changed. The reason being address was marked as transient and company was static.
//    In case of transient variables:- A variable defined with transient keyword is not serialized during serialization process.
//                 This variable will be initialized with default value during deserialization. (e.g: for objects it is null like address, for int it is 0).
//    In case of static Variables:- A variable defined with static keyword is not serialized during serialization process.
//                 This variable will be loaded with current value defined in the class during deserialization.
}
