package edu.umb.cs680.hw05;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    private Object[] carToStringArray(Car car_in)
    {
        String year = String.valueOf(car_in.getYear());
        return new String[]{car_in.getMake(),car_in.getModel(), year};
    }

@Test
void verifyCarEqualityWithMakeModelYear()
{
    String[] expected = {"Toyota", "RAV4","2018"};
    Car actual = new Car("Toyota","RAV4",2018);


       assertArrayEquals(expected, carToStringArray(actual));


}





}