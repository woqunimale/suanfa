public class danli {
    //提供本类类型的引用指向本类类型的对象
    private static danli d = new danli();
    //私有化构造，使用private修饰，表示只能在本类中使用
    private danli() {
    }
    //提供共有的get方法把对象返回出去
    public static danli getInstanse(){
        return d;
    }
}
