package qianl.geektime.rpcfx.demo.api.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceProviderDesc {
    private String host;
    private Integer port;
    private String serviceClass;
}
