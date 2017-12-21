package compare;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangsy
 * @date 2017/12/12
 */
public class Car implements Comparable{

    private String brand;
    private Integer price;
    private String color;

    public Car(String brand, Integer price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int compareTo(Object o) {

        return this.price - ((Car) o).getPrice() != 0 ? this.price - ((Car) o).getPrice() : this.brand.compareTo(((Car) o).getBrand());
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
