package xiancheng;

public class PushThread implements Runnable {
  //创建和消费者一样的仓库
  private SafeStack s; //�������߳���Ҫһ���ֿ⣬�òֿ����紫����
  
  public PushThread(SafeStack s)
  {
    this.s = s;
  }
  
  //��д�ӿ��е�run()����
  public void run() {
    int temp = 0;
    
    //ѭ��100�Σ�ģ������100�β�Ʒ��Ч��
    //循环100次
    for(int i=0;i<100;i++)
    {
      //����һ��0 ~ 9֮����������ʹ�ø����������ǰ�����Ĳ�
      //创建一个随机数对象
      java.util.Random r = new java.util.Random();
      //循环10以内的数据存为temp
      temp = r.nextInt(10);
      //���òֿ����е�push()�����������ɺõĲ�Ʒtemp����ֿ���
      //调用生产方法把产生的数据放入仓库
      s.push(temp);
      //睡眠1秒
      try {
        Thread.sleep(100);
      }
      catch(InterruptedException e){
	      e.printStackTrace();
	  }
    }
  }  
}