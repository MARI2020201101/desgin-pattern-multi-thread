package ch06.strategy;

class Data {
    private final ReadWriteLock lock;
    private final ReadWriteStrategy readWriteStrategy;

    Data(){
        this.lock = new ReadWriteLock(new DefaultGuardStrategy());
        this.readWriteStrategy = new DefaultReadWriteStrategy();
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        char[] result = (char[]) readWriteStrategy.doRead();
        lock.readUnlock();

        return result;
    }
    public void write(char c) throws InterruptedException {
        lock.writeLock();
        readWriteStrategy.doWrite(c);
        lock.writeUnlock();
    }
}
