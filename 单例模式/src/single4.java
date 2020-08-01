public class single4 {//双重校验锁
    private static volatile single4 object;
    private single4(){};
    public static single4 getInstance(){
        if (object==null){
            synchronized (single4.class){
                if (object==null){
                    object=new single4();
                }
            }
        }
        return object;
    }
}
