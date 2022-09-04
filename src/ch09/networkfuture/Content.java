package ch09.networkfuture;

import java.io.DataInputStream;
import java.net.URL;

interface Content {
    byte[] getBytes();
}
class SyncContent implements Content{
    private byte[] contentBytes;
    private void createContent(String urlStr){
        try {
            URL url = new URL(urlStr);
            DataInputStream in = new DataInputStream(url.openStream());
            byte[] buffer = new byte[10];
            int index = 0;
            while(in.available() > 0){
                int c = in.readUnsignedByte();
                if(buffer.length <= index){
                    byte[] newBuff = new byte[buffer.length * 2];
                    System.arraycopy(buffer,0,newBuff,0, index);
                    buffer = newBuff;
                    Thread.sleep(1000);
                }
                buffer[index++] =(byte)c;
            }
            in.close();
            contentBytes = new byte[index];
            System.arraycopy(buffer,0,contentBytes,0, index);
        } catch (Exception e) {}
    }
    SyncContent(String urlStr){
        createContent(urlStr);
    }
    @Override
    public byte[] getBytes() {
        return contentBytes;
    }
}
