package qianl.geektime.rpcfx.demo.api.api;

import java.util.List;

public interface Router {

    List<String> route(List<String> urls);
}
