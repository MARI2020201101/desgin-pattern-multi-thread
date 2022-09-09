package ch10.hanoi;

class Main {
    public static void main(String[] args) throws InterruptedException {
        HanoiThread thread = new HanoiThread();
        thread.start();
        Thread.sleep(5000);
        thread.shutdownRequest();
    }
}
