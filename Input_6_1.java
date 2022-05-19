//        #1 Необходимо реализовать класс, который запрашивает
//        данные у пользователя через терминал и записывает их в файл,
//        пока не будет введена команда !q
//

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;


public class Input_6_1 {
    public static void main (String[] args) {

        // Создаём объект типа File, присваивая ему относительный путь к файлу
        File file = new File("./src/data.txt");

        System.out.println();
        System.out.println("Введи данные построчно, отделяя каждую строку клавишей 'Enter'.");
        System.out.println("Каждая введённая строчка будет записана в файл ./src/data.txt ");
        System.out.println();
        System.out.println("Внимание!!! При желании выйти, введи комбинацию двух знаков '!q'");
        System.out.println();
        System.out.println("Итак, вводи данные ниже:");
        System.out.println();

        // создаём пустой объект типа PrintWriter
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);  // передаём ему объект типа File
        } catch (IOException e) {              // ловим возможную ошибку
            System.out.println("Файл для записи не найден");
        }

        Scanner input = new Scanner(System.in);     // создаём объект типа Scanner для считывания ввода с клавиатуры

        while (true) {

            String line = input.nextLine();         // считываем построчный ввод с клавиатуры
            if (Objects.equals(line, "!q")) {break;}    // проверяем на наличие комбинации для выхода

            writer.println(line);       // записываем введённую строчку в файл
        }
        writer.close();             // закрываем файл


    }
}
