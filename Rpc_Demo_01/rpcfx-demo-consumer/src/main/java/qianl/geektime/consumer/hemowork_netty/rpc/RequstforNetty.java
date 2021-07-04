package qianl.geektime.consumer.hemowork_netty.rpc;

import lombok.Data;

import java.lang.reflect.Method;

@Data
public class RequstforNetty {
    private String serviceClass;
    private Method method;
    private Object[] params;
}
