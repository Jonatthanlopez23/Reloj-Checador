package RCPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RCClass {
    private JLabel displayTimer;
    Timer updateTimer;
    int DELAY = 100;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RCClass();
            }
        });
    }
    private void crearReloj(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Reloj Checador");

        panel.setLayout(null);
        displayTimer = new JLabel("2021-04-30 10:00:00");
        displayTimer.setBounds(65,20,270,25);
        displayTimer.setFont(new Font(displayTimer.getFont().getName(),Font.PLAIN,25));
        panel.add(displayTimer);

        JLabel empleadoLabel = new JLabel("Empleado ID:");
        empleadoLabel.setBounds(65,60,100,25);
        panel.add(empleadoLabel);

        JTextField empleadoText = new JTextField(20);
        empleadoText.setBounds(170,60,165,25);
        panel.add(empleadoText);

        JButton checkIn = new JButton("Entrada");
        checkIn.setBounds(95,100,100,30);
        panel.add(checkIn);
        JButton checkOut = new JButton("Salida");
        checkOut.setBounds(200,100,100,30);
        panel.add(checkOut);
        frame.setVisible(true);
    }
    public RCClass(){
        crearReloj();
        updateTimer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Date currentTime = new Date();
                DateFormat formatTime = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
                String formattedTimeStr = formatTime.format(currentTime);
                displayTimer.setText(formattedTimeStr);
            }
        });
        updateTimer.start();

    }
}
