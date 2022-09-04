package ch09.future;

import java.util.Arrays;
import java.util.Random;

interface Data {
    String getContent();
}
class FutureData implements Data{
    private boolean ready = false;
    private RealData realData = null;
    @Override
    public synchronized String getContent() {
       while(! ready){
           try {
           wait();
           } catch (InterruptedException e) {}
       }
        return realData.getContent();
    }
    public synchronized void setContent(RealData data){
        if(ready) return;
        this.realData = data;
        this.ready = true;
        notifyAll();
    }
}
class RealData implements Data{
    private String content;
    private final int count;
    private final char c;
    private Random random = new Random();
    RealData(int count, char c){
        this.count = count;
        this.c = c;
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(random.nextInt(300));
            } catch (InterruptedException e) {}
        }
        this.content =  Arrays.toString(buffer);
    }
    @Override
    public String getContent() {
        return content;
    }
}