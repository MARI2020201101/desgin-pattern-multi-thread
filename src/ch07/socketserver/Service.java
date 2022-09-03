package ch07.socketserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Service {
    static void service(Socket clientSocket) throws IOException {
        System.out.println(Thread.currentThread().getName() + " Service.service [" + clientSocket + "] Begin");
        try {

                DataOutputStream out = new DataOutputStream(
                        clientSocket.getOutputStream()
                );
                out.writeBytes("HTTP/1.0 200 OK \r\n");
                out.writeBytes("Content-type: text/html \r\n");
                out.writeBytes("\r\n");
                out.writeBytes(clientSocket.toString());
                out.writeBytes("\r\n");
                out.writeBytes("Count Down Start \r\n");
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " CountDown : " + i);
                    out.writeBytes(" "+ i+" ");
                    out.flush();
                    Thread.sleep(1000);
                }

        }catch (Exception e){}
        finally {
            clientSocket.close();
        }
        System.out.println(Thread.currentThread().getName() + " Service.service [" + clientSocket + "] End");

    }
}
