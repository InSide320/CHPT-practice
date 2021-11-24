import com.Phone;

import java.awt.*;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        serverOperations();
    }

    public static void serverOperations() {
        try (ServerSocket serverSocket = new ServerSocket(7500)) {
            System.out.println("Server started!");
            while (true) {
                Phone phone = new Phone(serverSocket);
                new Thread(() -> {
                    String request = phone.readLine();
                    String requestcolor = phone.readLine();
                    String urlicon = phone.readLine();
                    System.out.println("Request login: " + request
                            + "\nRequest color:" + requestcolor
                            + "\nAvatar: " + urlicon);
                    String response = "Login: " + request;
                    String responsecolor = "Color: " + requestcolor;
                    String responseurlicon = "Icon: " + urlicon;
                    phone.writeLine(response);
                    phone.writeLine(responsecolor);
                    System.out.println(response + "\n" + responsecolor + "\n" + responseurlicon);

                    try {
                        phone.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    GUIForm form = new GUIForm(response, requestcolor, urlicon);

                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
