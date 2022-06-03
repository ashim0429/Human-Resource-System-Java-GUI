package HRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeePanel extends JFrame implements ActionListener {

    JLabel lab, nme;
    JButton vm, etres, v3, exit;
    JPanel p1;
    String name;

    EmployeePanel(String name) {

        super("Employee Panel");
        setLayout(null);
        setLocationRelativeTo(null);
        this.name = name;

        p1 = new JPanel();
        p1.setBackground( new Color(210,217,235));
        p1.setBounds(450, 0, 300, 450);
        p1.setLayout(null);
        add(p1);


        lab = new JLabel("Welcome to Employee Panel");
        lab.setBounds(100, 20, 500, 50);
        lab.setFont(new Font("serif", Font.ITALIC, 25));
        lab.setForeground(Color.black);
        add(lab);


        vm = new JButton("View my Detail");
        vm.setBackground( new Color(120,87,210));
        vm.setForeground(Color.WHITE);
        vm.setBounds(80, 50, 200, 40);
        vm.setFocusable(false);
        vm.addActionListener(this);
        p1.add(vm);

        etres = new JButton("Leave Request");
        etres.setBackground( new Color(120,87,210));
        etres.setForeground(Color.WHITE);
        etres.setBounds(80, 150, 200, 40);
        etres.setFocusable(false);
        p1.add(etres);
        etres.addActionListener(this);


        v3 = new JButton("Change Password");
        v3.setBackground( new Color(120,87,210));
        v3.setForeground(Color.WHITE);
        v3.setBounds(80, 250, 200, 40);
        v3.setFocusable(false);
        p1.add(v3);
        v3.addActionListener(this);

        exit = new JButton("Exit");
        exit.setBackground( Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setBounds(80, 350, 200, 40);
        exit.setFocusable(false);
        p1.add(exit);
        exit.addActionListener(this);


        ImageIcon i7 = new ImageIcon("src\\HRM\\welfare.png");
        Image i5 = i7.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i5);
        JLabel l9 = new JLabel(i9);
        l9.setBounds(10, 95, 400, 300);
        add(l9);
//        String sql="Select * from Employee login"
        setVisible(true);
        setSize(800, 450);
        setLocationRelativeTo(null);

        String str = "Select * from employeelogin where name= '" + this.name + "'";
        try {
            Connect connect = new Connect();

            ResultSet rs = connect.s.executeQuery(str);
            if (rs.next()) {
                nme = new JLabel(rs.getString("name"));
                nme.setBounds(100, 50, 250, 50);
                nme.setFont(new Font("serif", Font.BOLD, 25));
                nme.setForeground(Color.black);
                add(nme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vm) {
            this.dispose();
            new SelfView(this.name);
        }
        if (e.getSource() == v3) {
            this.dispose();
            new EmployeeChangePass(this.name);
        }
        if(e.getSource()==etres){
            this.dispose();
            new Leave(this.name);
        }
        if (e.getSource() == exit) {
            this.dispose();
            new Login();
        }
    }
}

