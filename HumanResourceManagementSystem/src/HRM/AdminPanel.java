package HRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPanel extends JFrame implements ActionListener {
    JLabel lab, nme;
    JButton vm, etres, exit;
    JPanel p1;


    AdminPanel() {
        super("Admin Panel");
        setLayout(null);
        setLocationRelativeTo(null);
        p1 = new JPanel();
        p1.setBackground( new Color(210,217,235));
        p1.setBounds(450, 0, 400, 450);
        p1.setLayout(null);
        add(p1);


        lab = new JLabel("Welcome to Admin Panel");
        lab.setBounds(60, 20, 500, 50);
        lab.setFont(new Font("serif", Font.ITALIC, 25));
        //lab.setForeground(Color.black);
        lab.setForeground( new Color(90,87,98));
        add(lab);


        vm = new JButton("View Employee Detail");
        vm.setForeground(Color.WHITE);
        vm.setBackground( new Color(120,87,210));
        vm.setBounds(100, 80, 200, 40);
        vm.setFocusable(false);
        vm.addActionListener(this);
        p1.add(vm);

        etres = new JButton("Leave Approve");
        etres.setForeground(Color.WHITE);
        etres.setBackground( new Color(120,87,210));
        etres.setBounds(100, 180, 200, 40);
        etres.setFocusable(false);
        p1.add(etres);
        etres.addActionListener(this);



        exit = new JButton("Exit");
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.RED);
        exit.setBounds(100, 280, 200, 40);
        exit.setFocusable(false);
        p1.add(exit);
        exit.addActionListener(this);

        ImageIcon i1 = new ImageIcon("src\\HRM\\admin.png");
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(40, 95, 350, 250);
        add(l3);


        setVisible(true);
        setSize(800, 450);
        setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vm) {
            this.dispose();
            new EmployeeDetail();
        }
        if (e.getSource() == etres) {
            this.dispose();
            new LeaveRequest();
        }

        if(e.getSource()== exit){
            this.dispose();
            new Login();
        }

    }

}