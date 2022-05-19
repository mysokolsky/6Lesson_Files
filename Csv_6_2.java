//        #2 Необходимо создать класс Person с полями: Имя, Фамилия, возраст, телефон. Записать в формате CSV (Загуглите как он выглядит)
//        в файл таблицу с указанными выше данными (человек 5 и заголовки). Написать парсер CSV файлов, который должен создать массив объектов класса
//        Person, прочитав данные их csv файла.


import java.io.*;

public class Csv_6_2 {
    public static void main(String[] args) {

        // создаём объекты типа Person
        Person person1 = new Person("Иван","Коробков",23,"+7 921 999-88-77");
        Person person2 = new Person("Николай","Петров",37,"+7 921 944-48-73");
        Person person3 = new Person("Зинаида","Ульянова",56,"+7 933 888-22-33");
        Person person4 = new Person("Порфирий","Прохоров",18,"+7 999 444-33-11");
        Person person5 = new Person("Демьян","Бедный",41,"+7 777 222-33-11");

        // для удобства работы с объектами, создаём из них массив
        Person[] people = {person1,person2,person3,person4,person5};

        // для записи и чтения объектов в файл/из файла, создаём объект типа File и присваиваем ему относительный путь
        File file = new File("./src/table.csv");

        // открываем обработку ошибок
    try {
    // создаём пустой объект типа PrintWriter
    PrintWriter writer = new PrintWriter(file);  // передаём ему объект типа File

    writer.println("Имя,Фамилия,возраст,телефон");       // записываем первую строку-заголовок в файл

        //через цикл for-each записываем построчно через запятую поля объектов типа Person в файл
    for (Person human : people) {
        writer.println(human.name + ',' + human.lastname + ',' + human.age + ',' + human.phone);
    }
    writer.close();             // закрываем файл




//    people = new Person[]{null, null, null, null, null};


//        for (Person human : people) {
//
////            human = null;
//
////            human = new Person();
//
//
//        }




//        Начинаем чтение из файла
    BufferedReader reader = new BufferedReader(new FileReader(file));

    // инициализируем переменную типа String, которая при чтении файла вызывает метод построчного чтения
    String line = reader.readLine();

    int p = 0;      // инициализируем счётчик для массива объектов Person

    // запускаем построчный парсинг читаемых строк
    while (line != null){           // пока строка не пустая, продолжаем считывать данные из файла

        line = reader.readLine();   // считываем следующую строку

        if (line == null) break;    // если строка пустая, то выходим из цикла чтения while

        people[p] = new Person();   // если строка не пустая, то инициализируем новый объект типа Person с нулевыми значениями и записываем его в массив


        String str = "";
        int j=0;                    // инициализируем счётчик для счёта полей объектов типа Person


        for (int i=0; i<line.length(); ++i) {               //запускаем цикл посимвольного чтения строки
           String c = String.valueOf(line.charAt(i));       // берём текущий символ и присваем ему тип String

            if (c.equals(",")) {                            //если запятая, то

                switch (j) {                                // запускаем присвоение накопленной строки к конкретному полю текущего объекта Person
                    case 0:
                        people[p].name = str;               // накопленная строка присваивается полю name
                    case 1:
                        people[p].lastname = str;
                    case 2:
                        try {                                       //обрабатываем ошибку NumberFormatException

                            people[p].age = Integer.parseInt(str);  //переводим строку в число типа int для поля присвоения
                                                                    // полю age текущего объекта типа Person
                        }
                        catch (NumberFormatException ignored){}     //игорируем ошибку
                }
                ++j;

                str="";
                c="";       // после присвоения строки полю объекта обнуляем накопленную строку и текущий символ

            }
            str = str + c;  // если текущий символ не = запятой, то прибавляем его к накопленной строке

        }
        people[p].phone = str;  //если достигли конца прочтённой из файла строки,
                                // то последнюю накопленную строку присваиваем полю phone текущего объекта Person


        // выводим все поля текущего объекта Person на экран в одну строчку,
        // заранее переопределив метод toString() в классе Person

        System.out.println(people[p]);


        ++p;        // счётчик для массива объектов Person

    }

    reader.close();     // при достижении пустой строки, закрываем файл.


    }
    catch (IOException e) {     // обрабатываем ошибки при работе с файлами
        e.printStackTrace();
    }


    }
}
