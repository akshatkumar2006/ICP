package BootCamp_SpringBoot.OrderProcess;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Order> ll = Arrays.asList(
                new Order(1, 900),
                new Order(2, 5400),
                new Order(3, 6300),
                new Order(4, 1100),
                new Order(5, 1700),
                new Order(6, 2100)
        );

        Consumer<Order> c = (obj) -> System.out.println(obj.orderId);
        for(Order o : ll)c.accept(o);

        Predicate<Order> p = (obj)->obj.amount > 1000;
        for (Order o : ll) if(p.test(o)) System.out.println(o);

        Predicate<Order> p2 = (obj)->obj.amount > 5000;
        Consumer<Order> c2 = (obj)->{
          if(p2.test(obj)){
              int new_amount = (int)(obj.amount * 1.18);
              System.out.println(new_amount);
          }
        };

        for(Order o : ll) c2.accept(o);
    }
}
