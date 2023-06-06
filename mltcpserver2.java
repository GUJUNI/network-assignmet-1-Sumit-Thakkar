import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class mltcpserver2 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            
            while (true) {
                SocketChannel clientChannel = serverSocketChannel.accept();
                Thread clientThread = new ClientHandler(clientChannel);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static class ClientHandler extends Thread {
        private SocketChannel clientChannel;
        
        public ClientHandler(SocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }
        
        public void run() {
            try {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                int bytesRead;
                
                while ((bytesRead = clientChannel.read(buffer)) != -1) {
                    String clientMessage = new String(buffer.array(), 0, bytesRead, StandardCharsets.UTF_8);
                    System.out.println("Received message from client: " + clientMessage);
                    
                    if (clientMessage.equals("exit")) {
                        break;
                    }
                    
                    ByteBuffer responseBuffer = ByteBuffer.wrap(("Server received: " + clientMessage).getBytes(StandardCharsets.UTF_8));
                    clientChannel.write(responseBuffer);
                    buffer.clear();
                }
                
                clientChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
