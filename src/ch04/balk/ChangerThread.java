package ch04.balk;

import java.io.IOException;
import java.util.Random;

class ChangerThread extends Thread{
    private Data data;
    private Random random = new Random();
    public ChangerThread(String name, Data data){
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try{
            for(int i = 0; ; i++){
                data.change("No. " +i);
                Thread.sleep(random.nextInt(3000));
                data.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
