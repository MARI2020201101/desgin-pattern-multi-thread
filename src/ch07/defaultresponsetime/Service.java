package ch07.defaultresponsetime;

class Service {
    static void service(){
        System.out.print("Service Start");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        System.out.println("Done");
    }
}
