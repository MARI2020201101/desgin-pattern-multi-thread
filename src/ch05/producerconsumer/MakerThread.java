package ch05.producerconsumer;

import java.util.Random;

class MakerThread extends Thread{
    private final Random random;
    private final Table table;
    private static int id = 0;
    public MakerThread(String name, Table table){
        super(name);
        this.random = new Random();
        this.table = table;
    }

    @Override
    public void run() {
        try {
        while(true){
            Thread.sleep(random.nextInt(1000));
            String cake = "[ Cake No. " + getID() + " made by " + Thread.currentThread().getName() + " ]" ;
            table.put(cake);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized int getID(){
        return id++;
    }
}
