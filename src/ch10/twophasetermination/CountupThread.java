package ch10.twophasetermination;

class CountupThread extends Thread{
    private volatile boolean shutdownRequested = false;
    private int counter;
    @Override
    public void run() {
        try{
            while(! shutdownRequested){
                doWork();
            }
        }catch (InterruptedException e){

            System.out.println("current counter => "+ counter);
            System.out.println("Shutdown.....");
        }

    }

    public void shutDownRequest(){
        this.shutdownRequested = true;
        interrupt();
    }

    private void doWork() throws InterruptedException{
        counter++;
        Thread.sleep(100);
    }
}
