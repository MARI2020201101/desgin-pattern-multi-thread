package ch12.activeobject;

class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.create();
        new MakeStringThread("Alice", activeObject).start();
        new MakeStringThread("Bob", activeObject).start();
        new DisplayThread("Chris", activeObject).start();
    }
}
