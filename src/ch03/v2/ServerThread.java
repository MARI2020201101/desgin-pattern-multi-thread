package ch03.v2;

import java.util.Random;

class ServerThread extends Thread{
    private final RequestQueue queue;
    private final long seed;
    public ServerThread(RequestQueue queue,String name, long seed) {
        super(name);
        this.queue = queue;
        this.seed = seed;
    }

    @Override
    public void run() {
        while(true){
            int i = new Random(seed).nextInt(100);
            try {
                Thread.sleep(i);
                queue.getRequest();
            } catch (InterruptedException e) {

                break;
            }

        }

    }
}
