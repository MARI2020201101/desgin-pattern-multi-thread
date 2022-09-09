package ch11.threadlocal;

import java.io.IOException;

class Log {
    ThreadLocal<ThreadLocalWriter> threadLocal = new ThreadLocal<>();
    public void println(String s) throws IOException {
        getWriter().println(s);

    }
    public void close() throws IOException {
        getWriter().close();
    }

    private ThreadLocalWriter getWriter(){
        if(threadLocal.get() == null){
            ThreadLocalWriter writer = new ThreadLocalWriter(
                    "src/ch11/threadlocal/" +Thread.currentThread().getName() +"log.txt");
            threadLocal.set(writer);
            startWatcher(writer);
        }
        return threadLocal.get();
    }

    private void startWatcher(ThreadLocalWriter writer) {
        final Thread target = Thread.currentThread();
        new Thread(()->{
            System.out.println("wathching start ...");
            try {
                target.join();
            } catch (InterruptedException e) {

            }
            try {
                writer.close();
            } catch (IOException e) {

            }
            System.out.println("watching end...");
        }).start();
    }
}
