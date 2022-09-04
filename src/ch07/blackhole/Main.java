package ch07.blackhole;

class Main {
    public static void main(String[] args) {
        System.out.println("Begin");
        Object obj = new Object();
        new Blackhole().enter(obj);
        System.out.println("End");
    }
}
