package ch11.threadlocal;

import java.io.IOException;

class ClientThread extends Thread{
    private char name;
    private final Log log;
    ClientThread(String name){
        super(name);
        this.name = name.charAt(0);
        this.log = new Log();
    }
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                log.println(name + i + "");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        try {
            log.close();
        } catch (IOException e) {
        }

    }
}
