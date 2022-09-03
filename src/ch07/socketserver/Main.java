package ch07.socketserver;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        new MiniServer(8888).execute();
    }
}
