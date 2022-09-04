package ch09.future;

class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("main START");
        Host host = new Host();
        Data data1 = host.request(10, 'A');
        Data data2 = host.request(20, 'B');
        Data data3 = host.request(30, 'C');

        System.out.println("main do other job...");
        Thread.sleep(3000);
        System.out.println("main end other job");

        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
        System.out.println("main END");

    }
}
