
import javax.swing.*;

public class pay_bill extends JFrame {
    pay_bill() {
        super("Online Bill Payment");
        JEditorPane j = new JEditorPane();
        j.setEditable(false);

        try {
            j.setPage("https://paytm.com/electricity-bill-payment");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText(
                    "<html><body><h1>Could not load payment gateway</h1><p>Please check your internet connection.</p></body></html>");
        }

        JScrollPane scrollPane = new JScrollPane(j);
        add(scrollPane);

        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new pay_bill().setVisible(true);
    }
}