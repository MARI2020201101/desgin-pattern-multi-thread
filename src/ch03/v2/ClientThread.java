package ch03.v2;

import java.util.Random;

class ClientThread extends Thread{
    private final RequestQueue queue;
    private final long seed;

    ClientThread(RequestQueue queue ,String name, long seed) {
        super(name);
        this.queue = queue;
        this.seed = seed;
    }

    @Override
    public void run() {
        while(true){
            int i = new Random(seed).nextInt();
            Request request = new Request("request");
            try {
                Thread.sleep(i);
                queue.putRequest(request);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
