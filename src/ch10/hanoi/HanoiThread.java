package ch10.hanoi;

class HanoiThread extends Thread{

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

    protected void doWork() throws InterruptedException{
        for(int level = 0; !shutdownRequested ; level++){
            System.out.println();
            System.out.println("## level : "+ level + " ##");
            move(level, 'A', 'B', 'C');
            Thread.sleep(1000);
        }
    }

    private void move(int level, char posA, char posB , char posC){
        if(level > 0){
            move(level-1, posA, posC, posB);
            System.out.print(posA + " => " + posB + " , ");
            move(level-1, posC, posB, posA);
        }
    }
    protected void doShutDown() {
        System.out.println("bye..............");
    }
    public final void shutdownRequest(){

        this.shutdownRequested = true;
        interrupt();
    }
}
