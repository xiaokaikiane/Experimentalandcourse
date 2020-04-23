import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class Client { //运行实体类
    public static void main(String[] args) {
        EncryFacode encryFacode=new EncryFacode();
        encryFacode.fileEncrypt("F:\\idea\\课设\\外观模式\\src\\haha.txt",
                "F:\\idea\\课设\\外观模式\\src\\xixi.txt");
    }
}
class FileReader{//文件读取类
    public String read(String fileNameSrc){
        System.out.println("读取文件!");
        StringBuffer stringBuffer=new StringBuffer();

        try {
            FileInputStream fileInputStream=new FileInputStream(fileNameSrc);
            int i;

            try {
                while((i=fileInputStream.read())!=-1){
                    stringBuffer=stringBuffer.append((char)i);
                }
                fileInputStream.close();
                System.out.println(stringBuffer.toString());
            } catch (IOException e) {
                throw new RuntimeException("操作异常");
            }
        } catch (FileNotFoundException e) {
             throw new  RuntimeException("文件不存在");
        }
        return stringBuffer.toString();
    }
}
class CipherMachine{//文件加密类
    public String encrypt(String plainText){
        System.out.println("文件开始加密!");
        String file="";
        for(int i=0;i<plainText.length();i++){
            String j=String.valueOf(plainText.charAt(i)%10);
            file=file+j;
        }
        System.out.println("文件加密结束!");
        System.out.println(file);
        return file;
    }
}
class FileWriter{//文件保存类
    public void write(String encryptText,String fileNameDes){
        System.out.println("加密完成,保存!");
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(fileNameDes);
            try {
                fileOutputStream.write(encryptText.getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("操作异常");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("文件不存在");
        }
    }
}
class EncryFacode{ //外观类
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public EncryFacode() {
       reader= new FileReader();
       cipher=new CipherMachine();
       writer= new FileWriter();
    }
    public void fileEncrypt(String fileNameSrc,String fileNameDes){
        String plainStr=reader.read(fileNameSrc);
        String encryptStr=cipher.encrypt(plainStr);
        writer.write(encryptStr,fileNameDes);
    }
}
