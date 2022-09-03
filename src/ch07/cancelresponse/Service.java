package ch07.cancelresponse;

class Service {
    private static Thread worker = null;
    static synchronized void service(){
        if(worker != null && worker.isAlive()){
            worker.interrupt();
            try {
                worker.join();
            } catch (InterruptedException ignored) {
            }
            worker = null;
        }
        System.out.print("service");
        worker = new Thread(()->doService(50));
        worker.start();
    }

    private static void doService(int count) {
        try {
            for (int i = 0; i < count; i++) {
                System.out.print(".");
                Thread.sleep(100);
             }
            System.out.print("done.");
        } catch (InterruptedException e) {
            System.out.print("canceled.");
        }
    }
}
