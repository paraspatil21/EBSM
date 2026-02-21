
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class new_customer extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;

    new_customer() {
        super("Add New Customer");
        setSize(700, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        l1 = new JLabel("Customer Name");
        t1 = new JTextField(20);
        l2 = new JLabel("Meter Number");
        t2 = new JTextField(20);
        l3 = new JLabel("Address");
        t3 = new JTextField(20);
        l4 = new JLabel("State");
        t4 = new JTextField(20);
        l5 = new JLabel("City");
        t5 = new JTextField(20);
        l6 = new JLabel("Email Address");
        t6 = new JTextField(20);
        l7 = new JLabel("Phone Number");
        t7 = new JTextField(20);

        addComponent(p, l1, gbc, 0, 0);
        addComponent(p, t1, gbc, 1, 0);
        addComponent(p, l2, gbc, 0, 1);
        addComponent(p, t2, gbc, 1, 1);
        addComponent(p, l3, gbc, 0, 2);
        addComponent(p, t3, gbc, 1, 2);
        addComponent(p, l4, gbc, 0, 3);
        addComponent(p, t4, gbc, 1, 3);
        addComponent(p, l5, gbc, 0, 4);
        addComponent(p, t5, gbc, 1, 4);
        addComponent(p, l6, gbc, 0, 5);
        addComponent(p, t6, gbc, 1, 5);
        addComponent(p, l7, gbc, 0, 6);
        addComponent(p, t7, gbc, 1, 6);

        b1 = new JButton("Submit");
        b1.setBackground(new Color(33, 150, 243));
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Cancel");
        b2.setBackground(new Color(244, 67, 54));
        b2.setForeground(Color.WHITE);

        JPanel btnP = new JPanel();
        btnP.setBackground(Color.WHITE);
        btnP.add(b1);
        btnP.add(b2);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        p.add(btnP, gbc);

        add(p);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    private void addComponent(JPanel p, JComponent c, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        p.add(c, gbc);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {
            this.setVisible(false);
            return;
        }

        String name = t1.getText();
        String meter = t2.getText();
        String address = t3.getText();
        String state = t4.getText();
        String city = t5.getText();
        String email = t6.getText();
        String phone = t7.getText();

        String q = "insert into emp values('" + name + "','" + meter + "','" + address + "','" + state + "','" + city
                + "','" + email + "','" + phone + "')";

        try {
            conn c1 = new conn();
            c1.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Customer Added Successfully");
            this.setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new new_customer().setVisible(true);
    }
}