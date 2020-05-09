package com.zhaoliu.blog.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtil {
	

    /*
    * 方法1：批量关闭流，参数能传无限个。(3分)
    * 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
    */
    public static void closeAll(Closeable... closeableList) {
        try {
            for (Closeable closeable : closeableList) {
                if (closeable != null){
                    closeable.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        
    }
    }
    
    
    
    /*
    * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(3分)，要求方法内部调用上面第1个方法关闭流(3分)
    */
    public static String readTextFile(InputStream src) throws IOException{
    	
    	 ByteArrayOutputStream out = new  ByteArrayOutputStream();
	        int c ;
	        byte[] buffer = new byte[1024];  //创建缓存区，批量操作字节
	        
	        while((c = src.read(buffer))!=-1){
	        	out.write(buffer, 0,c);
	        }
	        out.flush();
	        StreamUtil.closeAll(src,out);
	        String string = out.toString("utf-8");//使用utf-8编码
	        return string;
	      
	    }
    	
    
    
    /*
    * 方法3：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
    */
    public static String readTextFile(File txtFile) throws FileNotFoundException, IOException{
    	
    	
    return	readTextFile(new FileInputStream(txtFile));
   
    }
    	

	

}

    

