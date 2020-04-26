package com.byted.camp.todolist.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhongshan
 * @date 2020-04-19.
 */
public class FileUtils {

    /**
     * 使用BufferedWriter进行添加文本内容
     */
    public static void writeContentToFile(File file, String content) {
        BufferedWriter out = null;
        try {
            //FileOutputStream(file, true),第二个参数为true是追加内容，false是覆盖
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
            out.newLine();//换行
            out.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(out);
        }
    }

    /**
     * 使用BufferedReader 进行文件内容的读取
     */
    public static List<String> readContentFromFile(File file) {
        List<String> contents = new ArrayList<>();
        BufferedReader reader = null;
        if (file != null && file.isFile() && file.exists()) { // 判断文件是否存在
            try {
                reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    contents.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeQuietly(reader);
            }
        }
        return contents;
    }

    public static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
