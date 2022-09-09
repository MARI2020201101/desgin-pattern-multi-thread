package ch11.threadlocal;

class ClientThread extends Thread{
    private char name;
    private final Log log;
    ClientThread(String name){
        super(name);
        this.name = name.charAt(0);
        this.log = new Log();
//        try {
//            log.println(name);
//        } catch (IOException e) {
//
//        }
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                log.println(name + i + "");
                Thread.sleep(100);
            }
        } catch (Exception e) {}
    }
}
