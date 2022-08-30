package ch01.mutex;

class MyMutex {
    private long locks = 0;
    private Thread owner = null;
//    private boolean busy = false;

//    public synchronized void lock() {
//        while(busy){
//            try {
//                wait();
//            }catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        busy = true;
//    }
//
//    public synchronized void unlock() {
//        busy = false;
//        notifyAll();
//    }

    public synchronized void lock() {
        Thread me = Thread.currentThread();
        while(locks > 0 && owner!= me){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        owner = me;
        locks++;
    }

    public synchronized void unlock() {
        Thread me = Thread.currentThread();
        if(locks == 0 || owner!= me){
            return;
        }
        locks--;
        if(locks == 0){
            owner = null;
            notifyAll();
        }
    }
}
