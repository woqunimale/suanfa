package myThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class cangku {
    //创建一个下标，用来操作插入数据
    private int one = 0;
    //创建一个大小为10的数组
    private int[] cangkus = new int[10];
    //创建一个标志位
    private boolean flag = false;
    private Lock lock = new ReentrantLock();
    //定义lock锁 Condition()
    private Condition shengchanzhe = lock.newCondition();
    //private Condition xiaofeizhe = lock.newCondition();

    //生产方法
    public void sheng(int n) {
        //上锁
         synchronized (this){
        //判断标志位是否为true
        //lock.lock();
        //try {
            while (flag) {
                try {
                    wait();
                    //shengchanzhe.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //把n赋值为数组
            cangkus[one] = n;
            // System.out.println(n + "步骤1完毕");
            one++;
            //把标志位设置为true
           flag = true;
            //唤醒所有线程
            notifyAll();
            System.out.println(n + "生产完成");
            //shengchanzhe.signalAll();
       // } finally {
         //  lock.unlock();
        }
    }

    //}
    //消费方法
    public int xiao() {
        synchronized (this) {
        //lock.lock();
        //try {
            while (!flag) {
                try {
                    wait();
                    //shengchanzhe.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //System.out.println("弹出");
            one--;
            flag = false;
            notifyAll();
            //shengchanzhe.signalAll();
        //} finally {
          // lock.unlock();
        //}
        return cangkus[one];
    }
    }
}