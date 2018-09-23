package com.javarush.task.task32.task3202;

import java.io.*;

/* 

Читаем из потока
Реализуй логику метода getAllDataFromInputStream. Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.


Требования:
1. Публичный статический метод getAllDataFromInputStream (InputStream) должен существовать.
2. Метод getAllDataFromInputStream (InputStream) должен возвращать StringWriter.
3. Метод getAllDataFromInputStream (InputStream) должен вернуть StringWriter, который содержит все данные из переданного потока.
4. Возвращаемый объект н
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        //создаем обхект streamreader
        StringWriter writer = new StringWriter();
        //проверяем входящий поток
        if(is != null) {

            //передаем входящий поток is  в поток для чтения inputstreamreader
            InputStreamReader isr = new InputStreamReader(is);

            //создаем символьный буффер размером в 1 МБ
            char[] buff = new char[1024 * 1024];

            // счетчик
            int count;

            //пока есть незаписанные символы  - записывать символы в буффер и передавать их в StringWriter
            while (isr.ready()) {
                count = isr.read(buff);
                writer.write(buff, 0, count);

            }
            isr.close();
        }
        return writer;
    }
}