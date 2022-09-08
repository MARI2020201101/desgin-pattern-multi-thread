package ch10.templatepattern;

class Demo {
    public static void main(String[] args) throws InterruptedException {
        ShutdownCounter thread = new ShutdownCounter();
        thread.start();
        Thread.sleep(2000);
        thread.shutdownRequest();
    }
}
