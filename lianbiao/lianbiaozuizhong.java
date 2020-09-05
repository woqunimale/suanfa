package lianbiao;

public class lianbiaozuizhong {
    //初始化头结点
    private Node header = null;
    //创建size用来计算链表长度
    private int size = 0;
    //封装结点型内部类
    class Node{
        //数据域
        Object o;
        //指针域
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }
    //添加操作
    private Boolean add(Object o){
        //如果链表不存在数据，就赋值给header的下一个节点的数据域
        if(size == 0){
            //把包含数据域的结点赋值给头结点
            header = new Node(o);
            //再把头结点指向头结点的下一个节点
            header.next = header;
        } else{
            //通过获取节点对象的方法，来找到链表的最后一个节点，将最后一个节点的指针域指向新创建的节点
            //把新创建的结点的指针域指向头结点
            Node temp = this.getNodeClass(size-1);
            //把新创建的结点赋值给temp
            temp.next = new Node(o);
            temp.next.next = header;
        }
        size++;
        return true;
    }
    //根据传入的下标获取节点对象
    private Node getNodeClass(int index){
        checkIndex(index);
        //从头开始查
        //获取头结点
        Node temp = header;
        int count = 0;
        while(count != index){
            temp = temp.next;
            count++;
        }
        return temp;
    }
    //根据传入的下标获取节点对象的数据域
    private Object getNodeObject(int index){
       Node temp =  header;
       int count = 0;
       while(count != index){
           temp = temp.next;
           count++;
       }
       Object o = temp.o;
       return o;
    }
    //对传入方法中的下标进行看判断
    private void checkIndex(int index){
        if(index > size || index < 0){
            throw  new RuntimeException("数组下标越界异常");
        }
    }
    //根据下标删除结点
    private Boolean deleteIndex(int index){
        checkIndex(index);
        //如果删除的下标为0，就把header.next赋值给header
        if(index == 0){
            header = header.next;
        }else{
            //否则就把要删除节点的上一个结点的指向，指向要删除节点的下一个节点
           this.getNodeClass(index-1).next= this.getNodeClass(index).next;
        }
        size--;
        return true;
    }
    //根据传过来的元素删除节点
    private Boolean deleteObject(Object o){
        //从头节点开始查找
        Node temp = header;
        boolean flag = true;
        for(int count = 0;count < size;count++){
            if(temp.o.equals(o)) {
                this.deleteIndex(count);
                flag = false;
            }
            //否则就一直循环
            temp = temp.next;
        }
        if(flag){
            System.out.print("传入下标不存在");
            return false;
        }
        return true;
    }
    //根据下标修改元素的数据域
    private Boolean updateObject(int index,Object o){
        checkIndex(index);
        Node temp = this.getNodeClass(index);
         temp.o = o;
        return true;
    }
    //封住调用size方法，返回当前链表的size
    private int size(){
        return this.size;
    }
    //封装打印信息
    private void print(){
        System.out.print("[");
        for(int i = 0;i<size;i++){
            System.out.print(this.getNodeObject(i).toString()+" ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        lianbiaozuizhong lb = new lianbiaozuizhong();
        for(int i = 0;i<10;i++){
            java.util.Random r = new java.util.Random();
            int rd  = r.nextInt(10);
            lb.add(rd);
        }
        lb.print();
        System.out.println(lb.deleteIndex(3));
        lb.print();
        System.out.println(lb.deleteObject(7));
        lb.print();
        System.out.println(lb.updateObject(5,521));
        lb.print();
        System.out.println(lb.getNodeObject(3));
        lb.print();

    }
}
