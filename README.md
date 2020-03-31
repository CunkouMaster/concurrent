# concurrent
并发编程学习
## JAVA8 新特性 ##

## ClassLoader ##
    1、类加载的三个阶段：
        加载：查找并加载类的二进制数据-->类的加载的最终产品是位于堆区中的Class对象
        
        链接：验证（确保被加载类的正确性）
             准备（为类的静态变量分配内存，并将其初始化为默认值）
             解析（把类中的符号引用转换为直接引用）
             
        初始化：为类的静态变量赋予正确的初始值
        
    2、类的使用方式：
        主动使用：a、new，直接使用
                 b、访问某个类或接口的静态变量，或者对该静态变量进行复制操作
                 c、调用静态方法
                 d、反射某个类
                 e、初始化一个子类
                 f、启动类，如hello world
        被动使用
    
    3、类加载器（JDK自带）详细介绍：
        BootStrapClassLoader    根类加载器：最基本的类加载器，本地语言编写，不需要被加载，直接被嵌套在虚拟机中（是虚拟机自身的一部分）
        ExtClassLoader          扩展类加载器
        AppClassLoader          系统类加载器
        
    4、类加载的父委托机制
        a、类加载器的委托是优先交给父加载器先尝试去加载
        b、父加载器和子加载器其实是一种包装关系（包含关系）
        
    5、命名空间&运行时包
        a、每个类装载器有自己的命名空间，命名空间由所有以此装载器为创始类装载器的类组成。
        b、由同一类装载器定义装载的属于相同包的类组成了运行时。
            决定两个类是不是属于同一个运行时包，不仅要看它们的包名是否相同，还要看的定义类装载器是否相同。
            
    创建自定义类加载器
    
    6、类的卸载
        当class满足以下三个条件是才能被GC回收或卸载：   
            a、该类的所有实例都被GC
            b、加载类的ClassLoader实例已经被GC回收
            c、该类的对象没有被任何地方引用时
        系统加载器和根加载器在运行时不会被回收，GC机制是不可控的，Class卸载也是不可控的。
        
    自定义解密加密机制
    线程上下文类加载器
    关于JVM类加载器的总结

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
        1、singleton：
             饿汉式（不能懒加载）、懒加载（可能引起多个实例）、synchronized（性能不够）、double check（引起 null point exception）
        2、WaitSet概念：线程的休息室，放到monitor（锁）中
        3、volatile：多线程程序衡量标准
        4、observer模式（观察者模式）
        5、Single Thread Execution模式：即以一个线程执行
        6、读写锁设计模式 
        7、Immutable Object不可变对象及线程安全对象：类（final）、属性（priva final）、没有write只有read
        8、Future设计模式
        9、Guraded Suspension模式（保护性暂挂模式）：当现在并不适合马上执行某个操作时，就要求想要执行该操作的线程等待。
        10、Thread-Specific-Storage模式是一种即使只有一个入口，也会在内部为每个线程分配特有的储存空间的模式（典型Threadlocal）
        11、Balking模式：当现在不适合这个操作，或者没有必要进行这个操作时，就直接放弃而回去，这就是Balking Pattern（不使用线程间通讯）
        12、Producer-Consumer设计模式（生产者-消费者）
        13、count down：CountDownLatch，英文翻译为倒计时锁存器，是一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
        14、Thread-Per-Message模式：为每一个请求新分配一个线程，由这个线程来执行处理。
        15、Two-Phase Termination模式（两阶段终止模式）：
                    通过将停止线程这个动作分解为【准备阶段】和【执行阶段】这两个阶段，提供了一种通用的用于优雅地停止线程的方法。
                    准备阶段--主要动作是“通知”目标线程(欲停止的线程)准备进行停止（进行一些操作，如清理）。
                    执行阶段--主要动作是检查准备阶段所设置的线程停止标志和信号，在此基础上决定线程停止的时机，并进行适当的清理操作。
        16、worker-thread design pattern模式：
            基本内容是：有一个流水线（channel），流水线一端有客户线程client，另一端有工人线程worker，客户不断把新的任务（request）放入流水线，
            工人在另一头获得任务，并执行，客户和工人的数量可多可少
        17、Active-Object接受异步消息的主动
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
        