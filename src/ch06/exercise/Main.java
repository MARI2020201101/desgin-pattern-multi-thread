package ch06.exercise;

class Main {
    public static void main(String[] args) {
        Data data = new Data(10);
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data, "ABCDFJGJFKGJFDOIEGDSKLSG").start();
        new WriteThread(data, "abcvdfwirsdnsdlkjslkngfdg").start();
    }
}
