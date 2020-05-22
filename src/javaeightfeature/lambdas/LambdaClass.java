package javaeightfeature.lambdas;

public class LambdaClass {
    public String doSomething() {
        System.out.println("The LambdaClass class's name is : " + getClass().getSimpleName());
        UpperConcat upperConcat = (s1,s2)-> {
            System.out.println("The Lambda expression class's name is : " + getClass().getSimpleName());
            return s1 + " "+ s2;
        };
        return Main.getConcatString(upperConcat,"hello","world");
//        return Main.getConcatString(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The annonymous class name is : " + getClass().getSimpleName());
//                return s1.toUpperCase() + " " + s2.toUpperCase();
//            }
//        }, "Hello", "World");
    }
}
