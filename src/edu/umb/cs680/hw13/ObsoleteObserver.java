package edu.umb.cs680.hw13;



import java.util.Observable;
import java.util.Observer;


public class ObsoleteObserver{

class StockQuoteObservable extends Observable {



    void changeQuote(String t,
                     float q){
        setChanged();
        notifyObservers(new StockEvent(t, q));

    }

}

class DJIAQuoteObservable extends Observable{

    private float quote;

    void changeQuote(float q){

        quote = q;

        setChanged();
        notifyObservers(quote);

    }


}


class  PiechartObserver implements Observer {


    @Override
    public void update(Observable observable, Object o) {


        if( o instanceof StockEvent)
            System.out.println("PiechartObserver, StockEvent update");
        else if ( o instanceof DJIAEvent)
            System.out.println("PiechartObserver, DJIAEvent update");


    }
}



class  TableObserver implements  Observer{


    @Override
    public void update(Observable observable, Object o) {

        if( o instanceof StockEvent)
            System.out.println("TableObserver, StockEvent update");
        else if ( o instanceof DJIAEvent)
            System.out.println("TableObserver, DJIAEvent update");



    }
}


class  ThreeDObserver implements  Observer{


    @Override
    public void update(Observable observable, Object o) {

        if( o instanceof StockEvent)
            System.out.println("ThreeDObserver, StockEvent update");
        else if ( o instanceof DJIAEvent)
            System.out.println("ThreeDObserver, DJIAEvent update");



    }
}

class StockEvent{

    private String ticker;
    private float quote;

    public StockEvent(String t,float q)
    {
        ticker=t;
        quote=q;
    }

}

class DJIAEvent{

    private float djia;
}

}