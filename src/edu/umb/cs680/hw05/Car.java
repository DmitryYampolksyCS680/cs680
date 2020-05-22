package edu.umb.cs680.hw05;

public class Car {



        private String make, model;
        private int mileage, year;
    private float price;



    public Car(String make,String model,int year)
    {
        this.make=make;
        this.model=model;
        this.year=year;

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

}
