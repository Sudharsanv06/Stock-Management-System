package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {

    private JLabel title;
    private JLabel booksSection;
    private JLabel usersSection;
    private JButton addBookBtn, viewBooksBtn, addUserBtn, manageUsersBtn;

    public HomePage() {
        // Set frame properties
        setTitle("Stock Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400); // Initial size
        setLocationRelativeTo(null); // Center the window

        // Main panel using GridBagLayout for flexibility
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.BLACK); // Dark background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        title = new JLabel("Stock Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.CYAN); // Neon color for title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 20, 10); // Padding
        mainPanel.add(title, gbc);

        // Inventory Section
        booksSection = new JLabel("Stock Section", SwingConstants.CENTER);
        booksSection.setFont(new Font("Arial", Font.BOLD, 18));
        booksSection.setForeground(Color.MAGENTA); // Neon color for section labels
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(booksSection, gbc);

        // Inventory Section Buttons
        addBookBtn = new JButton("Add New Stock");
        viewBooksBtn = new JButton("View Available Stock");
        styleButton(addBookBtn, new Color(57, 255, 20)); // Neon green
        styleButton(viewBooksBtn, new Color(255, 89, 255)); // Neon pink

        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between buttons
        mainPanel.add(addBookBtn, gbc);

        gbc.gridx = 1;
        mainPanel.add(viewBooksBtn, gbc);

        // Users Section
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        usersSection = new JLabel("Users Section", SwingConstants.CENTER);
        usersSection.setFont(new Font("Arial", Font.BOLD, 18));
        usersSection.setForeground(Color.ORANGE); // Neon orange
        mainPanel.add(usersSection, gbc);

        // Users Section Buttons
        addUserBtn = new JButton("Add New User");
        manageUsersBtn = new JButton("Manage Inventory");
        styleButton(addUserBtn, new Color(0, 255, 255)); // Neon cyan
        styleButton(manageUsersBtn, new Color(255, 255, 0)); // Neon yellow

        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(addUserBtn, gbc);

        gbc.gridx = 1;
        mainPanel.add(manageUsersBtn, gbc);

        // Add main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        addBookBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookFrame(); // Opens Add Inventory Form
            }
        });

        viewBooksBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewBooksFrame(); // Opens View Inventory Form
            }
        });

        addUserBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUserFrame(); // Opens Add User Form
            }
        });

        manageUsersBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TakeReturnBookFrame(); // Opens Manage Inventory Form
            }
        });

        // Adjust components dynamically based on window size
        adjustComponentSizes();
    }

    // Adjust button sizes dynamically
    private void adjustComponentSizes() {
        int width = getWidth();
        int height = getHeight();
        // Adjust title font size based on window size
        title.setFont(new Font("Arial", Font.BOLD, width / 25));
        booksSection.setFont(new Font("Arial", Font.BOLD, width / 35));
        usersSection.setFont(new Font("Arial", Font.BOLD, width / 35));

        // Adjust button size dynamically
        Dimension buttonSize = new Dimension(width / 3, height / 10);
        addBookBtn.setPreferredSize(buttonSize);
        viewBooksBtn.setPreferredSize(buttonSize);
        addUserBtn.setPreferredSize(buttonSize);
        manageUsersBtn.setPreferredSize(buttonSize);

        revalidate(); // Re-layout the components
        repaint();    // Redraw the UI
    }

    // Method to style the buttons (color, size, font)
    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.BLACK); // Black text on neon background
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePage homePage = new HomePage();
            homePage.setVisible(true);
        });
    }
}
