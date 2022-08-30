package ch01.mutex;

class MutexGate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    private final MyMutex mutex = new MyMutex();
    public void pass(String name, String address){
        mutex.lock();
        try{
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        }finally {
            mutex.unlock();
        }
    }

    private void check() {
        String s = toString();
        System.out.println(s);
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("***** Broken State *****");
        }
    }

    @Override
    public String toString() {
        String s = null; //자기가 건 lock에 빠져버리는 문제
        mutex.lock();
        try{
            s = "counter => " + counter + " , name => "+ name + " ,  address => "+ address;
        }finally {
            mutex.unlock();
        }
        return s;
    }
}
