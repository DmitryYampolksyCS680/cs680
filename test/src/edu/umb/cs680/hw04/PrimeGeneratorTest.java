package edu.umb.cs680.hw01;

/*what we test: - input type (should be positive numeric, fist<second)
                 - example range case
*/
//test github
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPrimes() {
    }

    @Test
    void isEven() {
    }

    @Test
    void isPrime() {
    }

    @Test
    void generatePrimes() {




    }


    @Test
    void regularCase_1_10() {

        PrimeGenerator gen = new PrimeGenerator(1, 10);
        gen.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};

        try {

            LinkedList<Long> primes = gen.getPrimes();

            for (Long prime : primes) {
                System.out.print(prime + ", ");
            }

            assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() );

        }
        catch(IllegalArgumentException ex) {
            System.out.print(ex.getMessage());
            //  fail("Incorrect numbers generated");
        }
    }


    @Test
    void range_10_1()
    {

        try {

            PrimeGenerator gen = new PrimeGenerator(10, 1);

        }
        catch (RuntimeException ex)
        {

            fail(ex.getMessage());
        }
    }

    @Test
    void rangeNegative()
    {

        try {

            PrimeGenerator gen = new PrimeGenerator(-10, 10);

        }
        catch (RuntimeException ex)
        {

            fail(ex.getMessage());
        }
    }

    @Test
    void main() {

        regularCase_1_10();

        range_10_1();

        rangeNegative();
    }
}