package Phase_3.Day_1;

import java.util.Arrays;

public class Lambda {
    public static void main(String[] args) {
        Runnable r1 = ()->{
            System.out.println("Hello World");
        };

        r1.run();
    }
}
