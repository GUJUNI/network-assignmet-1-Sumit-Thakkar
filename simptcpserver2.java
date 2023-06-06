/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que. 2 Write the simple TCP Program for client and server.  (this is for server)
*/

import java.io.*;
import java.net.*;

public class simptcpserver2 {
    public static void main(String[] args) {
        int serverPort = 1234; // Port to listen on

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server listening on port " + serverPort);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + 
				clientSocket.getInetAddress().getHostAddress());

                // Receive client's message
                InputStream inStream = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
                String message = reader.readLine();
                System.out.println("Received message from client: " + message);

                // Send a response to the client
                OutputStream outStream = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(outStream, true);
                writer.println("Hello again, Client!");

                // Close the connections with the client
                reader.close();
                writer.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
