package ch02.deadlock.solve;

class Pair {
    final Tool leftTool;
    final Tool rightTool;

    Pair(Tool leftTool, Tool rightTool){
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    @Override
    public String toString() {
        return leftTool + " , "+ rightTool;
    }
}
