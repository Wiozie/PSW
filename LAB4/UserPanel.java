import jdk.internal.util.xml.impl.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserPanel extends JDialog {
    private JComboBox cbEvent;
    private JTextArea taAgenda;
    private JTextField tfDate;
    private JComboBox cbAttendence;
    private JComboBox cbFood;
    private JButton btnOK;
    private JLabel lbEvent;
    private JPanel UserPanel;
    private User user;

    public UserPanel(JFrame parent) {
        super(parent);
        setTitle("Panel użytkownika");
        setContentPane(UserPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        cbEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = (String)cbEvent.getSelectedItem();

                event = getEventInfo(title);

                if(event != null) {
                    taAgenda.setText(event.agenda);
                    tfDate.setText(event.date);
                }
            }
        });

        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRegistration();
            }
        });
        setVisible(true);
    }

    private void addRegistration() {
        String food = (String)cbFood.getSelectedItem();
        String attendance = (String)cbAttendence.getSelectedItem();

        registration = addRegistrationToDatabase(food, attendance);

    }

    public Registration registration;
    private Registration addRegistrationToDatabase(String food, String attendance) {
        Registration registration = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/events";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stat = conn.createStatement();
            String sql = "INSERT INTO registrations (food, attendance)" +
                    "VALUES(?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, food);
            preparedStatement.setString(2, attendance);

            int addedRows = preparedStatement.executeUpdate();

            if (addedRows >0) {
                registration = new Registration();
                registration.food = food;
                registration.attendance = attendance;
                registration.id_user = user.id;
                registration.id_event = event.id;
            }
            stat.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return registration;
    }
    public Event event;
    private Event getEventInfo(String title) {
        Event event = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/events";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM events WHERE title=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                event = new Event();
                event.agenda = resultSet.getString("agenda");
                event.date = resultSet.getString("date");
                event.id = resultSet.getInt("id");
            }
            stat.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return event;
    }

}
