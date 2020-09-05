package myThread;

public class xiaofei implements Runnable {
    private cangku ck;

    public xiaofei(cangku ck) {
        this.ck = ck;
    }

    public void run(){
        for(int i = 0;i<100;i++){
            int temp = ck.xiao();
            System.out.println("消费"+temp);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
