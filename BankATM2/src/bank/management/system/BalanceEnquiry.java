package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        Connection con =ConnectionProvider.getConnection();
        int balance = 0;
        try{
            String q = "select * from bank where pin = '"+pinnumber+"'";//Passing Query
            Statement stmt = con.createStatement();//Creating Statement
            ResultSet set = stmt.executeQuery(q);

            while(set.next()){
                if(set.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt( set.getString("amount"));
                }else {
                    balance -= Integer.parseInt( set.getString("amount"));
                }
            }
        }catch(Exception e){
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs: " +balance );
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
