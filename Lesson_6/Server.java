package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server  {
    private static DataOutputStream outPutStream;
    private static DataInputStream dataInputStream;


    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Сервер запущен, ждёт подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            dataInputStream = new DataInputStream(socket.getInputStream());
            outPutStream = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    run();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            while (true) {
                String strFromClient = dataInputStream.readUTF();
                if (strFromClient.equalsIgnoreCase("/end")) {
                    break;
                }
                System.out.println("client: " + " " + strFromClient);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void run() throws IOException {
        while (true) {
            String strFromServer = sc.next();
            outPutStream.writeUTF("echo: " + strFromServer);
        }
    }
}
