package ch08.stopworkerthread;

import java.util.Random;

class ClientThread extends Thread{
    private final Channel channel;
    private final Random random = new Random();

    ClientThread(Channel channel, String name) {
        super(name);
        this.channel = channel;
    }

    public void stopThread(){
        interrupt();
    }
    @Override
    public void run() {
        try {
        for(int i = 0;;i++){
            Request request = new Request(getName(), i);
            channel.putRequest(request);
            Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            System.out.println(" # "+ Thread.currentThread().getName() + " Stop Request....");
        }
    }
}
