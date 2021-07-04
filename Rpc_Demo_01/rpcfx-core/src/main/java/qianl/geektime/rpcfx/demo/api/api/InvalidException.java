package qianl.geektime.rpcfx.demo.api.api;

public class InvalidException extends Exception {

    private String excCode;
    private String msg;

    public InvalidException(String excCode, String msg){
        this.excCode=excCode;
        this.msg=msg;
    }
}
