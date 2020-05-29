package serialization;

import java.io.*;

public class FileUtils {
    public static <T> boolean serializeObject(T object, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static Object deserializeObject(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){
            Object serializedObject = (Object) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return serializedObject;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    // Serialization

}
