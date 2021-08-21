##RPC
远程过程调用 Remote Procedure Call；
简单来说，就是“像调用本地方法一样调用远程方法”。

##微服务
主要是Dubbe和SpringCloud，两者基本大同小异；
Dubbe项目重点：common、config、filter、 rpc/remoting/serialization
集群与分布式：cluster、registry/configcenter/metadata

####Dubbe整体架构：
1. config 配置层：对外配置接口，以 ServiceConfig, ReferenceConfig 为中心，可以直接初始化配置类，
也可以通过 spring 解析配置生成配置类
2. proxy 服务代理层：服务接口透明代理，生成服务的客户端 Stub 和服务器端 Skeleton, 以 ServiceProxy 
为中心，扩展接口为 ProxyFactory
3.registry 注册中心层：封装服务地址的注册与发现，以服务 URL 为中心，扩展接口为 RegistryFactory, 
Registry, RegistryService
4. cluster 路由层：封装多个提供者的路由及负载均衡，并桥接注册中心，以 Invoker 为中心，扩展接口为
Cluster，Directory，Router，LoadBalance
5. monitor 监控层：RPC 调用次数和调用时间监控，以 Statistics 为中心，扩展接口为 MonitorFactory, 
Monitor, MonitorService
6. protocol 远程调用层：封装 RPC 调用，以 Invocation，Result 为中心，扩展接口为 Protocol，
Invoker，Exporter
7. exchange 信息交换层：封装请求响应模式，同步转异步，以 Request，Response 为中心，扩展接口为
Exchanger，ExchangeChannel，ExchangeClient，ExchangeServer
8. transport 网络传输层：抽象 mina 和 netty 为统一接口，以 Message 为中心，扩展接口为 Channel，
Transporter，Client，Server，Codec
9. serialize 数据序列化层：可复用的一些工具，扩展接口为 Serialization，ObjectInput， ObjectOutput，
ThreadPool