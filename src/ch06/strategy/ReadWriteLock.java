package ch06.strategy;

final class ReadWriteLock {
   private GuardStrategy guardStrategy;

   ReadWriteLock(GuardStrategy guardStrategy){
       this.guardStrategy = guardStrategy;
   }
    public synchronized void readLock() throws InterruptedException {
        guardStrategy.beforeReadWait();
        try{
            while(guardStrategy.readGuard()){
                wait();
            }
        }finally {
            guardStrategy.afterReadWait();
        }
        guardStrategy.beforeDoRead();
    }

    public synchronized void readUnlock(){
        guardStrategy.afterDoRead();
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        guardStrategy.beforeWriteWait();
        try{
            while(guardStrategy.writeGuard()){
                wait();
            }
        }finally {
            guardStrategy.afterWriteWait();
        }
        guardStrategy.beforeDoWrite();
    }

    public synchronized void writeUnlock(){
        guardStrategy.afterDoWrite();
        notifyAll();
    }
}
