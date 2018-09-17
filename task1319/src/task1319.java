import java.io.*;




/*
Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего читать из файловой системы.
4. Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.
7. Метод main не должен выводить данные на экран.
*/

public class task1319 {

    public static void main(String[] args) throws IOException { // пробрасываем исключение

        String string = null;

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));// инициализируем BufferReader через поток ввода с клавиатуры

        File yourFile = new File(br.readLine()); // создаем объект класса файл , путь вводим вручную
        FileWriter fw = new FileWriter(yourFile); // создаем символьный поток для записи в файл
        BufferedWriter bw = new BufferedWriter(fw);// создаем символьный буфферезированный поток, который записывает в поток записи файла
        do {
            string = br.readLine();//считываем строку с клавиатуры
            bw.write(string + "\n"); // записываем в поток записи строку с отступом
        } while(!string.equals("exit")); // выполняем цикл, пока строка не эквивалентна exit

        br.close(); // последовательно закрываем все открытые потоки
        bw.close();
        fw.close();
    }
}