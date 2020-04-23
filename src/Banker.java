import java.util.Scanner;
public class Banker {
    Scanner scanner = new Scanner(System.in);
    int num=scanner.nextInt();//进程数
    int num2=scanner.nextInt();//资源数
    int available[] = new int[num2];
    int max[][] = new int[num][num2]; // 最大需求
    int allocation[][] = new int[num][num2]; // 分配
    int need[][] = new int[num][num2]; // 需求
    int request[] = new int[num2]; // 存放请求
    int thread; //进程号
    public void menu(){
        System.out.println("==========请选择=========");
        System.out.println("========1.安全检测=======");
        System.out.println("========2.动态请求资源====");
        System.out.println("========3.退出===========");
    }
// 初始化
public void getData() {
    System.out.println("请输入"+num2+"类资源的数目：");
    // 输入num2类资源数量
    for (int i = 0; i < num2; i++) {
        available[i] = scanner.nextInt();
    }
    // 输入进程对num2类资源的最大需求
   for (int i = 0; i < num; i++) {
       System.out.println("请输入进程" + i + "对"+num2+"类资源的最大需求");
       for (int j = 0; j < num2; j++) {
           max[i][j] = scanner.nextInt();
       }
   }
//输入进程分配的num2资源数
    for (int i = 0; i < num; i++) {
        System.out.println("请输入进程" + i + "已分配的"+num2+"资源数");
        for (int j = 0; j < num2; j++) {
            allocation[i][j] = scanner.nextInt();
        }
    }
    // 计算进程还需要的num2类资源数
for (int i = 0; i < num; i++) {
    for (int j = 0; j < num2; j++) {
        need[i][j] = max[i][j] - allocation[i][j];
    }
}
// 重新计算available
 for (int i = 0; i < num2; i++) {
     for (int j = 0; j < num; j++) {
         available[i] -= allocation[j][i];
     }
 }
}
    public boolean check2(){//判断请求的资源是否超过系统剩余的资源
        for(int i=0;i<num2;i++){
            if(request[i]>available[i]){
                return true;
            }
        }
        return false;
    }
    public boolean check1(int thread){//判断请求的资源是否超过需要的资源
        for(int i=0;i<num2;i++){
            if(request[i]>need[thread][i]){
                return true;
            }
        }
        return false;
    }
// 用户输入要申请资源的进程和申请的资源，并进行判断
public void getThread() {
    System.out.println("请输入申请资源的线程");
    for(;;) {
        thread = scanner.nextInt();
        if (thread < 0 || thread > num - 1) {
            System.out.println("该线程不存在,请重新输入");
        }else{
            break;
        }
    }
    System.out.println("请输入申请的资源(若某种资源不申请则填0)");
    for(;;) {
        for (int i = 0; i < num2; i++) {
            request[i] = scanner.nextInt();
        }
        if (check1(thread)) {
            System.out.println(thread + "线程申请的资源超出其需要的资源，请重新输入");
        } else if (check2()) {
                System.out.println(thread + "线程申请的资源大于系统资源，请重新输入");
        }else{
            break;
        }
    }
       changeData(thread);
       showData();
       if (!check()) {
           System.out.println("资源申请失败!");
           recoverData(thread);//系统不安全,还原已经分配的资源
           showData();
       }else{
           System.out.println("资源申请成功!");
           isComplete(thread);
           showData();
       }
    }
    public void isComplete(int thread){
        for(int i=0;i<num2;i++){
            if(need[thread][i]!=0){
                break;
            }
            if(need[thread][num2-1]==0){ //当need全为0时,将该进程的已分配资源返还给系统
                for(int j=0;j<num2;j++){
                    available[j]+=allocation[thread][j];
                    allocation[thread][j]=0;
                }
            }
        }
    }
    // thread线程请求响应后，试探性分配资源
public void changeData(int thread) {
    for (int i = 0; i < num2; i++) {
        // 重新调整系统资源数
      available[i] -= request[i];
      // 计算各个进程拥有资源
        allocation[thread][i] += request[i];
        // 重新计算需求
       need[thread][i] -= request[i];
    }
}
// 安全性检查未通过，分配失败时调用，恢复系统原状
 public void recoverData(int thread) {
    for (int i = 0; i < num2; i++) {
        // 重新调整系统资源数
        available[i] += request[i];
        // 计算各个进程拥有资源
        allocation[thread][i] -= request[i];
        // 重新计算需求
       need[thread][i] += request[i];
    }
}
// 对线程thread安全性检查
public boolean check() {
    boolean finish[] = new boolean[num];
    int work[] = new int[num2];
    int queue[] = new int[num];// 用于存放安全队列
     int k = 0;// 安全队列下标
   int j=0; // 要判断的进程
  int i;
  // 是否分配的标志
    for (i = 0; i < num; i++) {
        finish[i] = false;
    }
    for (i = 0; i < num2; i++) {
        work[i] = available[i];
    }
    while (j < num) {
        for (i = 0; i < num2; i++) {
            if (finish[j]) {
                j++;
                break;
            } else if (need[j][i] > work[i]) { //某一类资源需求量大于系统的数量
                j++;
                break;
            } else if (i == num2-1) {
                for (int m = 0; m < num2; m++) {
                    work[m] += allocation[j][m];
                }
                finish[j] = true;
                queue[k] = j;
                k++;
                j = 0; // 从最小进程再开始判断
            }
        }
    }
    // 判断是否都属于安全状态
    for (int p = 0; p < num; p++) {
        if (finish[p] == false) {
            System.out.println("系统不安全");
            return false;
        }
    }
    System.out.println("系统是安全的,安全队列为：");
    for (int q = 0; q < num; q++) {
        System.out.println(queue[q]);
    }
    return true;
  } 	// 打印表，需要时调用
 public void showData() {
        System.out.println("进程   已分配 最大需求 系统剩余 进程需求");
        for(int j=0;j<num;j++) {
            System.out.printf("p" + j + "    ");
            for (int i = 0; i < num2; i++) {
                System.out.print(allocation[j][i]+" ");
            }
            System.out.print(" ");
            for(int a=0;a<num2;a++){
                System.out.print(max[j][a]+" ");
            }
            System.out.print(" ");
            if(j==0) {
                for (int b = 0; b < num2; b++) {
                    System.out.print(available[b]+" ");
                }
            }else{
                System.out.print("      ");
            }
            System.out.print(" ");
            for(int c=0;c<num2;c++){
                System.out.print(need[j][c]+" ");
            }
            System.out.print("\n");
        }
 }
public static void main(String[] args) {
        System.out.println("请输入进程个数与资源种类数:");
    Scanner scanner = new Scanner(System.in);
    Banker bk = new Banker();
    bk.getData();
    bk.showData();
    for(;;) {
        bk.menu();
        System.out.println("请输入你的选择:");
        int k = scanner.nextInt();
        if (k == 1) {
            bk.check();
        } else if (k == 2) {
            bk.getThread();
        } else if (k == 3) {
            System.out.println("拜拜!");
            break;
        }
    }
}
}
