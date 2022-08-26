package ch02.deadlock.solve;

class Demo {
    public static void main(String[] args) {
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new EaterThread("Alice", new Pair(spoon, fork)).start();
        new EaterThread("Bob", new Pair(fork, spoon)).start();
    // 복수의 shared resource를 하나의 resource로 만들어서 해결!
    }
}
