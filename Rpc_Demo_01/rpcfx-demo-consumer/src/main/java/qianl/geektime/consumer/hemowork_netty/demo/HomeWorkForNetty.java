package qianl.geektime.consumer.hemowork_netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class HomeWorkForNetty {

    private String ip;
    private int port;

    public HomeWorkForNetty(String ip,int port){
        this.ip=ip;
        this.port=port;
    }

    public  void sendRepust() throws  Exception{
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE,true).handler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new ClientHandler());
            }
        });

        ChannelFuture channelFuture = bootstrap.connect(ip,port).sync();
        String  reqStr  = "";
        channelFuture.channel().writeAndFlush(Unpooled.copiedBuffer(reqStr.getBytes("UTF-8")));
        channelFuture.channel().closeFuture().sync();
    }
}
