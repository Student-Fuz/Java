## Java多线程

Java 多线程是通过并发执行多个线程来提高程序执行效率的技术，尤其在多核处理器上可以充分利用 CPU 资源。多线程可以用于处理大规模的并行任务、I/O 操作、并发数据处理等场景。Java 提供了丰富的多线程支持，包括基本的线程创建、线程间通信、同步机制等。

### 1. **线程的基本概念**

- **线程**：线程是程序执行的最小单元。一个程序可以包含多个线程，它们共享同一进程的内存空间，并且并发执行。
- **多线程**：在同一个程序中创建和运行多个线程，使其并发执行以提高效率。

Java 中每个线程都由 `Thread` 类或实现 `Runnable` 接口创建和管理。

### 2. **创建线程**

#### 方法一：继承 `Thread` 类

```java
class MyThread extends Thread {
    @Override
    public void run() {
        // 线程执行的任务
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();  // 启动线程，调用 run() 方法
    }
}
```

#### 方法二：实现 `Runnable` 接口

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // 线程执行的任务
        System.out.println("Runnable thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();  // 启动线程，调用 run() 方法
    }
}
```

#### 方法三：使用 Lambda 表达式（Java 8 及以后）

```java
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Lambda thread is running...");
        });
        thread.start();  // 启动线程
    }
}
```

### 3. **线程生命周期**

Java 线程的生命周期可以分为以下几个状态：

- **新建状态（New）**：线程对象被创建后，还没有调用 `start()` 方法时，线程处于新建状态。
- **就绪状态（Runnable）**：调用 `start()` 方法后，线程处于就绪状态，等待被线程调度器选中执行。
- **运行状态（Running）**：线程开始执行 `run()` 方法的代码，进入运行状态。
- **阻塞状态（Blocked/Waiting/Sleeping）**：线程在等待某种条件（如锁、资源）时进入阻塞状态。
- **终止状态（Terminated）**：线程执行完 `run()` 方法或被异常终止后，进入终止状态。

### 4. **线程控制**

- `start()`：启动线程，使线程进入就绪状态。
- `run()`：线程的任务代码，不能直接调用 `run()`，应该通过 `start()` 方法让线程调度器执行。
- `sleep(long millis)`：让线程进入休眠状态，暂时让出 CPU 一段时间。
- `join()`：等待线程执行结束，当前线程进入等待状态，直到调用 `join()` 的线程完成。
- `yield()`：让出当前线程的 CPU 执行权，调度器可以选择其他线程执行。
- `interrupt()`：中断线程，通知线程停止执行。

### 5. **线程的同步**

在多线程环境下，当多个线程共享同一资源时，可能会出现数据竞争的问题。为了解决这一问题，Java 提供了同步机制来保证线程安全。

#### 同步代码块

使用 `synchronized` 关键字来同步代码块，使得同一时间只能有一个线程访问该代码块。

```java
public class Counter {
    private int count = 0;

    // 同步方法，防止数据竞争
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Count: " + counter.getCount());
    }
}
```

#### 同步方法

使用 `synchronized` 关键字直接修饰方法，表示整个方法是同步的，只有一个线程可以执行。

```java
public synchronized void increment() {
    count++;
}
```

### 6. **锁机制**

除了 `synchronized` 关键字，Java 提供了 `Lock` 接口来实现更细粒度的线程控制。

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();  // 获取锁
        try {
            count++;
        } finally {
            lock.unlock();  // 释放锁
        }
    }

    public int getCount() {
        return count;
    }
}
```

### 7. **线程池**

为了避免频繁创建和销毁线程带来的开销，Java 提供了线程池机制，可以复用线程。使用 `ExecutorService` 可以方便地管理线程池。

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}
```

### 8. **线程通信**

在多线程程序中，有时需要线程之间进行通信，Java 提供了 `wait()`、`notify()`、`notifyAll()` 方法来实现线程间的协调和通信。

```java
class SharedResource {
    private boolean isProduced = false;

    public synchronized void produce() throws InterruptedException {
        while (isProduced) {
            wait();  // 等待消费者消费
        }
        System.out.println("Produced!");
        isProduced = true;
        notify();  // 唤醒消费者线程
    }

    public synchronized void consume() throws InterruptedException {
        while (!isProduced) {
            wait();  // 等待生产者生产
        }
        System.out.println("Consumed!");
        isProduced = false;
        notify();  // 唤醒生产者线程
    }
}

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                resource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                resource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

### 9. **线程安全类**

Java 提供了一些线程安全的类，常用的有：

- **`Atomic` 类**：例如 `AtomicInteger`，支持无锁线程安全操作。
- **`Concurrent` 包**：例如 `ConcurrentHashMap`，提供线程安全的集合类。

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
```

### 10. **死锁**

当两个或多个线程互相等待对方持有的资源时，可能会导致死锁现象，导致程序陷入僵局。

```java
public class DeadlockExample {
    public static void main(String[] args) {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try { Thread.sleep(10); } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try { Thread.sleep(10); } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

### 总结

Java 多线程提供了丰富的 API 和机制，使得并发编程变得更加便捷和高效。在实际开发中，合理地使用线程、线程池、同步机制以及线程安全类可以有效提高程序的性能，避免并发问题。
