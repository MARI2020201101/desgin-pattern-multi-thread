package ch10.twophasetermination.v2;

class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Start");
        CountupThread thread = new CountupThread();
        thread.start();
        Thread.sleep(2000);
        thread.shutDownRequest();
        thread.join();
        System.out.println("Main End");
    }
}
