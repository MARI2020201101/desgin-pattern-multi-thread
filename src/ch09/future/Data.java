package ch09.future;

import java.util.Arrays;
import java.util.Random;

interface Data {
    String getContent() throws Exception;
}
class FutureData implements Data{
    private boolean ready = false;
    private RealData realData = null;
    private Exception exception = null;
    @Override
    public synchronized String getContent() throws Exception{
       while(! ready){
           try {
           wait();
           } catch (InterruptedException e) {}
       }
        if(exception!= null) throw exception;
        return realData.getContent();
    }
    public synchronized void setContent(RealData data){
        if(ready) return;
        this.realData = data;
        this.ready = true;
        notifyAll();
    }
    public synchronized void setException(Throwable exception){
        if(ready) return;
        this.exception = new IllegalArgumentException(exception);
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