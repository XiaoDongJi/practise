package com.cckeep.jdk.gc;

/**
 *
 * https://www.cnblogs.com/duke2016/p/6250766.html
 *
 * 年轻代收集器
 *
 * Serial收集器:Serial收集器是一款年轻代的垃圾收集器，使用标记-复制垃圾收集算法。它是一款发展历史最悠久的垃圾收集器。
 *              Serial收集器只能使用一条线程进行垃圾收集工作，并且在进行垃圾收集的时候，所有的工作线程都需要停止工作，
 *              等待垃圾收集线程完成以后，其他线程才可以继续工作、
 *
 * ParNew收集器:ParNew垃圾收集器是Serial收集器的多线程版本，使用标记-复制垃圾收集算法。为了利用CPU多核多线程的优势，
 *              ParNew收集器可以运行多个收集线程来进行垃圾收集工作。这样可以提高垃圾收集过程的效率。
 *              多线程版本的年轻代收集器中，只有它可以和CMS这款优秀的老年代收集器一起搭配搭配使用
 *
 * Parallel Scavenge收集器：Parallel Scavenge收集器是是一款年轻代的收集器，它使用标记-复制垃圾收集算法。
 *                      Parallel Scavenge收集器和其他收集器的关注点不同。其他收集器，比如ParNew和CMS这些收集器，
 *                      它们主要关注的是如何缩短垃圾收集的时间。而Parallel Scavenge收集器关注的是如何控制系统运行的吞吐量。
 *                      这里说的吞吐量，指的是CPU用于运行应用程序的时间和CPU总时间的占比，
 *                      吞吐量 = 代码运行时间 / (代码运行时间 + 垃圾收集时间)。如果虚拟机运行的总的CPU时间是100分钟，
 *                      而用于执行垃圾收集的时间为1分钟，那么吞吐量就是99%
 *  --------------------------------------------------------------------------------------------------------
 *
 *  老年代收集器
 *  Serial Old收集器：Serial Old收集器是Serial收集器的老年代版本，它也是一款使用"标记-整理"算法的单线程的垃圾收集器。
 *                  这款收集器主要用于客户端应用程序中作为老年代的垃圾收集器，也可以作为服务端应用程序的垃圾收集器，
 *                  当它用于服务端应用系统中的时候，主要是在JDK1.5版本之前和Parallel Scavenge年轻代收集器配合使用，或者作为CMS收集器的后备收集器。
 *   -XX:+UseSerialGC
 *
 *  Parallel Old收集器：Parallel Old收集器是Parallel Scavenge收集器的老年代版本，使用"标记-整理"算法。这个收集器是在JDK1.6版本中出现的，
 *                      所以在JDK1.6之前，新生代的Parallel Scavenge只能和Serial Old这款单线程的老年代收集器配合使用。
 *                      Parallel Old垃圾收集器和Parallel Scavenge收集器一样，也是一款关注吞吐量的垃圾收集器，和Parallel Scavenge收集器一起配合，
 *                      可以实现对Java堆内存的吞吐量优先的垃圾收集策略
 *   -XX:+UseParallelOldGC
 *
 *  CMS收集器：CMS收集器是目前老年代收集器中比较优秀的垃圾收集器。CMS是Concurrent Mark Sweep，从名字可以看出，这是一款使用"标记-清除"算法的并发收集器。CMS
 *               垃圾收集器是一款以获取最短停顿时间为目标的收集器。由于现代互联网中的应用，比较重视服务的响应速度和系统的停顿时间，所以CMS收集器非常适合在
 *  -XX:+UseConcMarkSweepGC
 *
 */
public class GcTest {

    private static final int _1MB = 1024*1024;

    public static void main(String[] args) {

        testCollection();


    }


    /**
     *
     * JVM: Java HotSpot(TM) 64-Bit Server VM (build 25.101-b13, mixed mode)
     * 参数：
     * -verbose: -Xms20M -Xmx20M -Xmn10M
     * -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *
     * PSYoungGen：Parallel Scavenge
     * ParOldGen:
     * Metaspace：元数据区
     *
     *
     */
    public static void testCollection(){
        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        //System.gc();
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }


}
