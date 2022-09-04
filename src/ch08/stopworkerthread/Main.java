package ch08.stopworkerthread;

class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        ClientThread alice = new ClientThread(channel, "Alice");
        ClientThread bob = new ClientThread(channel, "Bob");
        ClientThread chris = new ClientThread(channel, "Chris");

        alice.start();
        bob.start();
        chris.start();

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){}

        alice.stopThread();
        bob.stopThread();
        chris.stopThread();
        channel.stopAllWorkers();
    }
}
