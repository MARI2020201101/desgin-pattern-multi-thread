package ch10.advancedguianswer;

public class ServiceThread extends GracefulShutDown{
    @Override
    protected void doShutDown() {
        System.out.println(Thread.currentThread().getName() +  " : Bye...........");
    }

    @Override
    protected void doWork() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            Thread.sleep(100);
        }
    }
}
