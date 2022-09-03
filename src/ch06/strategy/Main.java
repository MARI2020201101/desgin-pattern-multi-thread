package ch06.strategy;

class Main {
    public static void main(String[] args) {
        Data data = new Data();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data, "abcdefghijklmnop").start();
        new WriteThread(data, "ABCDEFGHIJKLMNOP").start();
    }
}
