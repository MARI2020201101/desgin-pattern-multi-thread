package ch09.networkfuture;

class AsyncContent implements Content{
    private SyncContent syncContent;
    private boolean ready;

    @Override
    public synchronized byte[] getBytes() {
        if(! ready){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        return syncContent.getBytes();
    }

    public synchronized void setContent(SyncContent syncContent) {
        if(ready) return;
        this.syncContent = syncContent;
        this.ready = true;
        notifyAll();

    }
}
