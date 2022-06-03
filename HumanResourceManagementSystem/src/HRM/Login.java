package HRM;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    private JLabel uname, pas, urol;
    private JTextField nam;
    private JPasswordField pass;
    private JComboBox cb;
    private JButton login, cancel;


    String role[] = {"Please choose a role", "Admin", "Employee"};

    Login() {

        super("Login");

        setLayout(null);
        setBackground(Color.blue);

        uname = new JLabel("Username");
        uname.setBounds(260, 20, 100, 30);

        add(uname);

        pas = new JLabel("Password");
        pas.setBounds(260, 70, 100, 30);
        add(pas);

        urol = new JLabel("User Role");
        urol.setBounds(260, 120, 100, 30);
        add(urol);

        nam = new JTextField();
        nam.setBounds(370, 20, 170, 30);
        add(nam);

        pass = new JPasswordField();
        pass.setBounds(370, 70, 170, 30);
        add(pass);

        cb = new JComboBox(role);
        cb.setBounds(370, 120, 170, 30);
        add(cb);

        login = new JButton("Login");
        login.setBounds(390, 200, 130, 30);
        login.setFont(new Font("serif", Font.BOLD, 15));
        login.addActionListener(this);
        login.setBackground(new Color(38, 95, 228));
        login.setForeground(Color.WHITE);
        add(login);

        ImageIcon i1 = new ImageIcon("src\\HRM\\locksmith.png");
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(40, 20, 150, 150);
        add(l3);


        getContentPane().setBackground(new Color(210, 217, 235));

        setVisible(true);
        setSize(600, 300);
        setLocation(500, 300);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {


        if (ae.getSource() == login) {
            String u = nam.getText();
            String v = pass.getText();

            if (!u.equals("") && !v.equals("")) {
                try {
                    Connect c1 = new Connect();


                    String q = "select * from Admin where Uname='" + u + "' and pass='" + v + "'and Role = '" + cb.getSelectedItem() + "'";
                    String s = "select * from Employeelogin where username='" + u + "' and pass= '" + v + "' and Role='" + cb.getSelectedItem() + "'";


                    ResultSet rs = c1.s.executeQuery(q);

                    if (rs.next()) {
                        if (rs.getString("Role").equals("Admin")) {
                            this.dispose();
                            new AdminPanel();

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid login");
                            setVisible(false);
                        }
                    }

                    ResultSet res = c1.s.executeQuery(s);
                    if (res.next()) {

                        if (res.getString("Role").equals("Employee")) {
                            this.dispose();
                            new EmployeePanel(res.getString("name")).setVisible(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid login");
                            setVisible(false);
                        }
                    }


                } catch (SQLException e) {
                    e.printStackTrace();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Username or password cannot be empty");
                this.dispose();
                new Login();
            }


        }
    }
}







