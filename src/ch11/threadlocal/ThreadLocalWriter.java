package ch11.threadlocal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class ThreadLocalWriter {

    private PrintWriter writer;

    public ThreadLocalWriter(String fileName){
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {}
    }
    public void println(String s) throws IOException {
        writer.println(s);
    }
    public void close() throws IOException {
        writer.close();
    }
}
