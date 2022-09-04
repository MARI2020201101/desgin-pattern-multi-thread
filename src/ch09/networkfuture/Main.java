package ch09.networkfuture;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class Main {
    static String fileName1 = "src/ch09/networkfuture/file-01.txt";
    static String fileName2 = "src/ch09/networkfuture/file-02.txt";
    static String fileName3 = "src/ch09/networkfuture/file-03.txt";

    public static void main(String[] args) throws Exception {

        Content content1 = Retriever.retrieve("http://www.yahoo.com");
        Content content2 = Retriever.retrieve("http://www.google.com");
        Content content3 = Retriever.retrieve("http://www.naver.com");

        while(contentIsNull(content1) || contentIsNull(content2) || contentIsNull(content3)){
            System.out.println("Main Waiting content...");
            Thread.sleep(100);
        }
        saveToFile(fileName1, content1);
        saveToFile(fileName2, content2);
        saveToFile(fileName3, content3);
    }

    private static boolean contentIsNull(Content content){
        return content.getBytes()==null;
    }
    private static void saveToFile(String fileName, Content content) throws Exception {
        byte[] bytes = content.getBytes();
        FileOutputStream outputStream = new FileOutputStream(fileName);
        for (int i = 0; i < bytes.length; i++) {
            outputStream.write(bytes[i]);
        }
        outputStream.close();
    }
}
