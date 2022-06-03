package HRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    private JLabel name, email, usern, id, pas, crse, urol, l1;
    private JTextField nam, eml, uname, Id, t1, t2;
    private JPasswordField pass;
    private JComboBox cb, cbx;
    private JButton submit, cncl;

    String employee[] = {"Employee"};

    Random rand = new Random();
    int maxNumber = 900;

    int randomNumber = rand.nextInt(maxNumber) + 100;


    AddEmployee() {
        super("AddEmployee");

        setBackground(Color.white);
        setLayout(null);


        name = new JLabel("Name");
        name.setForeground(new Color(90, 87, 98));
        name.setBounds(40, 20, 100, 30);
        add(name);
        nam = new JTextField();
        nam.setBounds(150, 20, 150, 30);
        add(nam);

        email = new JLabel("Email");
        email.setForeground(new Color(90, 87, 98));
        email.setBounds(430, 20, 100, 30);
        add(email);
        eml = new JTextField();
        eml.setBounds(520, 20, 150, 30);
        add(eml);

        usern = new JLabel("Username");
        usern.setForeground(new Color(90, 87, 98));
        usern.setBounds(40, 70, 100, 30);
        add(usern);
        uname = new JTextField();
        uname.setBounds(150, 70, 150, 30);
        add(uname);

        id = new JLabel("ID");
        id.setForeground(new Color(90, 87, 98));
        id.setBounds(430, 120, 100, 30);
        add(id);
        Id = new JTextField();
        Id.setBounds(520, 120, 150, 30);
        Id.setText(String.valueOf(randomNumber));
        add(Id);


        pas = new JLabel("Password");
        pas.setForeground(new Color(90, 87, 98));
        pas.setBounds(430, 70, 100, 30);
        add(pas);
        pass = new JPasswordField();
        pass.setBounds(520, 70, 150, 30);
        add(pass);

        crse = new JLabel("Role");
        crse.setForeground(new Color(90, 87, 98));
        crse.setBounds(40, 120, 150, 30);
        add(crse);

        cb = new JComboBox(employee);
        cb.setBounds(150, 120, 150, 30);
        add(cb);

        urol = new JLabel("Post");
        urol.setForeground(new Color(90, 87, 98));
        urol.setBounds(40, 170, 100, 30);
        add(urol);
        t1 = new JTextField();
        t1.setBounds(150, 170, 150, 30);
        add(t1);

        l1 = new JLabel("Salary");
        l1.setForeground(new Color(90, 87, 98));
        l1.setBounds(430, 170, 100, 30);
        add(l1);
        t2 = new JTextField();
        t2.setBounds(520, 170, 150, 30);
        add(t2);

        submit = new JButton("Submit");
        submit.setBounds(450, 300, 150, 30);
        submit.setBackground(new Color(38, 95, 228));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cncl = new JButton("Cancel");
        cncl.setBounds(200, 300, 150, 30);
        cncl.setBackground(Color.RED);
        cncl.setForeground(Color.WHITE);
        cncl.addActionListener(this);
        add(cncl);


        setSize(750, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(210, 217, 235));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String a = nam.getText();
            String b = eml.getText();
            String d = uname.getText();

            String g = t1.getText();
            String j = t2.getText();
            String h = (String) cb.getSelectedItem();
            String k = pass.getText();

            if (!a.equals("") && !b.equals("")) {
                try {
                    Connect c1 = new Connect();
                    String q = "Insert into employeelogin(name,email,username,pass,role,ID,post,salary)  values('" + a + "','" + b + "','" + d + "','" + k + "','" + h + "','" + Integer.parseInt(Id.getText()) + "','" + g + "','" + j + "')";
                    c1.s.executeUpdate(q);

                } catch (SQLException z) {
                    z.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Employee Created Successfully");
                this.dispose();
                new EmployeeDetail();
            } else {
                JOptionPane.showMessageDialog(null, "Fields Cannot be empty");
                this.dispose();
                new AddEmployee();
            }
        }
    }


}
