/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que. 4 Write the Multithreaded TCP Program for client and server.  (this is for server)
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class mltcpserver1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new ClientHandler(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        
        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }
        
        public void run() {
            try {
                BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);
                
                String clientMessage;
                while ((clientMessage = clientReader.readLine()) != null) {
                    System.out.println("Received message from client: " + clientMessage);
                    clientWriter.println("Server received: " + clientMessage);
                    if (clientMessage.equals("exit")) {
                        break;
                    }
                }
                
                clientReader.close();
                clientWriter.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
