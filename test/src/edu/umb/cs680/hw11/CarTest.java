package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

@Test
    public  void mainTest() {




//    public Car(String make, String model, int year, int milage)

    String carMake = "Yampolsky";
    String carModel = "Dmitry";

    ArrayList<Float> carPrices = new ArrayList<Float>();
    carPrices.add(1000.0f);carPrices.add(2000.0f);carPrices.add(2000.0f);carPrices.add(2000.0f);carPrices.add(3000.0f);

    ArrayList<Integer> carMielage = new ArrayList<Integer>();
    carMielage.add(3);carMielage.add(1);carMielage.add(2);carMielage.add(4);carMielage.add(5);

    ArrayList<Integer> carYear = new ArrayList<Integer>();
    carYear.add(2005);carYear.add(2004);carYear.add(2003);carYear.add(2002);carYear.add(2001);


    ArrayList<Car> usedCars= new ArrayList<Car>();

    for(int i = 0; i <= 4; i++) {
        usedCars.add(new Car(carMake, carModel, carYear.get(i), carMielage.get(i), carPrices.get(i)));
    }


    for(Car car : usedCars)
        car.setDominationCount(usedCars);



    Collections.sort(usedCars,new ParetoComparator<Car>());







    Collections.sort(usedCars,new PriceComparator());



    ArrayList<Float> sortedCarPrices = new ArrayList<Float>(carPrices);
    Collections.sort(sortedCarPrices);
    ArrayList<Float> actualPrices = new ArrayList<Float>();
    for(Car car:usedCars)
        actualPrices.add(car.getPrice());
    assertEquals(sortedCarPrices,actualPrices);


    Collections.sort(usedCars,new MilageComparator());

    ArrayList<Integer> sortedCarMielage = new ArrayList<Integer>(carMielage);
    Collections.sort(sortedCarMielage);
    ArrayList<Integer> actualMielage = new ArrayList<Integer>();
    for(Car car:usedCars)
        actualMielage.add(car.getMilage());

    assertEquals(sortedCarMielage,actualMielage);




    Collections.sort(usedCars,new YearComparator());

    ArrayList<Integer> sortedCarYear = new ArrayList<Integer>(carYear);
    Collections.sort(sortedCarYear);
    ArrayList<Integer> actualYear = new ArrayList<Integer>();
    for(Car car:usedCars)
        actualYear.add(car.getYear());

    assertEquals(sortedCarYear,actualYear);




    }

}