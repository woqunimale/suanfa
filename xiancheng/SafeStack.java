package xiancheng;

public class SafeStack {
  private int top = 0;//�±�
  //创建一个容量为10的数组
  private int[] values = new int[10];//����
  //标志位
  private boolean dataAvailable = false;//ѹջ��ջ�ı�־  ���������������ѵı�־
  //生产方法
  //���������߳�������һ����Ʒ������������ֿ�ʱ�������ȴ�״̬
  public void push(int n)//ѹջ���� ����Ʒn�������ֿ�ķ���
  {
    //上锁
    synchronized(this)//ͬ��������������
    {
      //判断为true还是false
      while(dataAvailable){//while��ѭ���жϣ�if�ǵ����ж�
      	try
        {//������synchronized�����ڵ���wait
        	wait();//�ȴ�����Կ�׺���ȴ���
        }
      	catch(InterruptedException e)
        {
        	e.printStackTrace();
        }        
      }
      //����Ʒn���뵽�������±�Ϊtop��λ�ã�����ò�Ʒ��8
      //设置数组的0下标为n
      values[top] = n;
      System.out.println("ѹ������"+n+"����1���");
      top++;//��ջ���
      //生产完毕把标志位该为true
      dataAvailable = true;//// ״̬��//
      // Ϊ��ջ 唤醒所有线程，让生产者和消费者抢时间片
      notifyAll();//�ӵȴ����л��������߳�
      System.out.println("ѹ���������");
    }  //ͬ������
  }

  //���������߳��������һ����Ʒ������ű��������߳������ֿ�ʱ��
  //�����߾ͻ����Ѳ�Ʒ��ͬʱ�����������̣߳���ʱ�����߳��ٴ���ռ�ֿ�
  public int pop() //�Ӳֿ���ȡ��һ����Ʒȥ����
  {
    synchronized(this)
    {
      while(!dataAvailable)    //3
      {
        try
        {
          wait(); //����
        }
      	catch(InterruptedException e)
        {
          e.printStackTrace();
        }        
      }  
      System.out.print("����");
      top--;
      //int[] test = {values[top],top}; // int[] test = {8, 0}; 8�����Ʒ 0�±�
      dataAvailable = false;
      //�������ڵȴ�ѹ�����ݵ��߳�
      notifyAll();
      //return test; //�������ѵĲ�Ʒ ���һ����ظò�Ʒ��Ӧ���±�
      return values[top]; //ֻ���ز�Ʒ�����ٷ��ض�Ӧ���±�
    }
  }
}