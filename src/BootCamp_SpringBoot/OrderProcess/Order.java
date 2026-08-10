package BootCamp_SpringBoot.OrderProcess;

public class Order {
    int orderId;
    int amount;

    public Order(int orderId, int amount){
        this.orderId = orderId;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.orderId + " -> " + this.amount;
    }
}
