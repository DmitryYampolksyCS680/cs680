package edu.umb.cs680.hw13;

import java.util.ArrayList;
import java.util.List;

public class DJIAQuoteObservable {

    private float quote;


    ArrayList<DJIAQuoteObserver> observers;

    void changeQuote(float q){

        quote = q;

        notifyObservers(new DJIAEvent(q));

    }


    void notifyObservers(DJIAEvent e){

        for(DJIAQuoteObserver o: observers)
            o.updateDJIA(e);

    }

    void addObserver(DJIAQuoteObserver o){

        if(observers==null)
            observers = new ArrayList<DJIAQuoteObserver>();


        observers.add(o);
    }


    interface DJIAQuoteObserver{
        void updateDJIA(DJIAEvent e);

    }





}
