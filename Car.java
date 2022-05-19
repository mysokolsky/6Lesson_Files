import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Car implements Serializable {


    public String brandName;
    public int yearProd;
    public String color;


    public Car(String brandName, int yearProd, String color) {
        this.brandName = brandName;
        this.yearProd = yearProd;
        this.color = color;
    }


    public void saveCar(File file){

        try {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(this);
        oos.close();

    } catch (Exception ignored){};
    }


    // переопределяем метод вывода полей объекта в одну строку
    @Override
    public String toString(){

        return brandName +" "+ color +", год выпуска "+ yearProd;
    }




}
