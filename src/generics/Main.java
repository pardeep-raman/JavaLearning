package generics;

import collections.collection.queue.priorityQueue.Bank;

public class Main {

    public static void main(String[] args) {
        GenericClass<String> stringGenericClass = new GenericClass<>("Java");
        System.out.println(stringGenericClass.getObject());

        GenericClass<Integer> integerGenericClass = new GenericClass<>(111);
        System.out.println(integerGenericClass.getObject());

        GenericClass<GenericClass<Integer>> genericGenericClass = new GenericClass<>(integerGenericClass);
        System.out.println(genericGenericClass.getObject().getObject());

        MultiGenericClass<String, Integer> multiGenericClass = new MultiGenericClass<>("Amit", 101);
        System.out.println("The id of "+multiGenericClass.getName()+" is "+multiGenericClass.getId());
        multiGenericClass.printSalary(100000);

        BoundedGenericClass<Bank> boundedGenericClass = new BoundedGenericClass<Bank>(new Bank("Kotak","Noida","KKBK000012"));
        System.out.println("BoundedGeneric object is a bank with details : "+boundedGenericClass.getObject().getName()+", "+boundedGenericClass.getObject().getAddress()+", "+boundedGenericClass.getObject().getIfsc()+".");
    }
}
