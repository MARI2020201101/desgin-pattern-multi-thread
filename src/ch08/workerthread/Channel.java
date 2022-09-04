package ch08.workerthread;

class Channel {
    private static final int MAX_REQUEST = 100;
    private final WorkerThread[] workerThreads;
    private final Request[] requests ;
    private int count;
    private int head;
    private int tail;

    Channel(int poolSize) {
        this.workerThreads = new WorkerThread[poolSize];
        this.requests = new Request[MAX_REQUEST];
        this.count = 0;
        this.head = 0;
        this.tail = 0;

        for (int i = 0; i < poolSize; i++) {
            workerThreads[i] = new WorkerThread(this, "Worker - "+ i);
        }
    }

    public void startWorkers(){
        for (int i = 0; i < workerThreads.length; i++) {
            workerThreads[i].start();
        }
    }
    public synchronized void putRequest(Request request){
        while(count > MAX_REQUEST){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        requests[tail] = request;
        tail = (tail+1) % MAX_REQUEST;
        count++;
        notifyAll();
    }
    public synchronized Request takeRequest(){
        while(count <= 0){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        Request request = requests[head];
        head = (head+1) % MAX_REQUEST;
        count--;
        notifyAll();
        return request;
    }
}
