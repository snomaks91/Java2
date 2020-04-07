package Lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final String ADDRESS = "localhost";
    private final int PORT = 8888;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    public static Scanner sc = new Scanner(System.in);

    public Client() {
        try {
            openConnection();
        } catch (IOException e) {
            System.out.println("Error connection");
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket(ADDRESS, PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(() -> {
            try {
                run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                run2();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            System.out.println("DataInputStream is already closed");
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            System.out.println("DataOutputStream is already closed");
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Socket is already closed");
            e.printStackTrace();
        }
    }


//    private void sendMessage() {
//        if (!inputMessageField.getText().trim().isEmpty()) {
//            try {
//                out.writeUTF(inputMessageField.getText());
//                inputMessageField.setText("");
//                inputMessageField.grabFocus();
//            } catch (IOException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Send message error");
//            }
//        }
//    }

//    private void drawGUI() {
//        setBounds(400, 400, 400, 400);
//        setTitle("Client");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        area = new JTextArea();
//        area.setEditable(false);
//        area.setLineWrap(true);
//        add(new JScrollPane(area), BorderLayout.CENTER);
//
//        JPanel bottomPanel = new JPanel(new BorderLayout());
//        JButton sendMessageButton = new JButton("Send");
//        bottomPanel.add(sendMessageButton, BorderLayout.EAST);
//        inputMessageField = new JTextField();
//        add(bottomPanel, BorderLayout.SOUTH);
//        bottomPanel.add(inputMessageField, BorderLayout.CENTER);
//        sendMessageButton.addActionListener(e -> sendMessage());
//        inputMessageField.addActionListener(e -> sendMessage());
//
//        //при закрытии окна клиента остановить сервер и закрыть ресурсы
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
//                try {
//                    out.writeUTF("/end");
//                    closeConnection();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        setVisible(true);
//    }

    public static void main(String[] args) {
        new Client();
    }

    private void run() throws IOException {
        while (true) {
            String strFromServer = sc.next();
            if (strFromServer.equalsIgnoreCase("/end")) {
                break;
            }
            out.writeUTF(strFromServer);
        }
        closeConnection();
    }

    private void run2() throws IOException {
        while (true) {
                System.out.println(in.readUTF());
        }
    }
}
