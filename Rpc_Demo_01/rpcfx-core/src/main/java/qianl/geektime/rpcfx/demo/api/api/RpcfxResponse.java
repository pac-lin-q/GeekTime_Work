package qianl.geektime.rpcfx.demo.api.api;

import lombok.Data;

@Data
public class RpcfxResponse {
    private Object result;
    private boolean status;
    //异常以错误码+信息格式返回
    private InvalidException exception;
}
