package ch10.templatepattern;

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

    public final void shutdownRequest(){
        this.shutdownRequested = true;
        interrupt();
    }
    protected void doWork() throws InterruptedException{

    }
}
