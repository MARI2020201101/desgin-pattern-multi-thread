package ch02.deadlock;

class Demo {
    public static void main(String[] args) {
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bob", fork, spoon).start(); //데드락 발생@@

    }
}
