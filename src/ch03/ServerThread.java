package ch03;

import java.util.Random;

public class ServerThread extends Thread{
    private final RequestQueue queue;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            int i = new Random().nextInt(100);
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {}
            queue.getRequest();
        }
    }
}
