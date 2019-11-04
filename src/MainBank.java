import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import com.jgoodies.forms.layout.FormLayout;

public class MainBank {
    private static JFrame mainFrame = new JFrame("Bank App");
    private JPanel loginPane = new JPanel();
    private JButton button1;

    public MainBank() {

    }

    public static void login() {
        JPanel loginPane = new JPanel();
        mainFrame.setContentPane(loginPane);
        loginPane.updateUI();

        JButton clicky = new JButton("Click me!");
        JTextField user = new JTextField("Password");

        clicky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("You've been clicked!");
                manager();
            }
        });

        loginPane.add(user);
        loginPane.add(clicky);
    }

    public static void manager() {
        JPanel managerPane = new JPanel();
        mainFrame.setContentPane(managerPane);
        managerPane.updateUI();

        JLabel label = new JLabel();
        label.setText("You are now managing");

        JButton logout = new JButton();
        logout.setText("Log out");
        logout.setSize(new Dimension());
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });

        managerPane.add(label);
        managerPane.add(logout);
    }

    public static void customer() {
        JPanel customerPane = new JPanel();
        mainFrame.setContentPane(customerPane);
        customerPane.updateUI();

        JLabel label = new JLabel();
        label.setText("You are a customer.");

        JButton logout = new JButton();
        logout.setText("Log out");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });

        customerPane.add(label);
        customerPane.add(logout);
    }

    public static void main (String[] args) {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        login();
    }
}
