public class singleObject {
    private static singleObject object = new singleObject();

    private singleObject() {

    }

    public static singleObject getInstance() {
        return object;
    }

    public void print() {
        System.out.println("你好啊!");
    }

}
class demo{

    public static void main(String[] args) {
//        singleObject ob=new singleObject();//会编译错误
        singleObject ob=singleObject.getInstance();
        ob.print();
    }
}
