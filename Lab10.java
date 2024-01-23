import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MusicStreamingApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtName;
    private JTextField txtAge;
    private JTextField txtMobile;
    private JTextField txtEmail;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextArea txtAddress;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MusicStreamingApp frame = new MusicStreamingApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MusicStreamingApp() {
        getContentPane().setBackground(new Color(127,0,255));
        setTitle("Music Streaming App");
        setBounds(100, 100, 752, 778);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Full Name : ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(42, 45, 95, 13);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Gender");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(42, 106, 95, 13);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Age");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(42, 177, 95, 18);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Mobile No");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(42, 253, 95, 13);
        getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Email");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(42, 335, 95, 13);
        getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Username");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(42, 417, 95, 13);
        getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Password");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(42, 489, 95, 13);
        getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Address");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_7.setBounds(42, 572, 95, 13);
        getContentPane().add(lblNewLabel_7);

        txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtName.setBounds(215, 44, 141, 19);
        getContentPane().add(txtName);
        txtName.setColumns(10);

        txtAge = new JTextField();
        txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtAge.setBounds(215, 176, 141, 19);
        getContentPane().add(txtAge);
        txtAge.setColumns(10);

        txtMobile = new JTextField();
        txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtMobile.setBounds(215, 252, 141, 19);
        getContentPane().add(txtMobile);
        txtMobile.setColumns(10);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtEmail.setBounds(215, 334, 141, 19);
        getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtUsername.setBounds(215, 416, 141, 19);
        getContentPane().add(txtUsername);
        txtUsername.setColumns(10);

        txtPassword = new JTextField();
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtPassword.setBounds(215, 488, 141, 19);
        getContentPane().add(txtPassword);
        txtPassword.setColumns(10);

        txtAddress = new JTextArea();
        txtAddress.setBounds(215, 568, 157, 71);
        getContentPane().add(txtAddress);

        JRadioButton rbMale = new JRadioButton("Male");
        rbMale.setBackground(new Color(127,0,255));
        buttonGroup.add(rbMale);
        rbMale.setFont(new Font("Tahoma", Font.BOLD, 14));
        rbMale.setBounds(215, 104, 103, 21);
        getContentPane().add(rbMale);

        JRadioButton rbFemale = new JRadioButton("Female");
        rbFemale.setBackground(new Color(127,0,255));
        buttonGroup.add(rbFemale);
        rbFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
        rbFemale.setBounds(412, 104, 103, 21);
        getContentPane().add(rbFemale);

        JButton btnValidate = new JButton("Register");
        btnValidate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MusicApp", "root", "@Lwintoni321");
                    String query = "INSERT INTO music (Name, Gender, Age, Mobile, Email, Username, Password, Address) VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, txtName.getText());
                    if (rbMale.isSelected())
                        ps.setString(2, rbMale.getText());
                    else
                        ps.setString(2, rbFemale.getText());
                    ps.setInt(3, Integer.parseInt(txtAge.getText()));
                    ps.setInt(4, Integer.parseInt(txtMobile.getText()));
                    ps.setString(5, txtEmail.getText());
                    ps.setString(6, txtUsername.getText());
                    ps.setString(7, txtPassword.getText());
                    ps.setString(8, txtAddress.getText());

                    int i = ps.executeUpdate();
                    JOptionPane.showMessageDialog(btnValidate, i + " Record added successfully!");
                    ps.close();
                    con.close();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnValidate.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnValidate.setBounds(146, 692, 85, 21);
        getContentPane().add(btnValidate);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtName.setText("");
                buttonGroup.clearSelection();
                txtAge.setText("");
                txtMobile.setText("");
                txtEmail.setText("");
                txtUsername.setText("");
                txtPassword.setText("");
                txtAddress.setText("");
            }
        });
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReset.setBounds(334, 692, 85, 21);
        getContentPane().add(btnReset);
    }
}
