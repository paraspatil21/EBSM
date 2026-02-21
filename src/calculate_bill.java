
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class calculate_bill extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField t1;
    Choice c1, c2;
    JButton b1, b2;

    calculate_bill() {
        super("Calculate Electricity Bill");
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST;

        l1 = new JLabel("Meter Number");
        l2 = new JLabel("Units Consumed");
        l3 = new JLabel("Month");

        c1 = new Choice();
        // Dynamic loading from DB would be better, but keeping the static items for now
        for (int i = 1001; i <= 1010; i++)
            c1.add(String.valueOf(i));

        c2 = new Choice();
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        for (String m : months)
            c2.add(m);

        t1 = new JTextField(15);

        b1 = new JButton("Calculate");
        b1.setBackground(new Color(33, 150, 243));
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Cancel");
        b2.setBackground(new Color(244, 67, 54));
        b2.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(l1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(c1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(l3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(c2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(l2, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(t1, gbc);

        JPanel btnP = new JPanel();
        btnP.setBackground(Color.WHITE);
        btnP.add(b1);
        btnP.add(b2);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnP, gbc);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            this.setVisible(false);
            return;
        }

        String meter = c1.getSelectedItem();
        String unitsStr = t1.getText();
        String month = c2.getSelectedItem();

        try {
            int units = Integer.parseInt(unitsStr);
            int amount = (units * 7) + 250 + 200 + 150 + 100; // Formula matched with original code but simplified logic

            String q = "insert into bill values('" + meter + "','" + month + "','" + units + "','" + amount + "')";
            conn c = new conn();
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Bill Calculated and Stored Successfully");
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter valid unit count");
        }
    }

    public static void main(String[] args) {
        new calculate_bill().setVisible(true);
    }
}