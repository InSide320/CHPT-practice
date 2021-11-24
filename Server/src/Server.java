import com.Phone;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

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
                    String requestcolor = phone.readLine();
                    System.out.println("Request login: " + request
                            + "\nRequest color:" + requestcolor );
                    String response = "Login: " + request;
                    String responsecolor = "Color: " + requestcolor;
                    phone.writeLine(response);
                    phone.writeLine(responsecolor);
                    System.out.println(response + "\n" + responsecolor);
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
