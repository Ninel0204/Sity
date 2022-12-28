import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Player {
    public static void main(String... args) {
        try (Socket clientSocket = new Socket(Play.HOST, Play.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);


            System.out.println(in.readLine());

            out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

