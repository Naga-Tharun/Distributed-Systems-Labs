import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket;
import java.net.SocketException;

public class ServerSocketOptionsTest { 
    public static void main(String[] args) {
        int port = 8080;
        
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server socket created on port " + port);

            while (true) {
                // Accept incoming connections
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // You can perform any necessary server-side operations here

                // Set SO_KEEPALIVE option (1 enables, 0 disables) 
                clientSocket.setKeepAlive(true);

                // Set SO_LINGER option (Linger on close with a timeout of 30 seconds) 
                clientSocket.setSoLinger(true, 30);

                // Set SO_SNDBUF option (send buffer size) 
                clientSocket.setSendBufferSize(8192);

                // Set SO_RCVBUF option (receive buffer size) 
                clientSocket.setReceiveBufferSize(8192);

                // Set TCP_NODELAY option (disable Nagle's algorithm, true enables, false disables) 
                clientSocket.setTcpNoDelay(true);

                // Display send and receive buffer sizes
                System.out.println("Send Buffer Size: " + clientSocket.getSendBufferSize());
                System.out.println("Receive Buffer Size: " + clientSocket.getReceiveBufferSize());

                // Close the client socket
                clientSocket.close(); 
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
