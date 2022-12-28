import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        try (ServerSocket serverSocket = new ServerSocket(Play.PORT)) {
            System.out.println("Сервер запущен");
            System.out.println("???");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("Подключен клиент " + clientSocket.getPort());
                    String out1 = scanner.nextLine();
                    out.println(out1);
                    String in1 = in.readLine();
                    System.out.println(in1);
                    int var1 = out1.toLowerCase().charAt(out1.length() - 1);
                    if ((var1) == (in1.toLowerCase().charAt(0))) {
                        out.println("ОК");
                        System.out.println("ОК");
                    } else if ((var1) == 'Ь' || ((var1) == 'Ы')
                            || ((var1) == 'И' || (var1) == 'Й')) {
                        if ((out1.toLowerCase().charAt(out1.length() - 2)) == (in1.toLowerCase().charAt(0))) {
                            out.println("ОК");
                            System.out.println("ОК");
                        } else {
                            out.println("NOT ОК");
                            System.out.println(" NOT ОК");
                        }
                    } else {
                        out.println("NOT ОК");
                        System.out.println(" NOT ОК");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}




