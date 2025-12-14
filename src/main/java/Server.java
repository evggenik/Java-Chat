package main.java;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int serverPort = ConsoleHelper.readInt();
        try(ServerSocket serverSocket = new ServerSocket(serverPort)) {
            System.out.println("Сервер запущен.");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Handler(clientSocket).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //logic to handle connection (read/write)
        }
    }

}
