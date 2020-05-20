package collections.collection.queue.dequeue.arrayDequeue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

public class Bank {

    public static Comparator<Bank> COMPARATOR = new Comparator<Bank>() {
        @Override
        public int compare(Bank o1, Bank o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    private String name;
    private String address;
    private String ifsc;
    private ArrayDeque<Bank> branches;

    public Bank(String name, String address, String ifsc) {
        this.name = name;
        this.address = address;
        this.ifsc = ifsc;
        this.branches = new ArrayDeque<>();
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
        return new ArrayDeque<>(branches);
    }

    public void addBranchFirst(Bank branch) {
        branches.addFirst(branch);
    }

    public void addBranchLast(Bank branch) {
        branches.addLast(branch);
    }

}
