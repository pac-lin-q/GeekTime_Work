package io.qianl.gateway.inbound;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.util.List;

public class HttpInboundInitializer extends ChannelInitializer<SocketChannel> {

    private List<String> proxyServer;

    public HttpInboundInitializer(List<String> proxyServer){
        this.proxyServer=proxyServer;
    }

    public void  initChannel(SocketChannel channel){
        ChannelPipeline p =channel.pipeline();
        p.addLast(new HttpServerCodec());
        p.addLast(new HttpObjectAggregator(1024*1024));
        p.addLast(new HttpInboundHandler(this.proxyServer));
    }

}
