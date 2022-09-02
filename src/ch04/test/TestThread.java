package ch04.test;

class TestThread extends Thread{
    @Override
    public void run() {
        System.out.print("Begin");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("End");
    }
}
