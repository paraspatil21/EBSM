
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class customer_details extends JFrame implements ActionListener {

    JTable t1;
    JButton b1;
    String x[] = { "Name", "Meter No", "Address", "State", "City", "Email", "Phone" };
    String y[][] = new String[100][7];
    int i = 0, j = 0;

    customer_details() {
        super("Customer Details Directory");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        try {
            conn c1 = new conn();
            String s1 = "select * from emp";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("meter_number");
                y[i][j++] = rs.getString("address");
                y[i][j++] = rs.getString("state");
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("phone");
                i++;
                j = 0;
            }
            t1 = new JTable(y, x);
            t1.setRowHeight(25);
            t1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            t1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));

        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("Print Details");
        b1.setBackground(new Color(33, 150, 243));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(this);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.add(b1);
        add(p1, BorderLayout.SOUTH);

        JScrollPane sp = new JScrollPane(t1);
        add(sp, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            t1.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new customer_details().setVisible(true);
    }
}