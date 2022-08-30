package ch03;

class Demo {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        new ClientThread(queue).start();
        new ServerThread(queue).start();
    }
}
