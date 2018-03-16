package kz.kaznitu.lessons.models;

import javax.persistence.*;

@Entity
public class AdminMoto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String motoName ;
    private int year ;
    private String color ;
    private int sum;
    private int price;


    public AdminMoto(){}

    public AdminMoto(String motoName, int year, String color,int sum, int price) {
        this.motoName = motoName;
        this.year = year;
        this.color = color;
        this.sum =sum;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMotoName() {
        return motoName;
    }

    public void setMotoName(String motoName) {
        this.motoName = motoName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year= year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color= color;
    }
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
