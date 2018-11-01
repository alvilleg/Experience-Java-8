package academy.elqoo.java8.lambda;


import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Lambda {

    public static List<String> filter(List<String> strings, Predicate<String> condition){
        return strings.stream().filter(condition).collect(Collectors.toList());
    }

    public static void processWithinTransaction(Runnable runnable){
        runnable.run();
    }

    public static String create(GenFnInterface<String> supplier){
        return supplier.get();
    }

    public static Integer getStringLength(String s , StringFnInterface l) {
        return l.apply(s);
    }

    public static int multiply(int a, int b, IntBinaryOperator oper){
        return oper.applyAsInt(a, b);
    }

    public static List<String> sortStrings(List<String> strings , Comparator<String> comparator){
        strings.sort(comparator);
        return strings;
    }

}
