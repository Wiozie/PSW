import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog {
    private JTextField tfLogin;
    private JPasswordField pfPassword;
    private JCheckBox cbShowPassword;
    private JButton btnLog;
    private JButton btnCancel;
    private JPanel loginPanel;

    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Zaloguj się");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        btnLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = tfLogin.getText();
                String password = String.valueOf(pfPassword.getPassword());

                user = getAutheniticatedUser(login, password);

                if (user != null){
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Nieprawidłowy login lub hasło",
                            "Spróbuj ponownie",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cbShowPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbShowPassword.isSelected()){
                    pfPassword.setEchoChar((char)0);
                }
                else {
                    pfPassword.setEchoChar('*');
                }
            }
        });
        setVisible(true);
    }

    public User user;
    private User getAutheniticatedUser(String login, String password){
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/events";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM users WHERE login=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.name = resultSet.getString("name");
                user.surname = resultSet.getString("surname");
                user.login = resultSet.getString("login");
                user.password = resultSet.getString("password");
                user.email = resultSet.getString("email");
                user.permission = resultSet.getString("permission");
                user.registrationDate = resultSet.getString("registration_date");
                user.id = resultSet.getInt("id");
            }
            stat.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;
        if (user != null) {
            System.out.println("Zalogowano");
            if(user.permission.equals("Admin")) {
                new AdminPanel(null);
            }
            else{
                new UserPanel(null);
            }
        }
        else {
            System.out.println("Nieprawidłowe dane");
        }
    }
}
