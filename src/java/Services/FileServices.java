/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Long
 */
public class FileServices {
    public static String readTextFile(String path) throws IOException{
        File file=new File(path);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF8");
        BufferedReader reader = new BufferedReader(inputStreamReader);
        
               
        String result="";
        String line;
        while ((line=reader.readLine())!=null) result+=line;
        System.out.println(result);
        return result;
    }
    
    public void writeTextFile(String content,String path) throws IOException{
        File file=new File(path);
        OutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF8");
        outputStreamWriter.write(content);
        outputStreamWriter.flush();
    }
    
    
}
