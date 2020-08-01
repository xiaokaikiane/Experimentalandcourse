//懒加载 线程安全
public class single2 {//懒汉模式  线程安全
    private static single2 object;
    private single2(){};
    public static synchronized single2 getInstance(){
        if(object==null){
            object=new single2();
        }
        return object;
    }
}
