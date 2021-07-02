package qianl.geektime.qianl_geektime.api;

import java.util.List;

public interface LoadBalancer {
    String select(List<String> urls);
}
