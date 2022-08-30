package ch03;

import java.util.Random;

class ClientThread extends Thread{
    private final RequestQueue queue;

    ClientThread(RequestQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while(true){
            int i = new Random().nextInt(1000);
            Request request = new Request("request");
            try {
                Thread.sleep(i);
            } catch (InterruptedException e) {}
            queue.putRequest(request);
        }
    }
}
