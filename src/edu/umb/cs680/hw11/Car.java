package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Comparator;

public class Car {



        private String make, model;
        private int mileage, year;
    private float price;
private int dominationCount;


    public Car(String make, String model, int year, int mileage, float price)
    {
        this.make=make;
        this.model=model;
        this.year=year;
        this.price=price;
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }
    public String getModel() {
        return model;
    }
    public String getMake() {
        return make;
    }
    public Float getPrice(){return price;}
    public int getMilage() { return mileage; }


    //    Collection


    void setDominationCount(ArrayList<Car> carArray){


        dominationCount = 0;

        for(Car car: carArray)
        {

            if((car.getPrice() >= this.getPrice() &
            car.getMilage() >= this.getMilage() &
            car.getYear() <= this.getYear()) &
                    (car.getPrice() > this.getPrice() |
             car.getMilage() > this.getMilage() |
             car.getYear() < this.getYear()))
            {
                dominationCount++;
            }

        }

    }


    int getDominationCount(){return dominationCount;}






    }


 class PriceComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2){
        return (int) (car1.getPrice() - car2.getPrice());
    }
}

 class YearComparator  implements Comparator<Car>{

    public int compare(Car car1, Car car2){
        return car1.getYear() - car2.getYear();
    }
}


 class MilageComparator  implements Comparator<Car>{

    public int compare(Car car1, Car car2){
        return car1.getMilage() - car2.getMilage();
    }
}


 class ParetoComparator<C> implements Comparator<Car> {

    public int compare(Car car1, Car car2) {
        return car1.getDominationCount() - car2.getDominationCount();
    }
}