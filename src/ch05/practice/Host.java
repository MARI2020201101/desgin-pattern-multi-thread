package ch05.practice;

class Main {
    public static void main(String[] args) throws InterruptedException {

            Thread thread = new Thread(() -> {
                try {
                    Host.execute(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Stop execute method!");
                }
            });
            thread.start();
            Thread.sleep(3000);
            thread.interrupt();

    }
}

class Host {

    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            if(Thread.interrupted()) throw new InterruptedException("Stop!!!");
            doHeavyJob();
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
