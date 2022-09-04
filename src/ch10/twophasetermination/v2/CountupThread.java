package ch10.twophasetermination.v2;

class CountupThread extends Thread{
    private volatile boolean shutdownRequested = false;
    private int counter;
    @Override
    public void run() {
        try{
            while(! shutdownRequested){
                doWork();
            }
        }catch (InterruptedException e){}
        finally {
            doShutDown();
        }

    }

    private void doShutDown() {
        System.out.println("# Shutdown Start.....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter : "+ counter);
        System.out.println("# Shutdown End.....");
    }

    public void shutDownRequest() {
        this.shutdownRequested = true;
        interrupt();
    }

    private void doWork() throws InterruptedException{
        counter++;
        Thread.sleep(100);
    }
}
