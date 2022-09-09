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
        }
        return threadLocal.get();
    }
}
