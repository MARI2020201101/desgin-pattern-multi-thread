package ch03;

import java.util.LinkedList;
import java.util.Queue;

class RequestQueue {

    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest() {
        while(queue.size() <= 0){
            try {
                System.out.println(Thread.currentThread().getName() + " : Wait Start");
                wait();
                System.out.println(Thread.currentThread().getName() + " : Wait End");
            } catch (InterruptedException e) {}
        }
        return queue.poll();
    }
    public synchronized void putRequest(Request request){
        queue.add(request);
        System.out.println(Thread.currentThread().getName() + " : Notify All Start");
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " : Notify All End");
    }

}
