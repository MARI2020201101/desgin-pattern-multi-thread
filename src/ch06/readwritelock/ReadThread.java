package ch06.readwritelock;

class ReadThread extends Thread{
    private final Data data;

    ReadThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try{
            while(true){
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
