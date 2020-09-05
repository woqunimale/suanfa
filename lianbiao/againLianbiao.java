package lianbiao;

public class againLianbiao {
    //初始化头结点和链表大小
    private Node header = null;
    private int size = 0;

    //创建一个节点型内部类
    class Node {
        Object o;//数据域
        Node next;//指针域

        public Node() {
        }

        public Node(Object o) {
            this.o = o;
        }
    }

    //新增操作
    private Boolean add(Object o) {
        //判断链表中有没有结点
        if (size == 0) {
            //如果不存在节点就把新创建的结点赋值给header，然后指向header的下一个指向
            header = new Node(o);
            header.next = header;
        } else {
            //如果有结点，就找到最后一个节点，然后把最后一个节点的下一个节点指向新创建的结点
            //新创建的结点的下一个指向，指向头结点。长度+1
            Node temp = this.getNodeClass(size - 1);
            temp.next = new Node(o);
            temp.next.next = header;
        }
        size++;
        return true;
    }

    //查询节点对象操作
    private Node getNodeClass(int index) {
        //判断传入的下标是否合法
        checkIndex(index);
        //查找麻烦，只能从头开始查
        //先找到头结点header，编写一个计数器，判断计数器和index是否相等,如果不相等就把
        //指向头结点的下一个指向一直循环，最后return 对象
        Node temp = header;
        int count = 0;
        while (count != index) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    //查询节点数据域操作
    private Object getNodeObject(int index) {
        checkIndex(index);
        Node temp = header;
        int count = 0;
        while (count != index) {
            temp = temp.next;
            count++;
        }
        Object o = temp.o;
        return o;
    }

    //只要是需要传入下标操作的方法，就需要对下标进行检查是否合法
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("数组下标越界异常");
        }
    }

    //删除结点操作
    private Boolean deleteNode(int index) {
        checkIndex(index);
        //如果要删除0下标,就把header的下一个节点作为header
        if (index == 0) {
            header = header.next;
        } else {
            this.getNodeClass(index - 1).next = this.getNodeClass(index).next;
        }
        size--;
        return true;
    }

    //根据传入的数据域来删除节点
    private Boolean deleteObject(Object o) {
        //标志位
        Boolean flag = true;
        //获取头节点
        Node temp = header;
        //循环
        for (int count = 0; count < size; count++) {
            //当节点的数据域和传过来的数据域一致
            if (temp.o.equals(o)) {
                //就传入计数器值删除节点
                this.deleteNode(count);
                //将标志位该为false
                flag = false;
            }
            //如果没有找到就一直循环
            temp = temp.next;
        }
        //如果flag等于true说明没有找到，传入的数据不正确
        if (flag) {
            System.out.print("传入的数据不存在");
            return false;
        }
        return true;
    }

    //修改操作
    private Boolean update(int index, Object o) {
        checkIndex(index);
        //获取下标对应的节点对象
        Node temp = getNodeClass(index);
        //把传过来的值赋值给获取到的节点对象的数据域中
        temp.o = o;
        return true;
    }

    //调用size时，返回当前链表的size
    private int size() {
        return this.size;
    }
    //封装打印格式
    private void print(){
        System.out.print("[");
        for(int i = 0;i<this.size;i++){
            System.out.print(this.getNodeObject(i).toString()+" ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        againLianbiao alb = new againLianbiao();
        for(int i = 0;i<10;i++){
            java.util.Random random = new java.util.Random();
            int temp = random.nextInt(10);
            alb.add(temp);
        }
        alb.print();
        System.out.println(alb.getNodeClass(1));
        alb.print();
        System.out.println(alb.deleteNode(2));
        alb.print();
        System.out.println(alb.getNodeObject(1));
        alb.print();
        System.out.println(alb.deleteObject(1));
        alb.print();
        System.out.println(alb.update(5,520));
        alb.print();
    }
}
