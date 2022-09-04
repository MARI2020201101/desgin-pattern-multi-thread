package ch08.workerthread;

import java.util.Random;

class Request {
    private final String name;
    private final int number;
    private final Random random = new Random();

    Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "[ Request No. "+ number + " : " + name + " ]";
    }
}
