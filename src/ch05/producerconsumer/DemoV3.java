package ch05.producerconsumer;

class DemoV3 {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("Chef-1", table).start();
        new MakerThread("Chef-2", table).start();
        new MakerThread("Chef-3", table).start();
        new EaterThread("Customer-1", table).start();
        new EaterThread("Customer-2", table).start();
        new EaterThread("Customer-3", table).start();
        new ClearThread("Cleaner-1", table).start();
    }
}
