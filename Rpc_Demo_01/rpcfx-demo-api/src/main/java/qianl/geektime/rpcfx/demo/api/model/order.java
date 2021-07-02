package qianl.geektime.rpcfx.demo.api.model;

import lombok.Data;

@Data
public class Order {

    private int id;
    private String name;
    private float amount;

    public Order(int id, String name, float amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
