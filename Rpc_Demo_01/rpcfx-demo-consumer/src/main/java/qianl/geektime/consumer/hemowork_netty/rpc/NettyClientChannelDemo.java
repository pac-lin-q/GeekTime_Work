package qianl.geektime.consumer.hemowork_netty.rpc;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.Method;

public class NettyClientChannelDemo {

    private  String IP;
    private  int port;

    public NettyClientChannelDemo(String IP,int port) {
        this.IP=IP;
        this.port=port;
    }

    public void sendRequst(String serverclass, Method method,Object[] params) throws  Exception{
        ResultHandler resultHandler = new ResultHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
                            pipeline.addLast("frameEncoder", new LengthFieldPrepender(4));
                            pipeline.addLast("encoder", new ObjectEncoder());
                            pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            pipeline.addLast("handler",resultHandler);
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect(IP,port).sync();
            RequstforNetty requstforNetty = new RequstforNetty();
            requstforNetty.setServiceClass(serverclass);
            requstforNetty.setMethod(method);
            requstforNetty.setParams(params);
            channelFuture.channel().writeAndFlush(requstforNetty).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
        System.out.println("调用服务器数据返回回来的数据:" + resultHandler.getResponse());
    }
}
