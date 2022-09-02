package ch05.producerconsumer;

class DemoV4 {
    public static void main(String[] args) throws InterruptedException {
        Table table = new Table(3);

        Thread[] threads = {
                new MakerThread("Chef-1", table),
                new MakerThread("Chef-2", table),
                new MakerThread("Chef-3", table),
                new EaterThread("Customer-1", table),
                new EaterThread("Customer-2", table),
                new EaterThread("Customer-3", table),
                new ClearThread("Cleaner-1", table)
        };
        for(int i=0;i< threads.length;i++){
            threads[i].start();
        }

        Thread.sleep(2000);

        for(int i=0;i< threads.length;i++){
            threads[i].interrupt();
        }
    }
}
