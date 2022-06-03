package HRM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDetail extends JFrame implements ActionListener {

    JLabel lab,nme,nm;
    JButton vm,etres,v3,exit,del;
    JTable t1;
    JTextField id;

    JScrollPane sp;
    String column[] = {"Name","Email","Username","Post","Salary", "ID", "Role"};
    String data[][] = new String[20][13];
    int i=0, j=0;

    EmployeeDetail(){
        super("EmployeeDetail");
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground( new Color(210,217,235));

        lab = new JLabel("Enter id to delete employee : ");
        lab.setForeground( new Color(90,87,98));
        lab.setBounds(50,460,300,30);
        lab.setFont(new Font("serif",Font.BOLD,20));
        add(lab);

        id = new JTextField();
        id.setBounds(320,460,180,30);
        add(id);

        del = new JButton("Delete");
        del.setBackground( Color.RED);
        del.setForeground(Color.WHITE);
        del.setBounds(520, 460, 100 ,30);
        del.addActionListener(this);
        add(del);

        nme = new JLabel("Add New Employee:");
        nme.setForeground( new Color(90,87,98));
        nme.setBounds(50,360,400,30);
        nme.setFont(new Font("serif",Font.BOLD,20));
        add(nme);

        vm = new JButton("Add Employee");
        vm.setBackground( new Color(120,87,210));
        vm.setForeground(Color.WHITE);
        vm.setBounds(320, 370, 180 ,30);
        vm.addActionListener(this);
        add(vm);

        nm = new JLabel("Update Employee details:");
        nm.setForeground( new Color(90,87,98));
        nm.setBounds(50,410,400,30);
        nm.setFont(new Font("serif",Font.BOLD,20));
        add(nm);


        etres = new JButton("Update Employee details");
        etres.setBackground( new Color(120,87,210));
        etres.setForeground(Color.WHITE);
        etres.setBounds(320, 410, 180 ,30);
        etres.setFocusable(false);
        etres.addActionListener(this);
        add(etres);

        v3 = new JButton("Back to Home Page");
        v3.setBackground( new Color(120,87,210));
        v3.setForeground(Color.WHITE);
        v3.setFocusable(false);
        v3.setBounds(320, 500, 180 ,30);
        v3.addActionListener(this);
        add(v3);

        try{
            //object of a connection class
            Connect c1  = new Connect();
            String s1 = "select * from Employeelogin";
            ResultSet rs  = c1.s.executeQuery(s1);
            //iterating through the row of the table
            while(rs.next()){
                data[i][j++]=rs.getString("name");
                data[i][j++]=rs.getString("email");
                data[i][j++]=rs.getString("username");
                data[i][j++]=rs.getString("post");
                data[i][j++]=rs.getString("salary");
                data[i][j++]=rs.getString("ID");
                data[i][j++]=rs.getString("role");
                i++;
                j=0;
            }
            t1 = new JTable(data,column);

        }catch(Exception e){
            e.printStackTrace();
        }
        //adding scrolling effect to the table

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,1000,330);
        add(sp);

        setSize(1050,600);
        setVisible(true);
        setLocation(100,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Connect c=null;
        try {
            c = new Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if(e.getSource()==vm){
            this.dispose();
            new AddEmployee();
        }
        if(e.getSource()==etres){
            this.dispose();
            new UpEpDtl();
        }
        //eventlistener for the button

        if(e.getSource()==del){
            if(e.getSource() == del){
                try{
                    //storing sql query in a variable
                    String a = id.getText();
                    //executing sql query
                    String q = "delete from employeelogin where ID = '"+a+"'";
                    c.s.executeUpdate(q);


                }catch(Exception ex){
                    ex.printStackTrace();
                }
                this.dispose();
                new EmployeeDetail();
            }

        }

        if(e.getSource()==v3){
            this.dispose();
            new AdminPanel();
        }
    }



}
