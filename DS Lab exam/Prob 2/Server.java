import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int portNumber = 12345;
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber); 
            System.out.println("Server listening on port " + portNumber);

            System.out.println("\nName: Naga Tharun Makkena");
            System.out.println("Roll No: SE20UCSE105\n");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                ClientHandler clientHandler = new ClientHandler(clientSocket); 
                Thread clientThread = new Thread(clientHandler); 
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    } 
}

class ClientHandler implements Runnable { 
    private Socket clientSocket;
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + ": " + inputLine);
                out.println(inputLine); 
            }

            in.close();
            out.close(); 
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}