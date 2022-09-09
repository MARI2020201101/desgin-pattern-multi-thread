package ch12.activeobject;

interface ActiveObject {
    Result makeString(int count, char c) throws InterruptedException;
    void displayString(String str) throws InterruptedException;
}
