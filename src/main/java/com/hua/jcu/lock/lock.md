Java中有两种加锁的方式：一种是用synchronized关键字，另一种是用Lock接口的实现类。
synchronized是Java语言内置的关键字，而Lock是一个接口。

ReentrantLock、ReadLock、WriteLock 是Lock接口最重要的三个实现类。对应了“可重入锁”、“读锁”和“写锁”

可重入锁：可以重复递归调用的锁，在外层使用锁之后，在内层仍然可以使用并且不发生死锁