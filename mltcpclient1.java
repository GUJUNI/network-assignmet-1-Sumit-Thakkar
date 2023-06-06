/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que. 4 Write the Multithreaded TCP Program for client and server.  (this is for client)
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class mltcpclient1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
            
            // Read user input and send it to the server
            System.out.println("Enter a message (type 'exit' to quit):");
            String userInput;
            while ((userInput = userInputReader.readLine()) != null) {
                serverWriter.println(userInput);
                if (userInput.equals("exit")) {
                    break;
                }
            }
            
            // Receive and display server responses
            String serverResponse;
            while ((serverResponse = serverReader.readLine()) != null) {
                System.out.println("Server response: " + serverResponse);
                if (serverResponse.equals("exit")) {
                    break;
                }
            }
            
            // Close the connections
            userInputReader.close();
            serverReader.close();
            serverWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
