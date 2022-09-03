package ch07.socketserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class MiniServer {
    private final int portNumber;
    public MiniServer(int portNumber){
        this.portNumber = portNumber;
    }
    public void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Listening on "+ portNumber + " port");
        try{
            while(true){
                System.out.println("Accepting....");
                final Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to "+ clientSocket);
                new Thread(()-> {
                    try {
                        Service.service(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }catch (Exception e){}
        finally {
            serverSocket.close();
        }
    }
}
