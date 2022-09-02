package ch04.balk;

import java.io.IOException;

class SaverThread extends Thread{
    private Data data;
    public SaverThread(String name, Data data){
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try{
            while(true){
                data.save();
                Thread.sleep(1000L);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
