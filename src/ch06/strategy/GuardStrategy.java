package ch06.strategy;

interface GuardStrategy {
    void beforeReadWait();
    boolean readGuard();
    void afterReadWait();
    void beforeDoRead();
    void afterDoRead();

    void beforeWriteWait();
    boolean writeGuard();
    void afterWriteWait();
    void beforeDoWrite();
    void afterDoWrite();
}
class DefaultGuardStrategy implements GuardStrategy{
    private int readingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private boolean preferWriter = true;
    @Override
    public void beforeReadWait() {}
    @Override
    public boolean readGuard() {
        return writingWriters > 0 || (waitingWriters > 0 && preferWriter);
    }
    @Override
    public void afterReadWait() {}

    @Override
    public void beforeDoRead() {
        readingReaders++;
    }

    @Override
    public void afterDoRead() {
        readingReaders--;
        preferWriter = true;
    }

    @Override
    public void beforeWriteWait() {
        waitingWriters++;
    }

    @Override
    public boolean writeGuard() {
        return readingReaders > 0 || writingWriters > 0;
    }

    @Override
    public void afterWriteWait() {
        waitingWriters--;
    }

    @Override
    public void beforeDoWrite() {
        writingWriters++;
    }

    @Override
    public void afterDoWrite() {
        writingWriters--;
        preferWriter = false;
    }
}