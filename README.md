# concurrent
并发编程学习

## JAVA8 新特性 ##

## JAVA 高并发 ##
    一、多线程基础  
        1、java多线程介绍及入门
        2、线程创建与启动及线程状态
        3、Runnable接口详解
        4、线程优先级及守护线程
        5、线程同步
        6、线程间通信
        7、线程组
        8、自运行对象
        9、线程异常回调
        10、线程池
        11、等待线程完成任务
        12、阻塞IO和多线程
        13、如何优雅地结束线程
             sleep 和 wait 区别：
                1、sleep是Thread中的方法，wait是Object中的方法；
                2、sleep方法并不会释放掉锁，但是调用wait方法的时候,线程会释放掉它所占用的锁，从而使线程所在对象中的其他synchronized数据可以被其他线程使用；
                3、sleep方法可以在任何地方使用，wait方法必须放在同步控制方法或者同步语句块中使用；
                4、sleep方法结束线程会自动苏醒，wait方法结束线程需调用notify方法唤醒。
        14、自定义线程锁
        15、FIFO队列与线程
    二、多线程相关设计模式
        1、WaitSet概念
        2、多线程程序衡量标准
        3、Single Thread Execution模式
        4、不可变对象及线程安全对象
        5、Guraded Suspension模式（保护性暂挂模式）
        6、Balking模式：当现在不适合这个操作，或者没有必要进行这个操作时，就直接放弃而回去，这就是Balking Pattern（不使用线程间通讯）
        7、Producer-Consumer设计模式（生产者-消费者）
        8、读写锁设计模式
        9、Thread-Per-Message模式：为每一个请求新分配一个线程，由这个线程来执行处理。
        10、worker-thread design pattern模式：
            基本内容是：有一个流水线（channel），流水线一端有客户线程client，另一端有工人线程worker，客户不断把新的任务（request）放入流水线，
            工人在另一头获得任务，并执行，客户和工人的数量可多可少
        11、Future设计模式
        12、Two-Phase Termination模式（两阶段终止模式）：
            通过将停止线程这个动作分解为【准备阶段】和【执行阶段】这两个阶段，提供了一种通用的用于优雅地停止线程的方法。
            准备阶段--主要动作是“通知”目标线程(欲停止的线程)准备进行停止（进行一些操作，如清理）。
            执行阶段--主要动作是检查准备阶段所设置的线程停止标志和信号，在此基础上决定线程停止的时机，并进行适当的清理操作。
        13、Thread-Specific-Storage模式
        14、Active-Object接受异步消息的主动
    三、JDK并发包(concurrent)
        1、 原子类
        2、Unsafe
        3、CountDownLatch
        4、CyclicBarrier
        5、Exchanger
        6、ExecutorService
        7、Phaser
        8、显示锁（ReentrantLock、读写锁ReadWriteLock、StampedLock）
        9、Condition
        10、Semaphore信号量
        11、ForkJoin框架
        12、并发容器
        13、CompletableFuture
        14、自定义并发类
        