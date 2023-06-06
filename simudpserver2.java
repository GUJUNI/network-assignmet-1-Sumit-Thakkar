/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que. 1 Write the Simple UDP Program for client and server.  (this is for server)
*/

import java.io.*;
import java.net.*;

public class simpudpserver2 {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(1234);
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received another message from client: " + message);
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
