import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JDialog {
    private JTextField wprowadźIdUżytkownikaTextField;
    private JComboBox cbUser;
    private JTextField wprowadźIdWydarzeniaTextField;
    private JComboBox cbEvent;
    private JTextField wprowadźIdRejestracjiTextField;
    private JComboBox cbRegistration;
    private JButton OKButton;
    private JPanel adminPanel;

    public AdminPanel(JFrame parent) {
        super(parent);
        setTitle("Panel administratora");
        setContentPane(adminPanel);
        setMinimumSize(new Dimension(500, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userOption = (String)cbUser.getSelectedItem();
                String eventOption = (String)cbEvent.getSelectedItem();
                String registrationOption = (String)cbRegistration.getSelectedItem();


                if (!userOption.equals("Wybierz opcję")) {
                    int id_user = Integer.parseInt(wprowadźIdUżytkownikaTextField.getText());
                    if (userOption.equals("Dodaj")) {
                        addUser();
                    } else if (userOption.equals("Usuń")) {
                        dropUser();
                    } else if (userOption.equals("Resetuj hasło")) {
                        resetPassword();
                    }
                } else if (!eventOption.equals("Wybierz opcję")) {
                    int id_event = Integer.parseInt(wprowadźIdWydarzeniaTextField.getText());
                    if (eventOption.equals("Dodaj")) {
                        addEvent();
                    } else if (eventOption.equals("Usuń")) {
                        dropEvent();
                    } else if (eventOption.equals("Modyfikuj")) {
                        modifyEvent();
                    }
                } else if (!registrationOption.equals("Wybierz opcję")) {
                    if (registrationOption.equals("Potwierdź")) {
                        confirmRegistration();
                    } else if (eventOption.equals("Odrzuć")) {
                        dropRegistration();
                    }
                }
            }
        });
    }

    private void dropRegistration() {
    }

    private void confirmRegistration() {
    }

    private void modifyEvent() {
    }

    private void dropEvent() {

    }

    private void addEvent() {

    }

    private void resetPassword() {
    }

    private void dropUser() {

    }

    private void addUser() {

    }

    private void readSelectedOption() {

    }
}
