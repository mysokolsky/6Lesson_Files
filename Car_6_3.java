// #3 Реализовать класс Car, с полями присущими автомобилю (скорость, цвет и тд).
// Создать метод, который бы сохранял указанный объект на диск и статический метод класса,
// который бы читал файл и создавал объект


import java.io.*;
import java.util.Scanner;


public class Car_6_3 {
    public static void main(String[] args) {


        System.out.println();
        System.out.println("Заполняем массив авто.");

        Car car1 = new Car("Ferrari", 1967, "красный");
        Car car2 = new Car("Запорожец", 1975, "голубой");
        Car car3 = new Car("Москвич", 1983, "салатовый");
        Car car4 = new Car("Bugatti",2007,"синий");
        Car car5 = new Car("T34", 1942,"оливковый");


        Car[] cars = {car1, car2, car3, car4, car5};

        //распечатка объектов
        printCars(cars);


        //считываем выбор объекта пользователем
        byte number = inputCar(cars.length);


        System.out.println("Был выбран объект:");
        System.out.println(cars[number - 1]);
        System.out.println();


        //присваиваем имя файлу для записи на диск
        String fileName = "./src/" + cars[number - 1].brandName + ".car";

        System.out.println("Запишем выбранный объект в файл " + "'" + fileName + "'");


        //инициализируем объект типа File
        File file = new File(fileName);


        //вызов метода сохранения объекта на диск в файл
        cars[number - 1].saveCar(file);


        //вызов статического метода чтения объекта из файла
        readCar(file);

    }


    // метод захватывает пожелание пользователя, какой объект записать в файл
    public static byte inputCar(int arrlength){

        System.out.println();
        System.out.println("Выберите номер объекта для сохранения в файл и нажмите Enter. ");


        byte number = 0;

        while (number < 1 || number > arrlength) {

            System.out.println("Номер должен быть от 1 до " + arrlength);
            try {
                number = (new Scanner(System.in)).nextByte();
            }catch(Exception ignored){};
        }

        return number;

    }


// метод выводит на экран под номерами все объекты массива
    public static void printCars(Car[] cars){
        System.out.println();
        System.out.println("Есть такие объекты класса Car:");
        System.out.println();

        int i = 0;
        for (Car car : cars) {
            ++i;
            System.out.print(i + ") ");
            System.out.println(car);
        }


    }


// метод читает из файла объект
    public static void readCar(File file) {


        System.out.println();
        System.out.println();
        System.out.println("Теперь читаем записанный объект из файла!");
        System.out.println();

        try {

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

            Car car = (Car) ois.readObject();

            System.out.println(car);

            ois.close();

        } catch (Exception ignored) {}

    }
}
