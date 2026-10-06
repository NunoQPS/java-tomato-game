package com.perisic.tomato.peripherals;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private JTextField usernameField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton loginButton = new JButton("Login");

    public LoginGUI() {
        super("Login");
        initializeComponents();
        setupActions();
    }

    private void initializeComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);

        // Set the default button for the frame
        getRootPane().setDefaultButton(loginButton);
    }

    private void setupActions() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (isValidUser(username, password)) {
                    dispose(); // Close the login window
                    openGameGUI(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });
    }

    private boolean isValidUser(String username, String password) {
        // Hardcoded username and password
        return "Nuno".equals(username) && "Santos".equals(password);
    }

    private void openGameGUI(String username) {
        GameGUI gameGUI = new GameGUI(username);
        gameGUI.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
        });
    }
}
