package generics;

public class MultiGenericClass<K,T> {
    private final K name;
    private final T id;

    public MultiGenericClass(K name, T id) {
        this.name = name;
        this.id = id;
    }

    public K getName() {
        return name;
    }

    public T getId() {
        return id;
    }

    public <E> void printSalary(E salary){
        System.out.println("The salary of "+name+" is "+salary);
    }


}
