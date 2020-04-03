package Lesson_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window () {
        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(400,150,500,500);
        //setLayout(new GridLayout(2,1));
        JPanel jp = new JPanel();
        JPanel jp1 = new JPanel();
        jp.setBackground(new Color(123));
        jp1.setBackground(new Color(34222));
        add(jp, BorderLayout.CENTER);
        add(jp1, BorderLayout.SOUTH);
        jp.setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        jp.add(jsp);
        jta.setBackground(new Color(34522224));
        jta.setEditable(false);
        JTextField vvod = new JTextField();
        jp1.setLayout(new FlowLayout());
        vvod.setPreferredSize(new Dimension(400,25));
        JButton ok = new JButton("Send");
        jp1.add(vvod);
        jp1.add(ok, BorderLayout.NORTH);
        vvod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(vvod.getText() + "\n");
                vvod.setText(null);
            }
        });
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(vvod.getText() + "\n");
                vvod.setText(null);
                vvod.requestFocusInWindow();
            }
        });
        setVisible(true);
    }
}
