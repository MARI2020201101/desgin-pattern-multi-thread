package ch09.future;

class MainV2 {
    public static void main(String[] args) throws Exception {
        Host host = new Host();
        Data data1 = host.request(-1, 'A');

        System.out.println("main do other job...");
        Thread.sleep(3000);
        System.out.println("main end other job");

        System.out.println("data1 = " + data1.getContent());
    }
}
