package ch02.deadlock.solve;

class Tool {
    private final String name;

    Tool(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
