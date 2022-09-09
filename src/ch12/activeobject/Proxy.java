package ch12.activeobject;

class Proxy implements ActiveObject{

    private final Servant servant;
    private final SchedulerThread scheduler;

    public Proxy(Servant servant, SchedulerThread scheduler) {
        this.servant = servant;
        this.scheduler = scheduler;
    }

    @Override
    public Result makeString(int count, char c) {
        FutureResult future = new FutureResult();
        scheduler.invoke(new MakeStringRequest(servant, count, c, future));
        return future;
    }

    @Override
    public void displayString(String str){
        scheduler.invoke(new DisplayRequest(servant, str));
    }
}
