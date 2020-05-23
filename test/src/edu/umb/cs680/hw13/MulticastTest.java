package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MulticastTest {

    static StockQuoteObservable stockObservable = new StockQuoteObservable();
    static DJIAQuoteObservable djiakObservable = new DJIAQuoteObservable();

    static String stockEventString = "Stock event 1 quote = 1";
    static float stockEventQuote=1, djiaFloat = 2;

@Test
    public void testMulticast(){




    PiechartObserver piechartObserver = new PiechartObserver();
    TableObserver tableObserver = new TableObserver();
    ThreeDObserver threeDObserver = new ThreeDObserver();


    stockObservable.addObserver(piechartObserver);
    stockObservable.addObserver(tableObserver);
    stockObservable.addObserver(threeDObserver);

    djiakObservable.addObserver(piechartObserver);
    djiakObservable.addObserver(tableObserver);
    djiakObservable.addObserver(threeDObserver);



    StockEvent stockE = new StockEvent(stockEventString,stockEventQuote);
    DJIAEvent djiaE= new DJIAEvent(djiaFloat);


    stockObservable.notifyObservers(stockE);

    djiakObservable.notifyObservers(djiaE);





    changeQuote();


    assertEquals(piechartObserver.piechartDJIAEventCounter,2);



    }


    @Test
    static void changeQuote() {

    try {
        djiakObservable.changeQuote(djiaFloat);
        stockObservable.changeQuote(stockEventString, stockEventQuote);

        fail("Observable changeQuote operation fail.");
    } catch (Exception exception) {
        System.out.print(exception.getMessage());
    }

    }



    @Test
    void addObserver() {
    }
}