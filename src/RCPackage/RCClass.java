package RCPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static javax.swing.JOptionPane.showMessageDialog;

public class RCClass {
    Connection connection=null;
    private JLabel displayTimer;
    JTextField empleadoText;
    Timer updateTimer;
    int DELAY = 100;
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RCClass();
            }
        });
    }
    private void conectardb(){
        try {
            connection =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
        
            // Do something with the Connection
        
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    private void crearReloj(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setTitle("Reloj Checador");

        panel.setLayout(null);
        displayTimer = new JLabel("2021-04-30 10:00:00");
        displayTimer.setBounds(65,20,300,25);
        displayTimer.setFont(new Font(displayTimer.getFont().getName(),Font.PLAIN,25));
        panel.add(displayTimer);

        JLabel empleadoLabel = new JLabel("Empleado ID:");
        empleadoLabel.setBounds(65,60,100,25);
        panel.add(empleadoLabel);

        empleadoText = new JTextField(20);
        empleadoText.setBounds(170,60,165,25);
        panel.add(empleadoText);

        JButton checkIn = new JButton("Entrada");
        checkIn.setBounds(95,100,100,30);
        checkIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                crearRegistro(Integer.parseInt(empleadoText.getText()),"Entrada");   
            }
        });
        panel.add(checkIn);
        JButton checkOut = new JButton("Salida");
        checkOut.setBounds(200,100,100,30);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                crearRegistro(Integer.parseInt(empleadoText.getText()),"Salida");   
            }
        });
        panel.add(checkOut);
        frame.setVisible(true);
    }
    public RCClass(){
        conectardb();
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
    public void crearRegistro(int idEmpleado,String tipoRegistro){
        Date currentTime = new Date();
        DateFormat formatTime = new SimpleDateFormat("hh:mm:ss");
        DateFormat DBformatTime = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
        String toDisplay = formatTime.format(currentTime);
        String toDB = DBformatTime.format(currentTime);
        try {
            connection =   DriverManager.getConnection("jdbc:mysql://localhost:3306/RC?user=root&password=12345678");
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO registros(idempleado,hora,tiporegistro) VALUES("+idEmpleado+",'"+toDB+"','"+tipoRegistro+"')");
            connection.close();
            showMessageDialog(null, toDisplay+" - Registro de "+tipoRegistro+" del empleado "+idEmpleado);
        }  catch (SQLException ex) {
            // handle any errors
            showMessageDialog(null,"SQLException: " + ex.getMessage());
            showMessageDialog(null,"SQLState: " + ex.getSQLState());
            showMessageDialog(null,"VendorError: " + ex.getErrorCode());
        }

    }
}
