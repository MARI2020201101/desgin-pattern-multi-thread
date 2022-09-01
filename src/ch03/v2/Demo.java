package ch03.v2;

class Demo {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        Thread alice = new ClientThread(requestQueue, "alice", 314159L);
        Thread bob = new ServerThread(requestQueue, "bob", 265358L);

        alice.start();
        bob.start();

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}

        System.out.println("******* calling interrupt *******");
        alice.interrupt();
        bob.interrupt();
    }
}
