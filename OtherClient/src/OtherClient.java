import com.*;

import java.io.IOException;
import java.util.Scanner;

public class OtherClient {
    public static void main(String[] args) {
        while (true){
            try (Phone phone = new Phone("127.0.0.1", 8000)) {
                System.out.println("Connected to server!");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Input number!: ");
                while (!scanner.hasNextInt()){
                    System.out.print("Error: Input number: ");
                    scanner.next();
                }

                int request = scanner.nextInt();
                System.out.println("Request: " + request);
                phone.writeLine(String.valueOf(request));

                String response = phone.readLine();
                System.out.println("Response: " + response);

            } catch (IOException e) {
                e.getStackTrace();
            }
        }

    }
}
