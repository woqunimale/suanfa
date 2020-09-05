package xiancheng;
public class PopThread implements Runnable {
    //定义仓库变量，生产者和消费者公用同一个仓库
  private SafeStack s; //�������߳���Ҫһ���ֿ⣬ͨ�����췽������紫��
  public PopThread(SafeStack s)
  {
    this.s = s;
  }
  
  //��д�ӿ��е�run()����
  public void run()
  {
	//ѭ��100��ģ������100�ε�Ч��
      //循环100次
    for(int i=0;i<100;i++)
    {
    	//�Ӳֿ���ȡ����Ʒ�����뵽����temp��  {8, 0}
    	//int temp[] = s.pop();
        //从仓库取出数据为temp
		int temp = s.pop();
		//打印取出来的数据
    	System.out.println("->"+ temp + "<-"); //8
        //睡眠1秒
    	try {
            	Thread.sleep(1000);
        }
        catch(InterruptedException e){
		    e.printStackTrace();
		}
    }
  }
}