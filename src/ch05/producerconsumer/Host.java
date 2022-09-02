package ch05.producerconsumer;

class Main {
    public static void main(String[] args) throws InterruptedException {
        Host.execute(10);
        Thread.sleep(3000);
        Host.dontDoJob();
    }
}
class Host {
    static volatile boolean doJob = true;
    public static void dontDoJob(){
        doJob = false;
    }
    public static void execute(int count){
        for (int i = 0; i < count; i++) {
            if(doJob) doHeavyJob();
        }
        System.out.println("### Execute method End ###");
    }

    private static void doHeavyJob() {
        System.out.println("Do Heavy Job Begin");
        long start = System.currentTimeMillis();
        while(start + 1000 > System.currentTimeMillis()){
            //busy loop...
        }
        System.out.println("Do Heavy Job End");
    }
}
