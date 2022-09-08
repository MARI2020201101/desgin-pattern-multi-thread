package ch10.twophasetermination;

class ShutdownHook {
    public static void main(String[] args) throws InterruptedException {

        Runtime.getRuntime().addShutdownHook(
               new Thread(()-> {
                   System.out.println("**************");
                   System.out.println("Shutdown start....");
                   System.out.println("**************");
               })
        );
        Thread.sleep(1000);

        System.out.println("main start");
        System.exit(0);
        System.out.println("main end");
    }
}
