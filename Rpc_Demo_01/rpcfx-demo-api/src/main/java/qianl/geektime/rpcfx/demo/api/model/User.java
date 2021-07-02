package qianl.geektime.rpcfx.demo.api.model;

import lombok.Data;

@Data
public class User {

    public User(){}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;
}
