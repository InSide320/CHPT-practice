import com.Phone;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        while (true) {
            try (Phone phone = new Phone("127.0.0.1", 8000)) {
                System.out.println("Connected to server!");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Input login: ");
                while (!scanner.hasNextLine()) {
                    System.out.print("Error: Input login: ");
                    scanner.nextLine();
                }
                String request = scanner.nextLine();
                System.out.println("Request: " + request);
                phone.writeLine(request);

                exit:
                {
                    while (true) {
                        System.out.println("5)Break loop");
                        System.out.println("Input number color: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("ERROR: Input number color: ");
                            scanner.next();
                        }
                        int color = scanner.nextInt();
                        switch (color) {
                            case 1:
                                System.out.println("Entry color!");
                                phone.writeLine("Blue");
                                break;
                            case 5:
                                System.out.println("You are out of color picker");
                                break exit;
                            default:
                                System.out.println("Pls entry!");
                                break;
                        }
                    }
                }
                String response = phone.readLine();
                String responsecolor = phone.readLine();
                System.out.println(response + "\n" + responsecolor);

            } catch (IOException e) {
                e.getStackTrace();
            }
        }

    }
}
