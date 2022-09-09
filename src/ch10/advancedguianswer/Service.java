package ch10.advancedguianswer;

class Service{
   static GracefulShutDown thread;

    public synchronized static void service(){
        System.out.print("start");
        if(thread != null && thread.isAlive()) return;
        else{
            thread = new ServiceThread();
            thread.start();
        }
    }

    public synchronized static void cancel(){
        if(thread!=null){
            thread.doShutDown();
            System.out.println("done");
        }
    }
}
