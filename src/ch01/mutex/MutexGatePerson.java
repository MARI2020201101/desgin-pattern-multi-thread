package ch01.mutex;

public class MutexGatePerson extends Thread{

    private final String name;
    private final String address;
    private final MutexGate gate;

    public MutexGatePerson(String name, String address, MutexGate gate) {
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        while(true){
            gate.pass(name, address);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
