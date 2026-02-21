import java.sql.*;

public class conn {
    public Connection c;
    public Statement s;

    public conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection URL with SSL and Timezone parameters for MySQL 8.0+ compatibility
            String url = "jdbc:mysql://localhost:3306/ebs?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String pass = "@paraspatil7777777";

            c = DriverManager.getConnection(url, user, pass);
            s = c.createStatement();

            System.out.println("Connected to Database Successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found. Make sure mysql-connector-j-8.4.0.jar is in the classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed! Check if MySQL is running and credentials are correct.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }
}
