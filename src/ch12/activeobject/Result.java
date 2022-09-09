package ch12.activeobject;

interface Result {
    Object getResultValue();
}

class FutureResult implements Result{

    private Result result;
    private volatile boolean ready = false;

    public synchronized void setResult(Result result){
        this.result = result;
        this.ready = true;
        notifyAll();
    }
    @Override
    public synchronized Object getResultValue() {
        while(! ready){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        return result.getResultValue();
    }
}

class RealResult implements Result{

    private final Object resultValue;
    RealResult(Object resultValue) {
        this.resultValue = resultValue;
    }
    @Override
    public Object getResultValue() {
        return resultValue;
    }
}