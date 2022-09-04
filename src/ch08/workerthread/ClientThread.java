package ch08.workerthread;

import java.util.Random;

class ClientThread extends Thread{
    private final Channel channel;
    private final Random random = new Random();

    ClientThread(Channel channel, String name) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        for(int i = 0;;i++){
            Request request = new Request(getName(), i);
            channel.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
