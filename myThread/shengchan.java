package myThread;

public class shengchan implements Runnable {
    private cangku ck;

    public shengchan(cangku ck) {
        this.ck = ck;
    }

    public void run(){
        //用来存放生产的数
        int temp = 0;
        //使用for循环
        for(int i = 0;i<100;i++){
            //创建随机数对象
            java.util.Random ranDom = new java.util.Random();
            temp = ranDom.nextInt(10);
            ck.sheng(temp);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
