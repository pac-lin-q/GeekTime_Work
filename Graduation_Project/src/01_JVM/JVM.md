#JVM小结
JVM是Java Virtual Machine（Java虚拟机）的缩写，是一种用于计算设备的规范，它是一个虚构出来的计算机，是通过在实际的计算机上仿真模拟各种计算机功能来实现的;实现了java代码一处编译到处执行的条件；
JRE(JavaRuntimeEnvironment)java运行环境，即java平台，java代码都在再jre中运行；
JDK(JavaDevelopmentKit)程序开发者用来来编译、调试java程序用的开发工具包;
JVM包含：内存模型、字节码技术，java类的加载机制，垃圾回收（GC）算法等等；
JVM是一台基于栈的计算机器
沿用课件的话就是：java可以说是惯着程序员，所有的内存生命周期都由 JVM 运行时统一管理。 在绝大部分场景下，你可以非常自由地写代码，而且不用关心内存到底是什么情况。

###课件总结：
JMM 规范对应的是“[JSR-133. Java Memory Model and Thread 
Specification]”，《Java 语言规
范》的[$17.4. Memory Model章
节]
JMM 规范明确定义了不同的线程之间，通过哪些方式，在什么时候可以看见其他线程保存到共享变量中的
值；以及在必要时，如何对共享变量的访问进行同步。这样的好处是屏蔽各种硬件平台和操作系统之间的内存访问差异，实现了Java 并发程序真正的跨平台。
所有的对象（包括内部的实例成员变量），static变量，以及数组，都必须存放到堆内存中。
局部变量，方法的形参/入参，异常处理语句的入参不允许在线程之间共享，所以不受内存模型的影响。
多个线程同时对一个变量访问时【读取/写入】，这时候只要有某个线程执行的是写操作，那么这种现象就称之为“冲突”。
可以被其他线程影响或感知的操作，称为线程间的交互行为，可分为：读取、写入、同步操作、外部操作等等。其中同步操作包括：对volatile变量的读写，对管程（monitor）的锁定与解锁，线程的起始操作与结尾操作，线程启动和结束等等。外部操作则是指对线程执行环境之外的操作，比如停止其他线程等等。JMM规范的是线程间的交互操作，而不管线程内部对局部变量进行的操作。

###GC总结
串行GC（Serial GC）: 单线程执行，应用需要暂停；
并行GC（ParNew、Parallel Scavenge、Parallel Old）: 多线程并行地执行垃圾回收，关注与高吞吐；
CMS（Concurrent Mark-Sweep）: 多线程并发标记和清除，关注与降低延迟；
G1（G First）: 通过划分多个内存区域做增量整理和回收，进一步降低延迟；
ZGC（Z Garbage Collector）: 通过着色指针和读屏障，实现几乎全部的并发执行，几毫秒级别的延迟，线性可扩展；
Epsilon: 实验性的GC，供性能分析使用；
Shenandoah: G1的改进版本，跟ZGC类似。

可以看出GC算法和实现的演进路线:
串行-> 并行: 重复利用多核CPU的优势，大幅降低GC暂停时间，提升吞吐量。
并行-> 并发：不只开多个GC线程并行回收，还将GC操作拆分为多个步骤，让很多繁重的任务和应用线程一起并发执行，减少了单次GC暂停持续的时间，这能有效降低业务系统的延迟。
CMS -> G1：G1可以说是在CMS基础上进行迭代和优化开发出来的，划分为多个小堆块进行增量回收，这样就更进一步地降低了单次GC暂停的时间
G1 -> ZGC:：ZGC号称无停顿垃圾收集器，这又是一次极大的改进。ZGC和G1有一些相似的地方，但是底层的算法和思想又有了全新的突破。