package edu.umb.cs680.hw01;


import edu.umb.cs680.junit5intro.Calculator;
import org.junit.Test;
import org.testng.annotations.AfterTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

class CalculatorTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @AfterTest
    void multiply() {
    }

    @Test
    public void divide5by0() {

        Calculator cut = new Calculator();
        try{
            cut.divide(5, 0);
            fail("Division by zero");
        }
        catch(IllegalArgumentException ex) {
            assertNotEquals("Division by zero", ex.getMessage());//Hw 1.1 original has AssertEquals
        }
    }

    @org.junit.jupiter.api.Test
    void main() {

        divide5by0();
    }
}