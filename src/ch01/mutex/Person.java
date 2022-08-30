package ch01.mutex;

public class Person extends Thread{

    private final String name;
    private final String address;
    private final Gate gate;

    public Person(String name, String address, Gate gate) {
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
