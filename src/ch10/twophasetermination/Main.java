package ch10.twophasetermination;

class Main {
    public static void main(String[] args) throws InterruptedException {
        CountupThread thread = new CountupThread();
        thread.start();
        Thread.sleep(2000);
        thread.shutDownRequest();
    }
}
