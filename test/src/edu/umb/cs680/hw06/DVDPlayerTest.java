package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.DVDPlayer;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

//
//try {
//        djiakObservable.changeQuote(djiaFloat);
//        stockObservable.changeQuote(stockEventString, stockEventQuote);
//
//        fail("Observable changeQuote operation fail.");
//        } catch (Exception exception){
//        System.out.print(exception.getMessage());
//
//
//        }


class DVDPlayerTest {


    public void mainTest()

    {


    }


    @Test
    static void getInstance() {

        try {
            DVDPlayer d = DVDPlayer.getInstance();

            fail("DVDPlayer.getInstance fail.");
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }




    }

    @Test
    void changeState() {
    }

    @Test
    void buttonPushed() {

        DVDPlayer d = DVDPlayer.getInstance();


        d.openCloseButtonPushed();
        assertEquals("open",d.getStateName());


        d.playButtonPushed();
        assertEquals("playing",d.getStateName());

        d.stopButtonPushed();
        assertEquals("closed",d.getStateName());




    }


}