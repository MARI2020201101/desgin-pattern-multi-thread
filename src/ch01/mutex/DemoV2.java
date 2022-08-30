package ch01.mutex;

class DemoV2 {
    public static void main(String[] args) {
        MutexGate gate = new MutexGate();
        MutexGatePerson Alice = new MutexGatePerson("Alice", "Aaaaa", gate);
        MutexGatePerson Bob = new MutexGatePerson("Bob", "Bbbb", gate);
        MutexGatePerson Mina = new MutexGatePerson("Mina", "Mmmm", gate);
        Alice.start();
        Bob.start();
        Mina.start();
    }
}
