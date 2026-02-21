
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    Project() {
        super("Electricity Billing System - Main Dashboard");

        setSize(1366, 768);
        getContentPane().setBackground(new Color(240, 240, 240));

        JLabel title = new JLabel("Welcome to Electricity Billing System", JLabel.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 36));
        title.setForeground(new Color(33, 150, 243));
        title.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        add(title, BorderLayout.NORTH);

        JPanel mainContent = new JPanel();
        mainContent.setBackground(new Color(240, 240, 240));
        JLabel subtitle = new JLabel("Manage your electricity bills and customers efficiently.");
        subtitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
        mainContent.add(subtitle);
        add(mainContent, BorderLayout.CENTER);

        /* Menu Bar setup */
        JMenuBar mb = new JMenuBar();
        mb.setBackground(Color.WHITE);
        mb.setFont(new Font("Tahoma", Font.PLAIN, 14));

        /* Master Menu */
        JMenu master = new JMenu("Master");
        master.setForeground(new Color(33, 150, 243));
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        m1.addActionListener(this);
        m2.addActionListener(this);
        master.add(m1);
        master.add(m2);

        /* User Menu */
        JMenu user = new JMenu("User");
        user.setForeground(new Color(244, 67, 54));
        JMenuItem u1 = new JMenuItem("Pay Bill");
        JMenuItem u2 = new JMenuItem("Calculate Bill");
        JMenuItem u3 = new JMenuItem("Last Bill");
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        user.add(u1);
        user.add(u2);
        user.add(u3);

        /* Report Menu */
        JMenu report = new JMenu("Report");
        report.setForeground(new Color(33, 150, 243));
        JMenuItem r1 = new JMenuItem("Generate Bill");
        r1.addActionListener(this);
        report.add(r1);

        /* Utility Menu */
        JMenu utility = new JMenu("Utility");
        utility.setForeground(new Color(244, 67, 54));
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");
        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);
        utility.add(ut1);
        utility.add(ut2);
        utility.add(ut3);

        /* Exit Menu */
        JMenu exit = new JMenu("Exit");
        exit.setForeground(new Color(33, 150, 243));
        JMenuItem ex = new JMenuItem("Logout");
        ex.addActionListener(this);
        exit.add(ex);

        mb.add(master);
        mb.add(user);
        mb.add(report);
        mb.add(utility);
        mb.add(exit);

        setJMenuBar(mb);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Customer Details")) {
            new customer_details().setVisible(true);
        } else if (msg.equals("New Customer")) {
            new new_customer().setVisible(true);
        } else if (msg.equals("Calculate Bill")) {
            new calculate_bill().setVisible(true);
        } else if (msg.equals("Pay Bill")) {
            new pay_bill().setVisible(true);
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("Web Browser")) {
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            } catch (Exception e) {
            }
        } else if (msg.equals("Logout")) {
            this.setVisible(false);
            new login().setVisible(true);
        } else if (msg.equals("Generate Bill")) {
            new generate_bill().setVisible(true);
        } else if (msg.equals("Last Bill")) {
            new LastBill().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Project().setVisible(true);
    }
}