package HRM;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SelfView extends JFrame implements ActionListener {

    JButton b2;
    JTable t1;
    JScrollPane sp;
    String name;
    String column[] = {"ID", "Post", "Name", "Username", "Email", "Salary"};
    String data[][] = new String[1][10];
    int i = 0, j = 0;


    SelfView(String name) {

        super("Self Details View");
        setLayout(null);
        this.name = name;

        try {
            Connect c1 = new Connect();
            String s1 = "select * from employeelogin where name='" + this.name + "'";
            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                data[i][j++] = rs.getString("ID");
                data[i][j++] = rs.getString("Post");
                data[i][j++] = rs.getString("Name");
                data[i][j++] = rs.getString("Username");
                data[i][j++] = rs.getString("Email");
                data[i][j++] = rs.getString("Salary");
                i++;
                j = 0;
            }
            t1 = new JTable(data, column);

        } catch (Exception e) {
            e.printStackTrace();
        }

        sp = new JScrollPane(t1);
        sp.setBounds(20, 20, 700, 100);
        add(sp);


        b2 = new JButton("Back to Home page");
        b2.setBackground(new Color(120, 87, 210));
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.setBounds(280, 150, 200, 30);
        add(b2);
        b2.addActionListener(this);


        setSize(750, 250);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        getContentPane().setBackground( new Color(210,217,235));

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b2){
            this.dispose();
//            new UpdateSelf(this.name);
        }
        if(e.getSource()==b2){
            this.dispose();
            new EmployeePanel(this.name);
        }
    }
}
