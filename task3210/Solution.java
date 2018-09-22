package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        //первый аргумент - имя файла
        String fileName = args[0];
        //второй аргумент - позиция файла
        int pos = Integer.parseInt(args[1]);
        // третий аргумент - текст для сравнения
        String text = args[2];
        try(RandomAccessFile raf = new RandomAccessFile(fileName, "rw" )){
            //создаем буффер для записи - длина равна длине текста
            byte[] buf = new byte[text.length()];
            //устанавливаем курсор на место
            raf.seek(pos);
            //считываем в буффер байты из файла
            raf.read(buf, 0, buf.length);
            String resultText = new String (buf);
            String endOfFile = resultText.equals(text) ? "true" : "false";
            raf.seek(raf.length());
            raf.write(endOfFile.getBytes());

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }


    }

