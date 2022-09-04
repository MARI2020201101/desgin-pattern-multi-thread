package ch08.workerthread;

import java.util.Random;

class WorkerThread extends Thread{

    private final Channel channel;
    private String name;
    private final Random random = new Random();

    WorkerThread(Channel channel, String name) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true){
            Request request = channel.takeRequest();
            request.execute();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
