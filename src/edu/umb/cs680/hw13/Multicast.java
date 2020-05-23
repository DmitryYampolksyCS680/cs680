package edu.umb.cs680.hw13;


import java.util.List;


class  PiechartObserver implements DJIAQuoteObservable.DJIAQuoteObserver, StockQuoteObservable.StockQuoteObserver {


    protected int piechartDJIAEventCounter = 0;

    @Override
    public void updateDJIA(DJIAEvent e) {


            System.out.println("PiechartObserver, DJIAEvent update");

            piechartDJIAEventCounter++;
    }


    @Override
    public void updateStock(StockEvent e) {

        System.out.println("PiechartObserver, StockEvent update");

    }
}



class  TableObserver  implements DJIAQuoteObservable.DJIAQuoteObserver, StockQuoteObservable.StockQuoteObserver {


    @Override
    public void updateDJIA(DJIAEvent e) {


        System.out.println("TableObserver, DJIAEvent update");

    }


    @Override
    public void updateStock(StockEvent e) {

        System.out.println("TableObserver, StockEvent update");

    }
}


class  ThreeDObserver implements DJIAQuoteObservable.DJIAQuoteObserver, StockQuoteObservable.StockQuoteObserver{


    @Override
    public void updateDJIA(DJIAEvent e) {


        System.out.println("ThreeDObserver, DJIAEvent update");

    }


    @Override
    public void updateStock(StockEvent e) {

        System.out.println("ThreeDObserver, StockEvent update");

    }
}

abstract class MulticastEvent{}


class StockEvent extends MulticastEvent {

    private String ticker;
    private float quote;

    public StockEvent(String t,float q)
    {
        ticker=t;
        quote=q;
    }

}

class DJIAEvent extends MulticastEvent {

    private float djia;


    public DJIAEvent(float d){
        djia=d;
    }
}