package com.lei.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zhulei
 * @create 2021-04-22 19:19
 */
public class Test {

    @org.junit.Test
    public void test() {

        FileWriter fileWriter = null;

        try {
            File file = new File("hello1.txt");
            fileWriter = new FileWriter(file,false);
            fileWriter.write("I Have a Dream\n");
            fileWriter.write("xxxxxxx aaaaaa ccccc\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
