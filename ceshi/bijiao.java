package ceshi;

public class bijiao {

    public static void main(String[] args) {
        String it1 = "hello";
        String it2 = "hello";
        String it3 = new String("hello");
        String it4 = new String("hello");
        System.out.println(it1.equals(it2));
        System.out.println(it1 == it2);
        System.out.println(it3.equals(it4));
        System.out.println(it3 == it4);

        System.out.println("Zbcde".compareTo("Z"));
        System.out.println("abcde".getBytes().length);
        System.out.println("12345".toCharArray());

        int i = 3;
        int b = 5;
        i = i+b;
        b = i - b;
        i-=b;
        System.out.println("i="+i+"  "+"b=" + b);
    }
}
