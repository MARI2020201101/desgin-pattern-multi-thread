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
        interrupt();//wait, sleep, join 하고 있으면 플래그가 true로 바뀌어도 볼 수 없기 때문에
        //interrupt 를 걸어서 그만 자!!!! 해야한다.
    }
//interrupt를 던지면
    //1. interrupt 상태가되거나
    //2. interruptedException 을 던진다 (wait, sleep, join)
    //1 -> 2 로가고싶은경우 throw new InterruptedException 하고
    //2 -> 1 로가고싶은경우 Thread.currentThread.interrupt() 한다.
    private void doWork() throws InterruptedException{
        System.out.println("Counter : "+ counter);
        counter++;
        Thread.sleep(100);
    }
}
