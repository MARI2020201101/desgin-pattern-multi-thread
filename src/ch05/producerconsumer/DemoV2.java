package ch05.producerconsumer;

class DemoV2 {
    public static void main(String[] args) {
        new MakerThread("Chef-1", new Table(3)).start();
        new EaterThread("Customer-1", new Table(3)).start();
    }
}
