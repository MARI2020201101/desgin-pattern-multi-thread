package ch01;

class PrintThreadTest {
    public static void main(String[] args) {
        new PrintThread("*").start();
        new PrintThread("/").start();
    }
}
class PrintThread extends Thread{
    private String message ;
    public PrintThread(String message){
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(message);
        }
    }
}
