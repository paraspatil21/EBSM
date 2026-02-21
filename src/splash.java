
import java.awt.*;
import javax.swing.*;

public class splash {
    public static void main(String args[]) {
        fframe f1 = new fframe();
        f1.setVisible(true);
        int i;
        int x = 1;
        for (i = 2; i <= 600; i += 4, x++) {
            f1.setLocation(800 - ((i + x) / 2), 500 - (i / 2));
            f1.setSize((i + x), i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }

    public static class fframe extends JFrame implements Runnable {
        Thread t1;

        fframe() {
            super("Electricity Billing System");
            getContentPane().setBackground(new Color(33, 150, 243));
            setLayout(new GridBagLayout());

            JLabel l1 = new JLabel("ELECTRICITY BILLING SYSTEM");
            l1.setFont(new Font("Tahoma", Font.BOLD, 30));
            l1.setForeground(Color.WHITE);
            add(l1);

            t1 = new Thread(this);
            t1.start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
                this.setVisible(false);
                new login().setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
