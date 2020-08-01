//懒加载 (懒加载其实就是延时加载，即当对象需要用到的时候再去加载),线程不安全
public class single1 { //懒汉模式 线程不安全
private static single1 object;
private single1(){};
public static single1 getInstance(){
    if(object==null){
        object=new single1();
    }
    return object;
}
}

