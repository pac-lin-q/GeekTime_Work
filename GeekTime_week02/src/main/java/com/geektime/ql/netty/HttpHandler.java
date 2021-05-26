package com.geektime.ql.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;


public class HttpHandler extends ChannelInboundHandlerAdapter {
    private  static Logger logger = LoggerFactory.getLogger(HttpHandler.class);

//    @Override
    public void channelReadCompleta(ChannelHandlerContext ctx){ctx.flush();}

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        try{
            FullHttpRequest fullRequst =(FullHttpRequest)msg;
            String uri= fullRequst.uri();
            if (uri.contains("/test")){
                handlerTest(fullRequst, ctx);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    public void handlerTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx){
        FullHttpResponse response = null;
        try{
            String value = "Hello MuYang!";
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", response.content().readableBytes());
        }catch (Exception e){
            System.out.println("system is error:" + e.getMessage());
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
        } finally {
            if (fullRequest != null){
                if (!HttpUtil.isKeepAlive(fullRequest)){
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(CONNECTION,KEEP_ALIVE);
                    ctx.write(response);
                }
            }
        }
    }
}
