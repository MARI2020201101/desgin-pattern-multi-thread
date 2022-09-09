package ch10.advancedgui;

class GracefulShutDown extends Thread{

    private volatile boolean shutdownRequested = false;
    @Override
    public void run() {
        try{
            while(! shutdownRequested){
                doWork();
            }
        }catch(InterruptedException e){}
        finally{
            doShutDown();
        }
    }

    protected void doShutDown() {

    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    public final void shutdownRequest(){
        this.shutdownRequested = true;
        interrupt();
    }
    protected void doWork() throws InterruptedException{

    }
}
