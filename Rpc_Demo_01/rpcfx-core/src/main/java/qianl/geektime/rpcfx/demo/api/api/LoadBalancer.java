package qianl.geektime.rpcfx.demo.api.api;

import java.util.List;

public interface LoadBalancer {
    String select(List<String> urls);
}
