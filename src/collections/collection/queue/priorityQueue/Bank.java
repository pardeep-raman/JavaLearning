package collections.collection.queue.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bank implements Comparable<Bank>{

    public static Comparator<Bank> COMPARATOR = new Comparator<Bank>() {
        @Override
        public int compare(Bank o1, Bank o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    private String name;
    private String address;
    private String ifsc;
    private Queue<Bank> branches;

    public Bank(String name, String address, String ifsc) {
        this.name = name;
        this.address = address;
        this.ifsc = ifsc;
        this.branches = new PriorityQueue<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getIfsc() {
        return ifsc;
    }

    public Queue<Bank> getBranches() {
        return new PriorityQueue<>(branches);
    }

    public boolean addBranch(Bank branch) {
        return branches.add(branch);
    }

    @Override
    public int compareTo(Bank bank) {
        return this.getName().compareTo(bank.getName());
    }
}
