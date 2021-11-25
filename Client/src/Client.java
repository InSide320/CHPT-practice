import com.Phone;

import java.awt.*;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ArrayList<String> saveLogin = new ArrayList<>();
        while (true) {
            try (Phone phone = new Phone("127.0.0.1", 7499)) {
                System.out.println("Connected to server!");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Input login: ");
                while (!scanner.hasNextLine()) {
                    System.out.print("Error: Input login: ");
                    scanner.nextLine();
                }
                String request = scanner.next();
                System.out.println("Request: " + request);
                saveLogin.add("");
                int count = 0;
                int countdefault = 0;
                for(int i =0;i< saveLogin.size();i++){
                    if(request.equals(saveLogin.get(i))){
                        countdefault++;
                        if(countdefault ==1){
                            System.out.println("Enter default login: user!");
                            request = "User";
                            phone.writeLine(request);
                        }
                    }
                    else{
                        count++;
                        if(count == 1)
                            phone.writeLine(request);
                    }
                }
                if(request == "User"){
                    System.out.println("default login");
                }
                else
                    saveLogin.add(request);

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
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        switch (color) {
                            case 1:
                                System.out.println("Entry color!");
                                phone.writeLine("Blue");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break exit;
                            case 2:
                                System.out.println("Entry color!");
                                phone.writeLine("Red");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break exit;
                            case 3:
                                System.out.println("Entry color!");
                                phone.writeLine("Black");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break exit;
                            default:
                                System.out.println("Error your input color!");
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                    }
                }
                chooseLogo(phone, scanner);


//                String response = phone.readLine();
//                String responsecolor = phone.readLine();
//                System.out.println(response + "\n" + responsecolor);


            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public static void chooseLogo(Phone phone, Scanner scanner) {
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
                int logo = scanner.nextInt();
                switch (logo) {
                    case 1:
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        phone.writeLine("resource/afro_person_woman.png");
                        break exitSelectedIcon;
                    case 2:
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        phone.writeLine("resource/male_man_person_user.png");

                        break exitSelectedIcon;
                    case 3:
                        System.out.println("Your selected default icon!");
                        phone.writeLine("resource/default.png");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break exitSelectedIcon;
                    default:
                        System.out.println("Non-exist! Repeat!");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.flush();
                        break;
                }
            }
        }
    }

}
