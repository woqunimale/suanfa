package lianbiao;

public class myLianBiao {
    //定义一个空节点
    private Node header = null;
    //表示集合长度
    private int size = 0;
    //定义一个内部类
    class Node{
         Object o;
         Node next;

        public Node() {
        }

        public Node(Object o) {
            this.o = o;
        }
    }

    @Override
    public String toString() {
        return "myLianBiao{" +
                "header=" + header +
                ", size=" + size +
                '}';
    }

    //创建一个用来验证下标是否合法的方法
    public void checkIndex(int index){
        if(index < 0 || index > size){
            throw new RuntimeException("传入的下标有误，具体是："+index+" 下标出现错误");
        }
    }
    //把变量temp提出来

    /*
     *定义传数据域创建节点
     * 分两种情况，1，不存在任何节点。2，有结点
     */
    private boolean InsertNode(Object o){
        if(size == 0){
            header = new Node(o);
            header.next = header;
        } else{
          Node temp  = this.FindNodes(size-1);
          temp.next = new Node(o);
          temp.next.next = header;
        }
        size++;
        return true;
    }

    /*
     *需要实现删除方法，根据传过来的下标进行删除，返回结果
     * 如果链表为空，就把header指向header的下一个指向的位置
     */
    private boolean deleteNode(int index){
        if(size == 0){
            header = header.next;
        }else{
            this.FindNodes(index-1).next = this.FindNodes(index).next;
        }
        size--;
        return true;
    }
    /*
     *修改操作
     * 需要实现修改结点的数据域值，先判断索引是否有效,
     * 根据下标确定修改的位置，根据传过来的新元素赋值给原来的元素
     */
    private boolean updateNode(int index,Object o){
        checkIndex(index);
        Node temp = this.FindNodes(index);
        temp.o = o;
        return true;
    }

    //定义根据传过来的index来显示结点的数据域
    public Object FindNode(int index){
        //检查下标是否合法
        checkIndex(index);
        //把header结点赋值给一个节点对象
        Node temp = header;
        //创建计时器
        int count = 0;
        while(count != index){
            temp = temp.next;
            count++;
        }
        Object o = temp.o;
        return o;
    }
    //定义根据传过来的index来显示结点
    private Node FindNodes(int index){
        //检查下标是否合法
        checkIndex(index);
        //把header结点赋值给一个节点对象
        Node temp = header;
        //创建计时器
        int count = 0;
        while(count != index){
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public int size(){
        return this.size;
    }
    public void print(){
        System.out.print("[");
        for(int i =0;i<this.size();i++){
            System.out.print(this.FindNode(i).toString() +" ");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        myLianBiao my = new myLianBiao();
        for(int i = 0;i<10;i++){
            java.util.Random rd = new java.util.Random();
            int rdm = rd.nextInt(10);
            my.InsertNode(rdm);
        }
        my.print();
        //System.out.print(my);
        System.out.println(my.FindNode(2));
        System.out.println(my.deleteNode(2));
        my.print();
        System.out.println(my.updateNode(2,250));
        my.print();
    }
}
