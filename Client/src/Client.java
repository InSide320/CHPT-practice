import com.Phone;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        while (true){
            try (Phone phone = new Phone("127.0.0.1", 8000)) {
                System.out.println("Connected to server!");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Input line: ");
                while (!scanner.hasNextLine()){
                    System.out.print("Input line: ");
                    scanner.nextLine();
                }

                String request = scanner.nextLine();
                System.out.println("Request: " + request);
                phone.writeLine(request);

                String response = phone.readLine();
                System.out.println("Response: " + response);

            } catch (IOException e) {
                e.getStackTrace();
            }
        }

    }
}
