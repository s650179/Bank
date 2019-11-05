import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import com.jgoodies.forms.layout.FormLayout;

public class MainBank {
    private static JFrame mainFrame = new JFrame("Bank App");
    private JPanel loginPane = new JPanel();
    private JPasswordField passwordField1;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button1;
    private JButton xButton;
    private JButton a0Button;
    private JButton button14;
    private static GridBagConstraints c = new GridBagConstraints();

    public MainBank() {

    }

    public static void login() {
        JPanel loginPane = new JPanel();
        mainFrame.setContentPane(loginPane);
        loginPane.setLayout(new GridBagLayout());
        loginPane.updateUI();

        JButton clicky = new JButton("Click me!");
        JTextField user = new JTextField("Password");
        JLabel message = new JLabel("Welcome to Chamse Bank!");
        JLabel test = new JLabel("Test");

        clicky.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("You've been clicked!");
                System.out.println(user.getText());
                manager();
            }
        });

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        loginPane.add(message, c);

        c.gridx = 1;
        c.gridy = 1;
        loginPane.add(test, c);

        c.gridx = 0;
        c.gridy = 1;
        loginPane.add(user, c);

        c.gridx = 0;
        c.gridy = 2;
        loginPane.add(clicky, c);
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
