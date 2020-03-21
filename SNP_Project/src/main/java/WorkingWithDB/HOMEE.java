package WorkingWithDB;

import WorkingWithDB.QueryExecution;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;


public class HOMEE extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                HOMEE form = new HOMEE();
                form.setVisible(true);
            }
        });
    }


    public HOMEE() {

        // Create Form Frame

        super("Home");
        JPanel panel =  new JPanel();
        setSize(450, 300);
        setLocation(500, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

//         Input A
        final JTextField numA = new JTextField();
        numA.setBounds(27, 26, 200, 100);
        getContentPane().add(numA);

        // Label +
//        JLabel label = new JLabel("+");
//        label.setBounds(99, 29, 13, 14);
//        getContentPane().add(label);

        // Input B
//        final JTextField numB = new JTextField();
//        numB.setBounds(122, 26, 62, 20);
//        getContentPane().add(numB);

        // Label Result
//        final JLabel lblResult = new JLabel("Result");
//        lblResult.setBounds(27, 68, 85, 14);
//        getContentPane().add(lblResult);


        // Button Sum
        JButton btnSum = new JButton("Execute");
        btnSum.setBounds(294, 25, 65, 23);
        btnSum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String A =  numA.getText();
                try {
                    QueryExecution.execQuery(A);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JButton DatabaseLink = new JButton("Link to the Database");
        DatabaseLink.setBounds(194, 200, 65, 23);
        DatabaseLink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //Set your page url in this string. For eg, I m using URL for Google Search engine
                    String url = "https://www.ncbi.nlm.nih.gov/snp/rs62645950";
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });
        JScrollPane scrollpane = new JScrollPane(panel);
        getContentPane().add(btnSum);
        getContentPane().add(DatabaseLink);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
    }

}