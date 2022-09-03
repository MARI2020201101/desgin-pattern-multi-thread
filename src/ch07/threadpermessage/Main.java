package ch07.threadpermessage;

class Main {
    public static void main(String[] args) {
        Host host = new Host();
        System.out.println("Main Start");
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');

        System.out.println("Main End");

    }
}
