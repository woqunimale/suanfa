package lianbiao;

public class lxlianbiaos {
    private Node header = null;
    private int size = 0;

    class Node{
        Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    private Boolean add(Object o){
        if(size == 0){
            header = new Node(o);
            header.next = header;
        }else{
                Node temp = this.getNodeClass(size-1);
                temp.next = new Node(o);
                temp.next.next = header;
        }
        size++;
        return true;
    }
    private Node getNodeClass(int index){
        checkIndex(index);
        Node temp = header;
        int count = 0;
        while(count != index){
             temp = temp.next;
             count++;
        }
        return temp;
    }
    private Object getNodeObject(int index){
        checkIndex(index);
       Node temp = header;
       int count = 0;
       while(count != index){
           temp = temp.next;
           count++;
       }
      Object o = temp.o;
       return o;
    }
    private boolean deleteIndex(int index){
        checkIndex(index);
        if(index == 0){
            header = header.next;
        }else{
           this.getNodeClass(index-1).next =  this.getNodeClass(index).next;
        }
        size--;
        return true;
    }
    private boolean deleteObject(Object o){
       Node temp = header;
       boolean flag = true;
       for(int count = 0;count < size;count++) {
           if(temp.o.equals(o)){
               this.deleteIndex(count);
               flag = false;
           }
           temp = temp.next;
       }
       if(flag){
           System.out.println("传入的值不存在");
           return false;
       }
        return true;
    }
    private void checkIndex(int index){
        if(index < 0 || index>size){
            throw new RuntimeException("数组下标越界异常");
        }
    }
    private boolean updateObject(int index,Object o){
        checkIndex(index);
      Node temp  = this.getNodeClass(index);
      temp.o = o;
      return true;
    }
    private int size(){
        return this.size;
    }
    private void print(){
        System.out.print("[");
        for(int i = 0;i<size;i++){
            System.out.print(this.getNodeObject(i).toString()+" ");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        lxlianbiaos lb = new lxlianbiaos();
        for(int i = 0;i<10;i++){
            java.util.Random rd = new java.util.Random();
            int r = rd.nextInt(10);
            lb.add(r);
        }
        lb.print();
       System.out.println(lb.getNodeObject(5));
        lb.print();
        System.out.println(lb.deleteIndex(2));
        lb.print();
        System.out.println(lb.updateObject(6,0));
        lb.print();
        System.out.println(lb.deleteObject(7));
        lb.print();
    }
}
