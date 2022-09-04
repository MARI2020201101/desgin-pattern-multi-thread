package ch08.stopworkerthread;

import java.util.Random;

class WorkerThread extends Thread{

    private final Channel channel;
    private final Random random = new Random();

    WorkerThread(Channel channel, String name) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
        while(true){
            Request request = channel.takeRequest();
            request.execute();
            Thread.sleep(random.nextInt(1000));
        }
        } catch (InterruptedException e) {
            System.out.println(" # "+ Thread.currentThread().getName() + " Stop Working....");
        }
    }
}
