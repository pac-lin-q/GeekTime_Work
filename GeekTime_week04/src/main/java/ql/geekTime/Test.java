package ql.geekTime;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String,Object> m = new HashMap<String,Object>();
        m.put("key",1);

        System.out.println("bool is:"+ m.get("key").equals(1));
    }
}
