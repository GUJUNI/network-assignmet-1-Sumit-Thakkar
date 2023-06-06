/*
Name: Thakkar Sumit
Roll no: 35
Course: MCA2
Subject: Advance Networking

Que.4 Write the Multithreaded TCP Program for client and server. (this is for client)
*/
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class mltcpclient2 {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String userInput;
            
            while (true) {
                System.out.println("Enter a message (type 'exit' to quit):");
                userInput = System.console().readLine();
                buffer.clear();
                buffer.put(userInput.getBytes(StandardCharsets.UTF_8));
                buffer.flip();
                
                while (buffer.hasRemaining()) {
                    socketChannel.write(buffer);
                }
                
                buffer.clear();
                int bytesRead = socketChannel.read(buffer);
                String serverResponse = new String(buffer.array(), 0, bytesRead, StandardCharsets.UTF_8);
                System.out.println("Server response: " + serverResponse);
                
                if (userInput.equals("exit") || serverResponse.equals("exit")) {
                    break;
                }
            }
            
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
