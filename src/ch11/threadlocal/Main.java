package ch11.threadlocal;

class Main {
    public static void main(String[] args) {
        new ClientThread("Alice").start();//thread 별로 자기 전용의 writer 를 threadLocal 에서 꺼내 쓴다. 9
        new ClientThread("Bob").start();
        new ClientThread("Chris").start();
    }
}
