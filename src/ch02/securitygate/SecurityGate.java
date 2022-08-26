package ch02.securitygate;

class SecurityGate {
    private int counter=0;

    public void enter(){
        this.counter++;
    }
    public void exit(){
        this.counter--;
    }

    public int getCounter() {
        return counter;
    }
}
