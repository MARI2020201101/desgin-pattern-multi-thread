package ch12.activeobject;

class ActiveObjectFactory {
    static Proxy create(){
        Servant servant = new Servant();
        ActivationQueue queue = new ActivationQueue();
        SchedulerThread scheduler = new SchedulerThread(queue);
        Proxy proxy = new Proxy(servant, scheduler);
        scheduler.start();
        return proxy;
    }
}
