package util;
import java.io.*;
/**
 * 先生成一个文件，然后把这个文件写入(copy)到另一个文件
 * @author yyc
 *
 */
public class ReadandWrite {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
        String str1 = "/Users/yyc/Documents/123.jpg";
        String str2 = "/Users/yyc/Documents/321.jpg ";
//        copyFile1(str1, str2);
//        copyFile2(str1, str2);
        try {
			copyFile1(str1, str2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    // 方法一
    public static void copyFile1(String srcPath, String destPath) throws IOException {
        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);
        
        // 读取和写入信息
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        
        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关
}
    }