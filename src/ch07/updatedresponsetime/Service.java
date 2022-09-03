package ch07.updatedresponsetime;

class Service {
    static void service(){
        System.out.print("Service Start");
        for(int i = 0 ; i <50 ; i+=10){
            new Thread(()->doService(10)).start();
        }
        System.out.println("Done");
    }

    private static void doService(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}
