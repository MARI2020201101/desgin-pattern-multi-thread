package ch12.activeobject;

class SchedulerThread extends Thread{

    private final ActivationQueue queue;
    SchedulerThread(ActivationQueue queue){
        this.queue = queue;
    }

    public void invoke(MethodRequest request) {
        queue.putRequest(request);
    }
    @Override
    public void run() {
        while(true){
            MethodRequest request = queue.takeRequest();
            request.execute();
        }
    }
}
