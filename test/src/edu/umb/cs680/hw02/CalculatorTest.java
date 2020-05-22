package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void multiply() {
    }

    @Test
    void divide() {
    }

    @Test
    void main() {
    }
}

//
//package edu.umb.cs680.hw02;
//
//        import org.junit.jupiter.api.Test;
//        import org.testng.annotations.AfterTest;
//
//        import static org.junit.jupiter.api.Assertions.*;
//        import static org.junit.jupiter.api.Assertions.fail;
//
//class CalculatorTest {
//
//    @org.junit.jupiter.api.BeforeEach
//    void setUp() {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    void tearDown() {
//    }
//
//    @AfterTest
//    void multiply() {
//    }
//
//    @Test
//    public void divide5by0() {
//
//        Calculator cut = new Calculator();
//        try{
//            cut.divide(5, 0);
//            fail("Division by zero");
//        }
//        catch(IllegalArgumentException ex) {
//            assertNotEquals("Division by zero", ex.getMessage());//Hw 1.1 original has AssertEquals
//        }
//    }
//
//    @org.junit.jupiter.api.Test
//    void main() {
//
//        divide5by0();
//    }
//}