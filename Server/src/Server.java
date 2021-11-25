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
        try (ServerSocket serverSocket = new ServerSocket(7499)) {
            System.out.println("Server started!");
            while (true) {
                Phone phone = new Phone(serverSocket);
                new Thread(() -> {
                    String request = phone.readLine();
                    System.out.println("Request login: " + request);
                    String response = "Login: " + request;
                    phone.writeLine(response);

                    String requestcolor = phone.readLine();
                    System.out.println("Request color:" + requestcolor);
                    String responsecolor = "Color: " + requestcolor;
                    phone.writeLine(responsecolor);

                    String urlicon = phone.readLine();
                    System.out.println("Avatar: " + urlicon);
                    String responseurlicon = "Icon: " + urlicon;


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
