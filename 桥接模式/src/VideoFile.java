
public interface VideoFile {//创建视频格式接口
    public void decode(String osType,String FileName);
}
class MPEGFile implements VideoFile{//MPEG格式类实现接口
    @Override
    public void decode(String osType, String FileName) {
        System.out.println(osType+"MPEG格式的"+FileName+".");
    }
}
class RMVFile implements VideoFile{//PMV格式类实现接口
    @Override
    public void decode(String osType, String FileName) {
        System.out.println(osType+"RMV格式的"+FileName+".");
    }
}
class AVIFile implements VideoFile{//AVI格式类实现接接口
    @Override
    public void decode(String osType, String FileName) {
        System.out.println(osType+"AVI格式的"+FileName+".");
    }
}
class WMVFile implements VideoFile{//WMV格式类实现接口
    @Override
    public void decode(String osType,String FileName){
        System.out.println(osType+"WMV格式的"+ FileName+".");
    }
}
