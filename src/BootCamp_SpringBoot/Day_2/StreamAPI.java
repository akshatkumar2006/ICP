package BootCamp_SpringBoot.Day_2;

import Phase_2.Week_7.SymmetricTree;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        // Duplicates using Stream APIs
        List<Integer> ll = Arrays.asList(13, 13, 23, 3, 2, 3, 4, 5, 2, 3, 5, 6, 10, 6);
//        HashSet<Integer> hs = new HashSet<>();
//        ll.stream()
//                .filter(x->!hs.add(x)).forEach(x-> System.out.println(x));

//        ll.stream()
//                .filter(x->x%2!=0)
//                .sorted()
//                .forEach(x-> System.out.println(x));
//                .collect(Collectors.toList());

//        for(int e : l) System.out.println(e);

//        ll.stream().map(x->x+20).sorted().forEach(x-> System.out.println(x));

//        long oddCount = ll.stream().filter(x->x%2!=0).distinct().count();
//        System.out.println(oddCount);

//        List<String> names = Arrays.asList("Akshat", "Rishabh", "Krishna", "Ramesh");
//        System.out.println(names.stream().filter(x->x.charAt(0) == 'A').count());

//        Optional<Integer> first = ll.stream().findFirst();
//        System.out.println(first.get());

//        ll.stream()
//                .distinct()
//                .sorted((a, b)->b.compareTo(a))
//                .limit(3)
//                .forEach(System.out::println);

//        ll.stream()
//                .distinct()
//                .sorted((a, b)->b.compareTo(a))
//                .limit(2)
//                .skip(1).forEach(System.out::println);

        System.out.println("Akshat".compareTo("ayush"));

    }
}
