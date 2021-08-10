package com.potato.study.leetcodecn.p01115.t001;


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1115. 交替打印FooBar
 *
 * 我们提供一个类：

 class FooBar {
 public void foo() {
     for (int i = 0; i < n; i++) {
       print("foo");
     }
 }

 public void bar() {
     for (int i = 0; i < n; i++) {
       print("bar");
     }
 }
 }
 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。

 请设计修改程序，以确保 "foobar" 被输出 n 次。

  

 示例 1:

 输入: n = 1
 输出: "foobar"
 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 示例 2:

 输入: n = 2
 输出: "foobarfoobar"
 解释: "foobar" 将被输出两次。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FooBar {

    // https://www.cnblogs.com/whgw/archive/2011/09/29/2195555.html
    // 声明2个信号量 foo 先打印 初始给一个信号量
    private Semaphore fooSemaphore;
    // bar 需要 foo 执行完毕之后 对信号量进行释放
    private Semaphore barSemaphore;
    private int n;

    public FooBar(int n) {
        this.n = n;
        this.fooSemaphore = new Semaphore(1);
        this.barSemaphore = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // 获取信号量 没有的时候 阻塞等待
            fooSemaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release();
        }
    }
}
