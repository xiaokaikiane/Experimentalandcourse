//不懒加载
public class single3 {  //饿汉模式   线程安全
    private static single3 object=new single3();
    private single3(){};
    public static single3 getInstance(){
        return object;
    }
}
