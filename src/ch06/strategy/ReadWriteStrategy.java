package ch06.strategy;

import java.util.Arrays;

interface ReadWriteStrategy {
    Object doRead();
    void doWrite(Object arg);
}
class DefaultReadWriteStrategy implements ReadWriteStrategy{

    private char[] buffer = new char[10];

    DefaultReadWriteStrategy(){
        Arrays.fill(buffer, '*');
    }
    public void setBufferSize(int size){
        this.buffer = new char[size];
        Arrays.fill(buffer, '*');
    }
    @Override
    public Object doRead() {
        char[] result = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            result[i] = buffer[i];
        }
        slowly(50);
        return result;
    }

    @Override
    public void doWrite(Object arg) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (char)arg;
            slowly(50);
        }
    }
    private void slowly(long millis){
        try {
            Thread.sleep(millis); //write 은 시간이 더 오래걸림을 시뮬레이션 하기위한 메서드
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}