/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que. 2 Write the simple TCP Program for client and server.  (this is for client)
*/

import java.io.*;
import java.net.*;

public class simptcpclient1 {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Replace with the server IP address
        int serverPort = 1234; // Replace with the server port

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            OutputStream outStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outStream, true);

            // Send a message to the server
            writer.println("Hello, Server!");

            // Receive the server's response
            InputStream inStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            String response = reader.readLine();
            System.out.println("Server response: " + response);

            // Close the connections
            reader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
