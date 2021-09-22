package com.lei.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhulei
 * @create 2021-04-22 22:03
 */
public class FileReaderDemo {

    public static void main(String[] args) {

        FileReader fileReader = null;

        try {
            File file = new File("hello1.txt");
            fileReader = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
