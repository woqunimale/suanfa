package lianbiao;

public class lxlianbiao {
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
       Node temp  = header;
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
    private Boolean deleteByIndex(int index){
        checkIndex(index);
        if(index == 0){
           header = header.next;
        } else{
            this.getNodeClass(index-1).next = this.getNodeClass(index).next;
        }
        size--;
        return true;
    }
    private Boolean deleteByObject(Object o){
       Node temp = header;
       boolean flag = true;
       for(int count = 0;count<size;count++){
           if(temp.o.equals(o)){
               this.deleteByIndex(count);
               flag = false;
           }
           temp = temp.next;
       }
       if(flag){
           System.out.print("传入的值不存在");
           return false;
       }
       return true;
    }
    private Boolean updataByIndex(int index,Object o){
        checkIndex(index);
       Node temp = this.getNodeClass(index);
       temp.o = o;
       return true;
    }
    private void checkIndex(int index){
        if(index < 0 || index > size){
            throw new RuntimeException("下标越界异常");
        }
    }
    private int size(){
        return this.size;
    }
    private void print(){
        System.out.print("[");
        for(int i = 0 ;i<size;i++){
            System.out.print(this.getNodeObject(i).toString()+" ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        lxlianbiao lb = new lxlianbiao();
        for(int i = 0;i<10;i++){
            java.util.Random rd = new java.util.Random();
           int r = rd.nextInt(10);
           lb.add(r);
        }
        lb.print();
        System.out.println(lb.getNodeObject(3));
        lb.print();
        System.out.println(lb.deleteByIndex(4));
        lb.print();
        System.out.println(lb.deleteByObject(7));
        lb.print();
        System.out.println(lb.updataByIndex(6,521520));
        lb.print();
    }
}
