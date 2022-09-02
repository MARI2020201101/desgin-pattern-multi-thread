package ch04.balk;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

class Data {
    private final String fileName;
    private String content;
    private boolean changed;

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent){
        content = newContent;
        changed = true;
    }
    public void save() throws IOException, InterruptedException {
        if(! changed) {
            System.out.println("** Already Saved!! **");
            return;}
        doSave();
        Thread.sleep(100); //synchronized 가 아닐경우 이 사이에 끼어들어서 두번 저장해버린다
        //아직 changed 플래그를 바꾸지 않았으므로..
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = "+ content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }
}
