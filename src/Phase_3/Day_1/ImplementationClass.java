package Phase_3.Day_1;

public class ImplementationClass implements InterfaceClass{
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        ImplementationClass obj = new ImplementationClass();
        obj.sayHello();
        obj.sayBye();
    }
}
