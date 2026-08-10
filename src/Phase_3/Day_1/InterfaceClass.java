package Phase_3.Day_1;

public interface InterfaceClass {
    public void sayHello();
    default void sayBye(){
        System.out.println("Bye!!");
    }
}
