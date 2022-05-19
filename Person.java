public class Person {

    public String name;
    public String lastname;
    public int age;
    public String phone;


    public Person(String name, String lastname, int age, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
    }

    // конструктор для быстрой инициализации объекта Person с пустыми полями для дальнейшей записи данных
    public Person() {
        name = "";
        lastname = "";
        age = 0;
        phone = "";
    }


    // переопределяем метод вывода полей объекта в одну строку
    @Override
    public String toString(){
        return name +" "+ lastname +", возраст "+ age +", телефон: "+ phone;
    }




}
