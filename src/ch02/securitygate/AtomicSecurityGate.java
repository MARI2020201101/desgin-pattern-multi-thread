package ch02.securitygate;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicSecurityGate {
    private AtomicInteger counter = new AtomicInteger(0);

    public void enter(){
        this.counter.addAndGet(1);
    }
    public void exit(){
        this.counter.decrementAndGet();
    }

    public int getCounter() {
        return counter.intValue();
    }
}
