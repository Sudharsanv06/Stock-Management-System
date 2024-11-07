package views;

import javax.swing.*;
import java.awt.*;

public class TakeReturnBookFrame extends JFrame {

    public TakeReturnBookFrame() {
        setTitle("Take or Return Stock");
        setSize(500, 400); // Adjusted size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Labels and fields
        JLabel bookIDLabel = new JLabel("Stock ID:");
        JTextField bookIDField = new JTextField(15);

        JLabel userIDLabel = new JLabel("User ID:");
        JTextField userIDField = new JTextField(15);

        JRadioButton takeBook = new JRadioButton("Take Stock");
        JRadioButton returnBook = new JRadioButton("Return Stock");

        ButtonGroup group = new ButtonGroup();
        group.add(takeBook);
        group.add(returnBook);

        // Arrange components
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(bookIDLabel, gbc);

        gbc.gridx = 1;
        add(bookIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(userIDLabel, gbc);

        gbc.gridx = 1;
        add(userIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(takeBook, gbc);

        gbc.gridx = 1;
        add(returnBook, gbc);

        // Submit button
        JButton submitButton = new JButton("Submit");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(submitButton, gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TakeReturnBookFrame::new);
    }
}
