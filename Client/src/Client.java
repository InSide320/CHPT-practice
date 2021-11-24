import com.Phone;

import java.awt.*;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        while (true) {
            try (Phone phone = new Phone("127.0.0.1", 7500)) {
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
                int color;
                exit:
                {
                    while (true) {
                        System.out.println("Select color:\n"
                                + "1)Blue color\n"
                                + "2)Red color\n"
                                + "3)Black default color\n");
                        System.out.println("Input number color: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("ERROR: Input number color: ");
                            scanner.next();
                        }
                        color = scanner.nextInt();
                        switch (color) {
                            case 1:
                                System.out.println("Entry color!");
                                phone.writeLine("Blue");
                                break exit;
                            case 2:
                                System.out.println("Entry color!");
                                phone.writeLine("Red");
                                break exit;
                            case 3:
                                System.out.println("Entry color!");
                                phone.writeLine("Black");
                                break exit;
                            default:
                                System.out.println("Error your input color!");
                                break;
                        }
                    }
                }
                color = 0;
                chooseLogo(phone, scanner, color);
                String response = phone.readLine();
                String responsecolor = phone.readLine();
                System.out.println(response + "\n" + responsecolor);


            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public static void chooseLogo(Phone phone, Scanner scanner, int logo) {
        exitSelectedIcon:
        {
            while (true) {
                System.out.println("Select icon:\n"
                        + "1) Afro Women\n"
                        + "2) Man person\n"
                        + "3) Default logo");
                System.out.println("Input number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Error: input, repeat: ");
                }
                logo = scanner.nextInt();
                switch (logo) {
                    case 1:
                        phone.writeLine("resource/afro_person_woman.png");
                        break exitSelectedIcon;
                    case 2:
                        phone.writeLine("resource/male_man_person_user.png");
                        break exitSelectedIcon;
                    case 3:
                        System.out.println("Your selected default icon!");
                        phone.writeLine("resource/default.png");
                        break exitSelectedIcon;
                    default:
                        System.out.println("Non-exist! Repeat!");
                        break;
                }
            }
        }
    }

}
