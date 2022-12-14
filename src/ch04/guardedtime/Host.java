package ch04.guardedtime;

class Host {
    private final long timeout;
    private boolean ready = false;

    public Host(long timeout){
        this.timeout = timeout;
    }
    public synchronized void setExecutable(boolean on){
        this.ready = on;
    }
    public synchronized void execute() throws InterruptedException, TimeoutException{
        long start = System.currentTimeMillis();
        while(! ready){
            long now = System.currentTimeMillis();
            long rest = timeout - (now - start);
            if(rest <= 0){
                throw new TimeoutException("now - start = " + (now - start ) + " ,  \ntimeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }
    private void doExecute(){
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }
}
