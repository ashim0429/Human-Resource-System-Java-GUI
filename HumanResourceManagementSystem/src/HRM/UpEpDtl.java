package HRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class  UpEpDtl extends JFrame implements ActionListener {

     JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
     JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
     JButton b1,b2,b3;

    UpEpDtl(){

        super("Update Employee Details");
        setLayout(null);
        setForeground( new Color(90,87,98));


        l1 = new JLabel("Enter id of employee to update details");
        l1.setBounds(50,100,500,30);
        l1.setFont(new Font("serif", Font.ITALIC,20));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(500,100,200,30);
        add(t1);

        b1 = new JButton("Update");
        b1.setBackground(new Color(120, 87, 210));
        b1.setForeground(Color.WHITE);
        b1.setBounds(720,100,100,30);
        add(b1);
        b1.addActionListener( this);


        l2 = new JLabel("Update Employee Details:");
        l2.setForeground( new Color(90,87,98));
        l2.setBounds(50,10,500,50);
        l2.setFont(new Font("serif",Font.ITALIC,40));
        l2.setForeground(Color.black);
        add(l2);

        l3 = new JLabel("Name");
        l3.setForeground( new Color(90,87,98));
        l3.setBounds(50,170,100,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);

        t2=new JTextField();
        t2.setBounds(200,170,150,30);
        add(t2);

        l4= new JLabel("Email Id");
        l4.setForeground( new Color(90,87,98));
        l4.setBounds(400,170,200,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        add(l4);

        t3=new JTextField();
        t3.setBounds(600,170,150,30);
        add(t3);

        l5= new JLabel("Username");
        l5.setForeground( new Color(90,87,98));
        l5.setBounds(50,250,150,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        add(l5);

        t4=new JTextField();
        t4.setBounds(200,250,150,30);
        add(t4);

        l6= new JLabel("Password");
        l6.setForeground( new Color(90,87,98));
        l6.setBounds(400,250,150,30);
        l6.setFont(new Font("serif",Font.BOLD,20));
        add(l6);

        t5=new JTextField();
        t5.setBounds(600,250,150,30);
        add(t5);


        l7= new JLabel("Role");
        l7.setForeground( new Color(90,87,98));
        l7.setBounds(50,330,100,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        add(l7);

        t6=new JTextField();
        t6.setBounds(200,330,150,30);
        add(t6);

        l8= new JLabel("Post");
        l8.setForeground( new Color(90,87,98));
        l8.setBounds(400,320,150,30);
        l8.setFont(new Font("serif",Font.BOLD,20));
        add(l8);

        t7=new JTextField();
        t7.setBounds(600,330,150,30);
        add(t7);

        l9=new JLabel("Salary");
        l9.setForeground( new Color(90,87,98));
        l9.setBounds(50,410,150,30);
        l9.setFont(new Font("serif",Font.BOLD,20));
        add(l9);

        t8=new JTextField();
        t8.setBounds(200,410,150,30);
        add(t8);

//        l10=new JLabel("ID");
//        l10.setForeground( new Color(90,87,98));
//        l10.setBounds(400,410,150,30);
//        l10.setFont(new Font("serif",Font.BOLD,20));
//        add(l10);
//
//        t9=new JTextField();
//        t9.setBounds(600,410,150,30);
//        add(t9);

        b2=new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,520,150,40);
        add(b2);
        b2.addActionListener( this);

        b3=new JButton("Submit");
        b3.setBackground(new Color(38,95,228));
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setFocusable(false);
        b3.setBounds(450,520,150,40);
        add(b3);



        setVisible(true);
        setSize(900,650);
        getContentPane().setBackground( new Color(210,217,235));

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==b2){
            try{
                Connect c = new Connect();
                String str = "Update employeelogin set name='"+t2.getText()+"',email='"+t3.getText()+"',username='"+t4.getText()+"', pass='"+t5.getText()+"',role='"+t6.getText()+"',post='"+t7.getText()+"',salary='"+t8.getText()+"' where ID= '"+t1.getText()+"'";
                c.s.executeUpdate(str);
               //JOptionPane.showMessageDialog(null,"Data successfully updated");
                setVisible(false);
                new EmployeeDetail();
            }catch(Exception ex){
                System.out.println("The error is:"+ex);
            }
        }
        if(e.getSource()==b3){
            this.dispose();
            new UpEpDtl();
            JOptionPane.showMessageDialog(null,"Data successfully updated");
        }
        if(e.getSource() == b1){
            try{
                Connect c = new Connect();
                String str = "select * from employeelogin where ID = '"+t1.getText()+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("email"));
                    t4.setText(rs.getString("username"));
                    t5.setText(rs.getString("pass"));
                    t6.setText(rs.getString("role"));
                    t7.setText(rs.getString("post"));
                    t8.setText(rs.getString("salary"));

                }
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }

}
