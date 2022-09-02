package ch04.balk;

class Demo {
    public static void main(String[] args) {
        Data data= new Data("src/ch04/balk/balk-data.txt", "");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
