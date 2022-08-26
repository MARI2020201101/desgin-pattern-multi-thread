package ch02.securitygate;

class DemoV2 {

    public static void main(String[] args) throws InterruptedException {
        AtomicSecurityGate gate = new AtomicSecurityGate();
        CrackerThreadV2[] list = new CrackerThreadV2[1000];
        for (int i = 0; i < list.length; i++) {
            CrackerThreadV2 thread = new CrackerThreadV2(gate);
            list[i] = thread;
            list[i].start();
        }
        for (int i = 0; i < list.length; i++) {
            list[i].join();
        }
        int counter = gate.getCounter();
        if(counter != 0) {
            System.out.println("counter => "+ counter);
            System.out.println("멀티스레드에 안전하지 않음");
        }
        else{
            System.out.println("멀티스레드에 안전함!");
        }
    }//안전하긴한데 개오래걸림..
}

class CrackerThreadV2 extends Thread{
    AtomicSecurityGate gate;
    public CrackerThreadV2(AtomicSecurityGate gate){
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