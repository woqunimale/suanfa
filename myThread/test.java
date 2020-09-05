package myThread;

public class test {
    public static void main(String[] args) {
        cangku ck = new cangku();

        shengchan s = new shengchan(ck);
        xiaofei x = new xiaofei(ck);

        Thread t1 = new Thread(s);
        Thread t2 = new Thread(x);

        t1.start();
        t2.start();
    }
}
