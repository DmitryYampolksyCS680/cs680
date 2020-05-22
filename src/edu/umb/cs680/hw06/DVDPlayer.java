package edu.umb.cs680.hw06;

public class DVDPlayer {



    private DVDPlayer()
    {
        state = new DrawerClosedNotPlaying();
    }

    private static DVDPlayer player=null;

     public DVDPlayer getInstance()
    {
        if(player==null) {
            player = new DVDPlayer();
        }
        return player;
    }

    State state;


    void changeState(State state_in) {
        this.state = state_in;
    }

    void openCloseButtonPushed()
    {
        state.openCloseButtonPushed();
    }
    void playButtonPushed()
    {
        state.playButtonPushed();
    }
    void stopButtonPushed()
    {
        state.stopButtonPushed();
    }


    //placeholders?
    void open(){}
    void close(){}
    void play(){}
    void stop(){}


    interface State
    {
        void openCloseButtonPushed();
        void playButtonPushed();
        void stopButtonPushed();
    }



    private static class DrawerOpen implements State {


        private static DrawerOpen open=null;

        static DrawerOpen getInstance()
        {
            if(open==null) {
                open = new DrawerOpen();
            }
            return open;
        }


        public void openCloseButtonPushed() {
            player.close();
            player.changeState(DrawerClosedNotPlaying.getInstance());
        }

        public void playButtonPushed()
        {
            player.close();
            player.play();
            player.changeState(DrawerClosedPlaying.getInstance());
        }

        public void stopButtonPushed()
        {
        }
    }



    private static class DrawerClosedPlaying implements State
    {

    private static DrawerClosedPlaying closedPlaying =null;

    static DrawerClosedPlaying getInstance()
    {
        if(closedPlaying==null) {
            closedPlaying = new DrawerClosedPlaying();
        }
        return closedPlaying;
    }

        public void openCloseButtonPushed()
        {
            player.stop();
            player.open();
         player.changeState(DrawerOpen.getInstance());
        }

        public  void playButtonPushed()
        {
        }

        public  void stopButtonPushed()
        {
            player.stop();
            player.changeState(DrawerClosedNotPlaying.getInstance());
        }
    }




    private static class DrawerClosedNotPlaying implements State
    {
        private static DrawerClosedNotPlaying closedNotPlaying =null;

        static DrawerClosedNotPlaying getInstance()
        {
            if(closedNotPlaying==null) {
                closedNotPlaying = new DrawerClosedNotPlaying();
            }
            return closedNotPlaying;
        }



        public  void openCloseButtonPushed() {
            player.open();
            player.changeState(DrawerOpen.getInstance());
        }

        public  void playButtonPushed()
        {
            player.play();
            player.changeState(DrawerClosedPlaying.getInstance());
        }

        public  void stopButtonPushed()
        {
        }



    }






}
