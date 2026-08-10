package BootCamp_SpringBoot.Day_2;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaExpression{
    public static void main(String[] args) {
//        MathOperation add = (a, b) -> a + b;
        MathOperation square = (n)-> n*n;
//        System.out.println(add.operate(5, 3));
        System.out.println(square.operate(5));

        Predicate<Integer> isEven = (n)->n%2==0;
        System.out.println(isEven.test(10));

        List<Integer> ll = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        for(int ele : ll) if(isEven.test(ele)) System.out.print(ele + " ");
        System.out.println();

        Function<String, Integer> length = (name)->name.length();
        List<String> name_list = Arrays.asList("Modiji", "Pappu", "Keju", "Didi");
        for(String e : name_list) System.out.println(length.apply(e));

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(100, 300));

        Consumer<String> c = (name) -> System.out.println(name.length());
        c.accept("MeloniJi");

        Supplier<Integer> s = ()->10;
        System.out.println(s.get());
    }
}
