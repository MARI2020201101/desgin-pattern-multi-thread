package ch07.threadpermessage;

class Host {

    private Helper helper = new Helper();
    public void request(final int count, final char c){
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " received Request from Host ");
            helper.handle(count,c);
        }).start();
    }
}
