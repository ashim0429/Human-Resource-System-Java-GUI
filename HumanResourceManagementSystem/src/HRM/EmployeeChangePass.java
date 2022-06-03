package HRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.text.StyleConstants.setBackground;

public class EmployeeChangePass extends JFrame implements ActionListener {
    private JLabel oldPassword, newPassword, confirmPassword;
    private JPasswordField old, f1, f5;
    private JButton submit, cancel;
    private JPasswordField password;

    String name;

    EmployeeChangePass(String name) {
        super("EmployeeChangePass");

        getContentPane().setBackground( new Color(210,217,235));
        setLayout(null);
        this.name = name;

        oldPassword = new JLabel("Old Password");
        oldPassword.setForeground( new Color(90,87,98));
        oldPassword.setBounds(60, 80, 100, 30);
        add(oldPassword);
        old = new JPasswordField();
        old.setBounds(200, 80, 120, 30);
        add(old);

        newPassword = new JLabel("New Password");
        newPassword.setForeground( new Color(90,87,98));
        newPassword.setBounds(60, 140, 100, 30);
        add(newPassword);
        f1 = new JPasswordField();
        f1.setBounds(200, 140, 120, 30);
        add(f1);

        confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setForeground( new Color(90,87,98));
        confirmPassword.setBounds(60, 190, 150, 30);
        add(confirmPassword);
        f5 = new JPasswordField();
        f5.setBounds(200, 190, 120, 30);
        add(f5);

        confirmPassword = new JLabel();
        confirmPassword.setBounds(520, 70, 150, 30);
        add(confirmPassword);


        submit = new JButton("Submit");
        submit.setBounds(230, 280, 100, 30);
        submit.setBackground(new Color(38,95,228));
        submit.setForeground(Color.WHITE);
        submit.addActionListener((ActionListener) this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(50, 280, 100, 30);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener((ActionListener) this);
        add(cancel);

        ImageIcon i1 = new ImageIcon("src\\HRM\\reset.png");
        Image i2 = i1.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(160, 20, 40, 40);
        add(l3);


        setVisible(true);
        setSize(800, 450);
        setLocationRelativeTo(null);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

    }

    //even listener for the button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
            new EmployeePanel(this.name);
        }
        if (e.getSource() == submit) {
            String a = old.getText();
            String b = f1.getText();
            String d = f5.getText();
            try {
                //object for connection class
                Connect c = new Connect();
                //storing sql query in a variable
                String f = "Select pass from EmployeeLogin where name='" + this.name + "'  ";
                //execution sql query
                ResultSet rs = c.s.executeQuery(f);
                if (rs.next()) {
                    if (rs.getString("pass").equals(a)) {
//                        if(b==d){
                        String sql = "UPDATE EmployeeLogin SET pass='" + b + "' WHERE name='" + this.name + "'";
                        c.s.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Password successfully updated");
                        setVisible(false);
                        new EmployeePanel(this.name);
                    }
//
//                        else{
//                            JOptionPane.showMessageDialog(null,"New password and Confirm Password donot match");
//                            setVisible(false);
//                            new EmployeeChangePass("");
//
//                        }

                } else {
                    JOptionPane.showMessageDialog(null, "Old Password doesnot match");
                    setVisible(false);
                    new EmployeeChangePass(this.name);
                }


            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }


    }
}

