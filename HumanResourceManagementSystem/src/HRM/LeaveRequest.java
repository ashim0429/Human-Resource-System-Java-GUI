package HRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaveRequest extends JFrame implements ActionListener {

    JButton b1, b2, b3;
    JTable t1;
    JLabel l1;
    JTextField t2;
    JScrollPane sp;
    String name;
    String column[] = {"Name", "Reason", "Date of Absence"};
    String data[][] = new String[3][10];
    int i = 0, j = 0;

    LeaveRequest(){
        super("Leave Request");
        setLayout(null);


        try {
            Connect c1 = new Connect();
            String s1 = "select * from leave_employee where status='0'";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                data[i][j++] = rs.getString("name");
                data[i][j++] = rs.getString("Reason");
                data[i][j++] = rs.getString("date");
                i++;
                j = 0;
            }
            t1 = new JTable(data, column);

        } catch (Exception e) {
            e.printStackTrace();
        }

        sp = new JScrollPane(t1);
        sp.setBounds(20, 20, 500, 100);
        add(sp);

        b1 = new JButton("Approve Leave");
        b1.setBackground(new Color(38,95,228));
        b1.setForeground(Color.WHITE);
        b1.setBounds(340, 270, 130, 30);
        b1.addActionListener(this);
        b1.setFocusable(false);
        add(b1);

        b2 = new JButton("Decline");
        b2.setBackground(new Color(38,95,228));
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b2.setBounds(90, 270, 130, 30);
        add(b2);

        b3 = new JButton("Back to Home Page");
        b3.setBackground(new Color(120, 87, 210));
        b3.setForeground(Color.WHITE);
        b3.setFocusable(false);
        b3.addActionListener(this);
        b3.setBounds(220, 350, 150, 30);
        add(b3);

        l1 = new JLabel("Employee name:");
        l1.setForeground( new Color(90,87,98));
        l1.setBounds(80,200,300,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        add(l1);

        t2 = new JTextField();
        t2.setBounds(290,200,200,30);
        add(t2);

        setSize(600, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        getContentPane().setBackground( new Color(210,217,235));
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                Connect c1 = new Connect();
                String s = "UPDATE `leave_employee` SET `Status`='1' WHERE name='"+t2.getText()+"'";
                c1.s.executeUpdate(s);
                JOptionPane.showMessageDialog(null, "Leave Request Approved.");
                setVisible(false);
                new AdminPanel();
            }
            catch (SQLException ex){

            }

        }
        if(e.getSource()==b2){
            try{
                Connect c1 = new Connect();
                String s = "UPDATE `leave_employee` SET `Status`='2' WHERE name='"+t2.getText()+"'";
                c1.s.executeUpdate(s);
                JOptionPane.showMessageDialog(null, "Leave Request Declined.");
                setVisible(false);
                new AdminPanel();
            }
            catch (SQLException ex){

            }
        }
        if(e.getSource()==b3){
            this.dispose();
            new AdminPanel();
        }
    }

}
