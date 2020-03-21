package WorkingWithDB;

import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Home {
    public static void main(String args[]) {

        JFrame frame = new JFrame("Database Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,350);
        frame.setResizable(false);
        JPanel topPanel = new JPanel();
        JLabel label = new JLabel("Home page");
        topPanel.add(BorderLayout.CENTER, label);
        JPanel centerPanel = new JPanel();
        JButton insert= new JButton("Insert");
        JButton update = new JButton("update");
        JButton delete = new JButton("delete");
        JButton databaselink = new JButton("databaselink");
        centerPanel.add(insert);
        centerPanel.add(update);
        centerPanel.add(delete);
        centerPanel.add(databaselink);
        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(centerPanel, BorderLayout.SOUTH);
        databaselink.setVisible(true);
        frame.setVisible(true);

        insert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        databaselink.addActionListener(new ActionListener() {
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

    }
}