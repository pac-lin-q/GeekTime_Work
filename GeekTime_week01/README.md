_**JVM启动参数：**_

    系统属性
       -Dfile.encoding=UTF-8
       -Duser.timezone=GMT+08
       -dDmaven.test.skip=true
       
    运行模式
        -server 启动速度慢，运行性能和内存管理效率高
        -client 启动快，运行性能和内存管理效率不高
        -Xint 解释模式下运行  强制jvm解释执行所有字节码，会降低运行速度
        -Xcomp 编译模式与-Xint相反
        -Xmixed 混合模式，将解释模式和编译模式，jvm的默认模式，也是推荐模式
      
    堆内存
        -Xmx 指定最大堆内存
        -Xms 指定堆内存空间的初始大小，一般和xmx一致
        -Xmn 等价于-XX:NewSize,G1不需要设置，其他场景设置，一般值为Xmx的1/2-1/4
        -XX:MaxPermSize=size.这个jdk1.7之前使用，1.8之后Meta空间无限大，此参数无效
        -XX:MaxMetaspaceSize=size，1.8之后一般不允许设置
        -XX:MaxDirectMemorySize=size可使用的最大堆外内存
        -Xss设置每个线程的字节数，影响栈的深度 -Xss1m等同于-XX:ThreadStackSize=1m
        
    GC相关 
        -XX: +UseG1GC  G1
        -XX: +UsecConcMarkSweepGC  CMS
        -XX: +UseSerialGC   串行
        -XX: +UseParallelGC  并行
        Java 11+以上打开ZGC 
        -XX: +UnlockExperimentalVMOptions -XX: +UseZGC 
    
    分析诊断
        -XX: +-HeapDumpOnOutOfMemoryError当内存溢出自动dump堆内存
        -XX：HeapDumpPath 一般一上面配合使用，指定dump文件目录
        -XX：OnError 发生致命错误时执行脚本
        -XX：ErrorFile 致命错误的日志文件名
                
    JavaAgent
        JVM黑科技通过无侵入的方式做很多事情
        -agentlib
        -agentpath
        -Xnoagent 禁用agent
       