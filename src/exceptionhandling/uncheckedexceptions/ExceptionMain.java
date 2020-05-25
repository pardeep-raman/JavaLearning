package exceptionhandling.uncheckedexceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionMain {

    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        }
        catch (ArithmeticException | NoSuchElementException e){
            System.out.println("Unable to perform division, invalid input");
        }
//        catch (ArithmeticException e){
//            System.out.println("Invalid input");
//        }
//        catch (NoSuchElementException e){
//            System.out.println("Invalid input from no such element");
//        }
        finally {
            System.out.println("Program finished");
        }
    }

    private static int divide(){
        int x = getInt();
        int y = getInt();
        System.out.println("x is "+x+", y is "+y);
        return x/y;
    }

    private static int getInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter integer: ");
        while (true){
            try{
                scanner.nextInt();
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Please enter digit from 0 to 9");
            }
        }
    }
}
