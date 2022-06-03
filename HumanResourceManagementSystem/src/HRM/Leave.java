package HRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.text.StyleConstants.setBackground;

public class Leave extends JFrame implements ActionListener {
    private JLabel Name, Date, Status;
    private JTextField g1, g2,g5;
    private JButton submit, cancel,check;
    private JPasswordField leave;
    String name;

    String Leave[] = {"Leave Request"};


    Leave(String name){
        super("Leave Request");
        this.name=name;

        setBackground(Color.white);
        setLayout(null);

//        Name = new JLabel("Name");
//        Name.setBounds(50,40,100,30);
//        add(Name);
//        g1=new JTextField();
//        g1.setBounds(170,40,100,30);
//        add(g1);

        Date = new JLabel("Date");
        Date.setBounds(70,100,100,30);
        add(Date);
        g2=new JTextField();
        g2.setBounds(150,100,150,30);
        add(g2);

        Status = new JLabel("Reason");
        Status.setBounds(70,180,100,30);
        add(Status);
        g5=new JTextField();
        g5.setBounds(150,180,150,30);
        add(g5);


        submit = new JButton("Submit");
        submit.setBounds(230,280,100,30);
        submit.setBackground(new Color(38,95,228));
        submit.setForeground(Color.WHITE);
        submit.addActionListener((ActionListener) this);
        add(submit);

        check = new JButton("Check Status");
        check.setBounds(150,50,150,30);
        check.setBackground(new Color(120, 87, 210));
        check.setForeground(Color.WHITE);
        check.setFocusable(false);
        check.addActionListener((ActionListener) this);
        add(check);

        cancel = new JButton("Cancel");
        cancel.setBounds(50,280,100,30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener((ActionListener) this);
        add(cancel);

        setSize(400,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground( new Color(210,217,235));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Connect c = new Connect();
            if(e.getSource()==submit){
                String a= "INSERT INTO `leave_employee`(`name`, `date`, `Reason`, `Status`) VALUES ('"+this.name+"','"+g2.getText()+"','"+g5.getText()+"','0')";
                c.s.executeUpdate(a);
                JOptionPane.showMessageDialog(null, "Leave Request sent to Admin.");
                setVisible(false);
                new EmployeePanel(this.name);

            }
            if(e.getSource()==check){
                String s = "Select status from leave_employee where name='"+this.name+"'";
                ResultSet rs = c.s.executeQuery(s);
                if(rs.next()){
                    if(rs.getInt("Status")==1){
                        JOptionPane.showMessageDialog(null, "Your Leave has been Approved.");
                        this.dispose();
                        new EmployeePanel(this.name);
                    }
                    if(rs.getInt("Status")==2){
                        JOptionPane.showMessageDialog(null, "Your Leave has been Declined.");
                        this.dispose();
                        new EmployeePanel(this.name);
                    }
                }
            }
            if(e.getSource()==cancel){
                this.dispose();
                new EmployeePanel(this.name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
