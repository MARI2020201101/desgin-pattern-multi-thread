package ch07.main;

class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        handleRequest(10, 'A');
        handleRequest(20, 'B');
        handleRequest(30, 'C');
        long end = System.currentTimeMillis();
        System.out.println("Total Time : " + (end - start));
    }

    private static void handleRequest(int count, char c) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
            slowy();
        }
        System.out.println();
    }

    private static void slowy() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
