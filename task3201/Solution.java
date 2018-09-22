package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        //первый аргумент - имя файла
        String fileName = args[0];
        //второй аргумент - позиция файла
        int pos = Integer.parseInt(args[1]);
        // третий аргумент - текст для записи в файл
        String text = args[2];
           try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")){
               byte[] buf = new byte[text.length()];

               pos = pos > (int)file.length() ? (int)file.length() : pos;
               file.seek(pos);
               file.write(text.getBytes());
               file.close();
         } catch (IOException  e) {
             e.printStackTrace();
         }


    }
}
