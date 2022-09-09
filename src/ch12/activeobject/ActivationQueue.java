package ch12.activeobject;

class ActivationQueue {

    private final MethodRequest[] queue;
    private int tail;
    private int head;
    private int count;
    private final int MAX_REQUEST=100;

    public ActivationQueue(){
        this.tail = 0;
        this.head = 0;
        this.count = 0;
        queue = new MethodRequest[MAX_REQUEST];
    }
    public synchronized void putRequest(MethodRequest request){
//        System.out.println(Thread.currentThread().getName() + " puts "+ request);
        while(count >= MAX_REQUEST){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        queue[tail] = request;
        tail = (tail + 1) % (MAX_REQUEST);
        count++;
        notifyAll();
    }
    public synchronized MethodRequest takeRequest(){
        while(count <= 0){
            System.out.println("** No request! **");
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        MethodRequest request = queue[head];
        head = (head + 1) % MAX_REQUEST;
        count--;
//        System.out.println(Thread.currentThread().getName() + " takes "+ request);
        notifyAll();
        return request;
    }
}
