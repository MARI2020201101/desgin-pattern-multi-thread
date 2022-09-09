package ch10.advancedgui;

class Service extends GracefulShutDown{
    @Override
    protected void doWork() throws InterruptedException {
        Service.service();
    }

    @Override
    protected void doShutDown() {
        System.out.println("**************");
        System.out.println("Bye.....");
    }

    public static void service() throws InterruptedException{
        System.out.print("start");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            Thread.sleep(100);
        }
        System.out.println("done");

    }

    public void cancel(){
        System.out.println("# ShutDown Requested #");
        shutdownRequest();
    }
}
