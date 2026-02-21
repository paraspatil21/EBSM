
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class generate_bill extends JFrame implements ActionListener {
    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice c1, c2;

    generate_bill() {
        super("Generate Bill Report");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.setBackground(new Color(245, 245, 245));

        l1 = new JLabel("Meter Number:");
        c1 = new Choice();
        for (int i = 1001; i <= 1010; i++)
            c1.add(String.valueOf(i));

        c2 = new Choice();
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        for (String m : months)
            c2.add(m);

        p1.add(l1);
        p1.add(c1);
        p1.add(new JLabel("Month:"));
        p1.add(c2);

        t1 = new JTextArea(50, 15);
        t1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        t1.setEditable(false);
        JScrollPane jsp = new JScrollPane(t1);

        b1 = new JButton("Generate Bill");
        b1.setBackground(new Color(33, 150, 243));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(this);

        add(p1, BorderLayout.NORTH);
        add(jsp, BorderLayout.CENTER);
        add(b1, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            conn c = new conn();
            String meter = c1.getSelectedItem();
            String month = c2.getSelectedItem();

            t1.setText("\n\t  - ELECTRICITY BILLING REPORT - \n");
            t1.append("\t---------------------------------\n");
            t1.append("\tMonth: " + month + " , 2024\n\n");

            ResultSet rs = c.s.executeQuery("select * from emp where meter_number='" + meter + "'");
            if (rs.next()) {
                t1.append("\tCustomer: " + rs.getString("name") + "\n");
                t1.append("\tMeter:    " + rs.getString("meter_number") + "\n");
                t1.append("\tAddress:  " + rs.getString("address") + "\n");
                t1.append("\tState:    " + rs.getString("state") + "\n");
                t1.append("\tCity:     " + rs.getString("city") + "\n");
                t1.append("\tEmail:    " + rs.getString("email") + "\n");
                t1.append("\tPhone:    " + rs.getString("phone") + "\n");
            }
            t1.append("\n\t---------------------------------\n");

            rs = c.s.executeQuery("select * from bill where meter_number='" + meter + "' and month='" + month + "'");
            if (rs.next()) {
                t1.append("\tUnits Consumed: " + rs.getString("units") + "\n");
                t1.append("\tTotal Charges:  " + rs.getString("amount") + "\n");
                t1.append("\n\t---------------------------------\n");
                t1.append("\tTOTAL PAYABLE:  " + rs.getString("amount") + "\n");
            } else {
                t1.append("\tBill data not found for this month.\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new generate_bill().setVisible(true);
    }
}