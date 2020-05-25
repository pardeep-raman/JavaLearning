package exceptionhandling.checkedexceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLDataException;

public class Main {

    public static void main(String[] args) {
        Object object;
        // try block with multiple catch
        try {
            FileInputStream fileInputStream = new FileInputStream("vijay.txt");
            object = (Object) fileInputStream.read();
            fileInputStream.close();
            System.out.println(object);
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (IOException e){
            System.out.println("Input/output exception");
        }

        //try with resources example
        fileReaderTryWithResources();

        // throws example for checked or compile time exception
        try {
            System.out.println(add(1, 2));
        }catch (SQLDataException e){
            System.out.println(e.getMessage());
        }

        //Example for custom checked exception
        try {
            displayCustom();
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }

        // throws runtime or unchecked example
        System.out.println(division(10,0));
    }

    /*
    * No need to close the resources as try with automatically do that after end of the block
    * */
    private static void fileReaderTryWithResources(){
        try(FileReader fr = new FileReader("vijay.txt")) {
            char [] a = new char[50];
            fr.read(a);
            for(char c : a)
                System.out.print(c);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("\nFinally block executed.");
        }
    }

    private static int division(int x,int y) throws ArithmeticException{
        if (y==0)
            throw new ArithmeticException("Can't divide by zero");
        else
            return x/y;
    }

    private static int add(int x,int y) throws SQLDataException {
            throw new SQLDataException("Can't add into database");
    }

    private static void displayCustom() throws CustomException{
        throw new CustomException("Custom exception is thrown");
    }
}
