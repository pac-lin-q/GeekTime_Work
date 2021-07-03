package qianl.geektime.rpcfx.demo.api.api;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.Data;

@Data
public class ResultHandler extends ChannelInboundHandlerAdapter {

    private Object result;
    private boolean status;
    private Exception exception;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg;
        System.out.println("调用服务器数据返回回来的数据:" + result);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("client exception is general");
    }

}
