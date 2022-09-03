package ch06.exercise02;

class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();
    public Data(int size){
        this.buffer = new char[size];
        for(int i =0; i < buffer.length ; i ++){
            buffer[i] = '*';
        }
    }

    public synchronized char[] read() throws InterruptedException {
        return doRead();
    }

    public synchronized void write(char c) throws InterruptedException {
         doWrite(c);
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly(50);
        }

    }

    private char[] doRead() {
        char[] result = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            result[i] = buffer[i];
        }
        slowly(50);
        return result;
    }

    private void slowly(long millis){
        try {
            Thread.sleep(millis); //write 은 시간이 더 오래걸림을 시뮬레이션 하기위한 메서드
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
