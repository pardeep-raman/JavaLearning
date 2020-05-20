package collections.collection.queue.priorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static Queue<Bank> banks = new PriorityQueue<>();
    public static void main(String[] args) {
        Bank bank,branch;

        bank = new Bank("State Bank Of India", "Noida, UP", "SBI0000100");
        banks.offer(bank);

        branch = new Bank("State Bank Of India, sec - 77", "B-block, sec-77, Noida, UP", "SBI0000200");
        bank.addBranch(branch);

        bank = new Bank("Kotak Bank", "Noida, UP", "KKBK0000123");
        banks.offer(bank);

        branch = new Bank("Kotak Bank, sec - 77", "B-block, sec-77, Noida, UP", "KKBK0000200");
        bank.addBranch(branch);

        branch = new Bank("Kotak Bank, sec - 52", "E-block, sec-52, Noida, UP", "KKBK0000300");
        bank.addBranch(branch);

        branch = new Bank("Kotak Bank, sec - 34", "A-block, sec-34, Noida, UP", "KKBK0000400");
        bank.addBranch(branch);

        bank = new Bank("Punjab National Bank", "Noida, UP", "PNB0000100");
        banks.offer(bank);

        branch = new Bank("Punjab National Bank, sec - 77", "B-block, sec-77, Noida, UP", "PNB0000200");
        bank.addBranch(branch);

        branch = new Bank("Punjab National Bank, sec - 52", "E-block, sec-52, Noida, UP", "PNB0000300");
        bank.addBranch(branch);

        bank = new Bank("Canara Bank", "Noida, UP", "CNB0000100");
        banks.add(bank);

        branch = new Bank("Canara Bank, sec - 77", "B-block, sec-77, Noida, UP", "CNB0000200");
        bank.addBranch(branch);

        branch = new Bank("Canara Bank, sec - 52", "E-block, sec-52, Noida, UP", "CNB0000300");
        bank.addBranch(branch);

        System.out.println("Banks in Noida are: ");
        printBanks();

        System.out.println("Head is "+ banks.peek().getName());
        System.out.println("Head is "+ banks.element().getName());
        banks.poll();
        printBanks();
    }

    public static void printBanks(){
        Iterator<Bank> iteratorBank = banks.iterator();
        int bankNumber =1;
        while (iteratorBank.hasNext()){
            Bank bank1= iteratorBank.next();
            System.out.println("\t"+bankNumber+". "+bank1.getName());
            int branchNumber=1;
            Iterator<Bank> iteratorBranch = bank1.getBranches().iterator();
            while (iteratorBranch.hasNext()){
                System.out.println("\t  "+bankNumber+"."+branchNumber+". "+iteratorBranch.next().getName());
                branchNumber++;
            }
            bankNumber++;
        }
    }
}
