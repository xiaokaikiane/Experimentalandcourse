public class Client {//测试类
    public static void main(String[] args) {
        Account acc=new Account("胡MX",5);
        acc.deposit(100);
        acc.withdraw(200);
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.withdraw(100);
    }
}
