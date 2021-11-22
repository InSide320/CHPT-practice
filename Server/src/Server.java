import com.Phone;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        serverOperations();
    }

    public static void serverOperations() {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server started!");
            while (true) {
                Phone phone = new Phone(serverSocket);
                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println("Request: " + request);
                    String response = "HELLO FROM SERVER: " + request.length();
//                    try {
//                        Thread.sleep(4000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    phone.writeLine(response);
                    System.out.println("Response" + response);
                    try {
                        phone.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
