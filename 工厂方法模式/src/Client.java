import java.util.Scanner;
//工厂接口
interface LogFactory{
    public Log createLog();
}
//日志工厂实现接口
class FileLogFactory implements LogFactory{
   public Log createLog(){
       return new FileLog();
   }
}
//数据库工厂实现接口
class DatabaseLogFactory implements LogFactory{
    public Log createLog(){
        return new DatabaseLog();
    }
}
//记录接口
interface  Log{
    public void writeLog();
}
//日志实现接口
class FileLog implements Log{
    public void writeLog(){
        System.out.println("已生成日志文件记录!");
    }
}
//数据库实现接口
class DatabaseLog implements Log{
    public void writeLog(){
        System.out.println("已生成数据库文件记录!");
    }
}
 public class Client {
     public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
             Log log;
         System.out.println("请选择记录方式!  1.日志  or  2.数据库");
         for(;;) {
             int i=scanner.nextInt();
             if(i==1){
             LogFactory logFactory = new DatabaseLogFactory();
                 log = logFactory.createLog();
                 log.writeLog();
             }else if(i==2){
                 LogFactory logFactory=new FileLogFactory();
                 log = logFactory.createLog();
                 log.writeLog();
             }else{
                 break;
             }
         }
     }
 }