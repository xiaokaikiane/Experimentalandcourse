public abstract class OperatingSystemVersion {//创建系统平台抽象类
     protected VideoFile Vf;
     public void setVideoFile(VideoFile Vf){
         this.Vf=Vf;
     }
     public void play(String FileName){};
}
class WindowsVersion extends OperatingSystemVersion{//window继承类
    public void play(String FileName){
        String osType="windows下播放";
        this.Vf.decode(osType,FileName);
    }
}
class LinuxVersion extends OperatingSystemVersion{//Linux 继承类
    public void play(String FileName){
        String osType="linux下播放";
        this.Vf.decode(osType,FileName);
    }
}
class UnixVersion extends OperatingSystemVersion{//Unix 继承类
    public void play(String FileName){
        String osType="Unix下播放";
        this.Vf.decode(osType,FileName);
    }
}
