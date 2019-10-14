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
        6、Balking模式
        7、Producer-Consumer设计模式（生产者-消费者）
        8、读写锁设计模式
        9、Thread-Per-Message模式
        10、Worker模式
        11、Future设计模式
        12、Two-Phase Termination模式（两阶段终止模式）
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
        