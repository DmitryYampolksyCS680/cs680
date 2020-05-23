package edu.umb.cs680.hw13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StockQuoteObservable  {


    ArrayList<StockQuoteObserver> observers;

    private boolean changed = false;

    void changeQuote(String t,
                     float q){

        notifyObservers(new StockEvent(t, q));

    }



    void notifyObservers(StockEvent e){

        for(StockQuoteObserver o: observers)
            o.updateStock(e);

    }


    void addObserver(StockQuoteObserver o){


        if(observers==null)
            observers = new ArrayList<StockQuoteObserver>();


        observers.add(o);
    }



    interface StockQuoteObserver{
        void updateStock(StockEvent e);

    }


}
