
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LastBill extends JFrame implements ActionListener {
    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice c1;

    LastBill() {
        super("Last Bill Details");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(245, 245, 245));
        l1 = new JLabel("Meter Number:");
        c1 = new Choice();
        for (int i = 1001; i <= 1010; i++)
            c1.add(String.valueOf(i));

        p1.add(l1);
        p1.add(c1);

        t1 = new JTextArea(50, 15);
        t1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        t1.setEditable(false);
        JScrollPane jsp = new JScrollPane(t1);

        b1 = new JButton("Fetch Last Bills");
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
            t1.setText("\n\t   - LAST BILLING HISTORY - \n");
            t1.append("\t---------------------------------\n\n");

            ResultSet rs = c.s.executeQuery("select * from emp where meter_number='" + meter + "'");
            if (rs.next()) {
                t1.append("\tCustomer: " + rs.getString("name") + "\n");
                t1.append("\tMeter:    " + rs.getString("meter_number") + "\n");
            }
            t1.append("\n\tMonth\t\tAmount\n");
            t1.append("\t---------------------------------\n");

            rs = c.s.executeQuery("select * from bill where meter_number='" + meter + "'");
            while (rs.next()) {
                t1.append("\t" + rs.getString("month") + "\t\t" + rs.getString("amount") + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LastBill().setVisible(true);
    }
}