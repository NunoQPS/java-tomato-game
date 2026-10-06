package com.perisic.tomato.peripherals;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

import com.perisic.tomato.engine.GameEngine;

public class GameGUI extends JFrame implements ActionListener {

    private static final long serialVersionUID = -107785653906635L;
    private JLabel questArea = null;
    private GameEngine myGame = null;
    private URL currentGame = null;
    private JTextArea infoArea = null;

    public void addLoginListener(ActionListener listener) {
        // Implement this if needed in the future
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int solution = Integer.parseInt(e.getActionCommand());
        boolean correct = myGame.checkSolution(currentGame, solution);
        int score = myGame.getScore();
        if (correct) {
            System.out.println("YEAH!");
            currentGame = myGame.nextGame();
            ImageIcon ii = new ImageIcon(currentGame);
            questArea.setIcon(ii);
            infoArea.setText("Good!  Score: " + score);
        } else {
            System.out.println("Not Correct");
            infoArea.setText("Oops. Try again!  Score: " + score);
        }
    }

    private void initGame(String player) {
        setSize(690, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("What is the missing value?");
        
        // Center the frame on the screen
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        
        // Set the background color to black
        panel.setBackground(Color.BLACK);

        myGame = new GameEngine(player);
        currentGame = myGame.nextGame();

        infoArea = new JTextArea(1, 40);
        infoArea.setEditable(false);
        infoArea.setText("What is the tomato value?   Score: 0");
        
        // Set the text color to purple
        infoArea.setForeground(new Color(128, 0, 128));

        JScrollPane infoPane = new JScrollPane(infoArea);
        panel.add(infoPane);

        ImageIcon ii = new ImageIcon(currentGame);
        questArea = new JLabel(ii);

        JScrollPane questPane = new JScrollPane(questArea);
        panel.add(questPane);

        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            
            // Set button background color to purple
            btn.setBackground(new Color(128, 0, 128));
            
            // Set button text color to black
            btn.setForeground(Color.BLACK);
            
            panel.add(btn);
            btn.addActionListener(this);
        }

        // Set the panel layout to null for manual positioning
        panel.setLayout(null);
        
        // Position the components manually
        infoPane.setBounds(10, 10, 670, 40);
        questPane.setBounds(10, 60, 670, 350);
        
        for (int i = 0; i < 10; i++) {
            JButton btn = (JButton) panel.getComponent(i + 2); // Skip the first two components (infoPane and questPane)
            btn.setBounds(10 + i * 65, 420, 60, 40);
        }

        getContentPane().add(panel);
    }

    public GameGUI() {
        super();
        initGame(null);
    }

    public GameGUI(String player) {
        super();
        initGame(player);
    }
}
