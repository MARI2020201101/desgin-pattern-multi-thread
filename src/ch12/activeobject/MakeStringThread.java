package ch12.activeobject;

class MakeStringThread extends Thread{

    private char c;
    private ActiveObject proxy;
    MakeStringThread(String name, ActiveObject proxy){
        super(name);
        c = name.charAt(0);
        this.proxy = proxy;
    }

    @Override
    public void run() {
        Result result = null;
        try {
            for (int i = 0; i < 100; i++) {
                result = proxy.makeString(i, c);
                Thread.sleep(10);
                String s = (String) result.getResultValue();
                System.out.println(Thread.currentThread().getName() + " get Value!!" + s);
            }
        } catch (InterruptedException e) {}
    }
}


class DisplayThread extends Thread{
    private ActiveObject proxy;
    DisplayThread(String name, ActiveObject proxy){
        super(name);
        this.proxy = proxy;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; ; i++) {
                String name = Thread.currentThread().getName();
                proxy.displayString(name + " " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {}

    }
}