package BootCamp_SpringBoot.Day_2;

import java.util.*;

public class StreamAPI {
    public static void main(String[] args) {
        // Duplicates using Stream APIs
        List<Integer> ll = Arrays.asList(13, 13, 23, 3, 2, 3, 4, 5, 2, 3, 5, 6, 10, 6);
        List<Integer> duplicates = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        ll.stream()
                .filter(x->!hs.add(x)).forEach(x-> System.out.println(x));

//        for(int e : duplicates) System.out.println(e);
    }
}
