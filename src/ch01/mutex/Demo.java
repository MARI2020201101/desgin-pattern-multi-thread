package ch01.mutex;

class Demo {
    public static void main(String[] args) {
        Gate gate = new Gate();
        Person Alice = new Person("Alice", "Aaaaa", gate);
        Person Bob = new Person("Bob", "Bbbb", gate);
        Person Mina = new Person("Mina", "Mmmm", gate);
        Alice.start();
        Bob.start();
        Mina.start();
    }
}
