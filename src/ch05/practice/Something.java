package ch05.practice;

class MainV2{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Something.method(3000);
        System.out.println("end");

    }
}
class Something {
    static void method(long x) throws InterruptedException{
        if(x!=0){
            Object object = new Object();//notify 혹은 notifyAll 해도 중단되지 않는다.
            synchronized (object){
                System.out.println("object waiting...");
                object.wait(x);
            }
        }
    }
}
