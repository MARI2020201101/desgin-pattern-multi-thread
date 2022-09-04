package ch07.blackhole;

class Blackhole {
    static void enter(Object obj){
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj){
            System.out.println("Step 3 (never reached here)");
        }
    }

    private static void magic(final Object obj) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    synchronized (this){
                        this.setName("Locked");
                        this.notifyAll();
                    }
                    while(true){}
                }
            }
        };
        synchronized (thread){
            thread.setName("");
            thread.start();
            while(thread.getName().equals("")){
                try{
                    thread.wait();
                }catch (Exception e){}
            }
        }
    }
}
