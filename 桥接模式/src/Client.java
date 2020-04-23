import java.util.Scanner;

public class Client {  //实例演示
    public static void main(String[] args) {
        String File="西游记";
        VideoFile videoFile;
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("请选择播放系统 1.Windows  2.Linux  3.Unix  4.退出");
            int j = scanner.nextInt();
            if(j==1) {
                OperatingSystemVersion systemVersion = new WindowsVersion();
                while(true){
                System.out.println("请选择播放格式 1.MPEG  2.RMV  3.AVI  4.WMV  5.退出");
                int i=scanner.nextInt();
                if(i==1) {
                    videoFile = new MPEGFile();
                    systemVersion.setVideoFile(videoFile);
                    systemVersion.play(File);
                }else if(i==2){
                    videoFile=new RMVFile();
                    systemVersion.setVideoFile(videoFile);
                    systemVersion.play(File);
                }else if(i==3){
                    videoFile=new AVIFile();
                    systemVersion.setVideoFile(videoFile);
                    systemVersion.play(File);
                }else if(i==4){
                    videoFile=new WMVFile();
                    systemVersion.setVideoFile(videoFile);
                    systemVersion.play(File);
                }else{
                    break;
                }
                }
            }else if(j==2){
                OperatingSystemVersion systemVersion = new LinuxVersion();
                while (true) {
                    System.out.println("请选择播放格式 1.MPEG  2.RMV  3.AVI  4.WMV  5.退出");
                    int i = scanner.nextInt();
                    if (i == 1) {
                        videoFile = new MPEGFile();
                        systemVersion.setVideoFile(videoFile);
                        systemVersion.play(File);
                    } else if (i == 2) {
                        videoFile = new RMVFile();
                        systemVersion.setVideoFile(videoFile);
                        systemVersion.play(File);
                    } else if (i == 3) {
                        videoFile = new AVIFile();
                        systemVersion.setVideoFile(videoFile);
                        systemVersion.play(File);
                    } else if (i == 4) {
                        videoFile = new WMVFile();
                        systemVersion.setVideoFile(videoFile);
                        systemVersion.play(File);
                    } else {
                        break;
                    }
                }
            }else if(j==3){
                OperatingSystemVersion systemVersion = new UnixVersion();
                while(true) {
                    System.out.println("请选择播放格式 1.MPEG  2.RMV  3.AVI  4.WMV  5.退出");
                    int i = scanner.nextInt();
                    if (i == 1) {
                        videoFile = new MPEGFile();
                        systemVersion.setVideoFile(videoFile);
                        systemVersion.play(File);
                    } else if (i == 2) {
                        videoFile = new RMVFile();
                        systemVersion.setVideoFile(videoFile);
                        systemVersion.play(File);
                    } else if (i == 3) {
                        videoFile = new AVIFile();
                        systemVersion.setVideoFile(videoFile);
                        systemVersion.play(File);
                    } else if (i == 4) {
                        videoFile = new WMVFile();
                        systemVersion.setVideoFile(videoFile);
                        systemVersion.play(File);
                    } else {
                        break;
                    }
                }
            }else{
                break;
            }
        }
    }
}
