package xiancheng;
public class TestSafeStack{
	
	public static void main(String[] args){
		SafeStack s = new SafeStack(); //����һ���ֿ⣬����ܷ�10����Ʒ
		
		//�����������̵߳Ķ��󣬲�������Ĳֿ⴫��
		PushThread r1 = new PushThread(s);
		//�����������̵߳Ķ��󣬲�������Ĳֿ⴫�룬��֤������������ʹ��ͬһ���ֿ�
		PopThread r2 = new PopThread(s);
		
		//ʹ��������������̶߳��󴴽��̶߳���
		Thread t1 = new Thread(r1);
		//ʹ��������������̶߳��󴴽��̶߳��� 
		Thread t2 = new Thread(r2);	
		
		//�����������߳����е�run()�������Զ�����Thread���е�run����
		//��Դ���֪�����յ���PushThread���е�run������ʵ������100����Ʒ����ֿ���
		t1.start(); 
		//�����������߳��е�run()�������Զ�����Thread���е�run����
		//��Դ���֪�����յ���PopThread���е�run������ʵ������100����Ʒ�Ӳֿ���
		t2.start();
	}	
}