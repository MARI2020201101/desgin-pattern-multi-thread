package ch10.templatepattern;

import java.util.concurrent.atomic.AtomicInteger;

class ShutdownCounter extends GracefulShutDown{
    private AtomicInteger counter = new AtomicInteger(0);
    @Override
    protected void doShutDown() {
        System.out.println("************************************");
        System.out.println("Shutdown Start......");
        System.out.println("Final Counter : " + counter.intValue());

    }

    @Override
    protected void doWork() throws InterruptedException {
        counter.addAndGet(1);
        System.out.println("Current Counter : "+ counter.intValue());
        Thread.sleep(100);
    }
}
