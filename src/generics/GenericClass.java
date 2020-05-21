package generics;

/* To create an instance of generic class
*     BaseType <Type> obj = new BaseType <Type>()
*  Note: In Parameter type we can not use primitives like
*       'int','char' or 'double'.
*/
public class GenericClass<K> {

    private final K object;

    GenericClass(K object){
        this.object = object;
    }

    public K getObject() {
        return object;
    }
}
