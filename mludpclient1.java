/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que. 2 Write the multitherading UDP Program for client and server.  (this is for client)
*/
import java.io.*;
import java.net.*;

public class mludpclient1 {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData = "Hello, server!".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1234);
            clientSocket.send(sendPacket);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
