
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2;

    login() {
        super("Login Page");
        getContentPane().setBackground(new Color(245, 245, 245));

        l1 = new JLabel("User Name");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));

        l2 = new JLabel("Password");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));

        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);

        b1 = new JButton("Login");
        b1.setBackground(new Color(33, 150, 243));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));

        b2 = new JButton("Cancel");
        b2.setBackground(new Color(244, 67, 54));
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(l1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(tf1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(l2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(pf2, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.add(b1);
        buttonPanel.add(b2);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            System.exit(0);
        }

        try {
            conn c1 = new conn();
            String username = tf1.getText();
            String password = new String(pf2.getPassword());

            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
            ResultSet rs = c1.s.executeQuery(query);

            if (rs.next()) {
                new Project().setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Invalid login credentials. Please check your username and password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error connecting to database. See terminal for details.");
        }
    }

    public static void main(String[] args) {
        new login();
    }
}
