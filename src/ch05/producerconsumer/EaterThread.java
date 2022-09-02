package ch05.producerconsumer;

import java.util.Random;

public class EaterThread extends Thread{
    private final Random random;
    private final Table table;
    public EaterThread(String name, Table table){
        super(name);
        this.table = table;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while(true){
                table.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
