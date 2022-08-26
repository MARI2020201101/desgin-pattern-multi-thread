package ch02.securitygate;

class Demo {

    public static void main(String[] args) throws InterruptedException {
        SecurityGate securityGate = new SecurityGate();
        CrackerThread[] list = new CrackerThread[1000];
        for (int i = 0; i < list.length; i++) {
            CrackerThread thread = new CrackerThread(securityGate);
            list[i] = thread;
            list[i].start();
        }
        for (int i = 0; i < list.length; i++) {
            list[i].join();
        }
        int counter = securityGate.getCounter();
        if(counter != 0) {
            System.out.println("counter => "+ counter);
            System.out.println("멀티스레드에 안전하지 않음");
        }
    }
}
class CrackerThread extends Thread{
    SecurityGate gate;
    public CrackerThread(SecurityGate gate){
        this.gate=gate;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            gate.enter();
            gate.exit();
        }
    }
}