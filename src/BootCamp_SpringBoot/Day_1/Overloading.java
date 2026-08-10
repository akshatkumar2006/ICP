package BootCamp_SpringBoot.Day_1;

public class Overloading {
    public static void a1(int a){
        System.out.println("Integer");
    }

    public static void a1(double a){
        System.out.println("Double");
    }

    public static void a1(String a){
        System.out.println("String");
    }

    public static void a1(StringBuffer a){
        System.out.println("StringBuffer");
    }
    public static void a1(Object a){
        System.out.println("Object");
    }

    public static void main(String[] args) {
        Byte b = 23;
        a1(b);
//        a1(null);
    }
}
