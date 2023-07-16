package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MiniStatement extends JFrame {
    String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("S_S_M Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

//        JLabel balance = new JLabel();


        Connection con =ConnectionProvider.getConnection();
        int bal = 0;
        try{
            String q = "select * from login where pin ='"+pinnumber+"'";//Passing Query
            Statement stmt = con.createStatement();//Creating Statement
            ResultSet set = stmt.executeQuery(q);

            while(set.next()){
                card.setText("Card Number: "+set.getString("cardnumber").substring(0,4)+"XXXXXXXX"+set.getString("cardnumber").substring(12));

            }
        }catch (Exception e){
            System.out.println(e);
        }

        try{
//            Connection con = ConnectionProvider.getConnection();
            String q = "select * from bank where pin ='"+pinnumber+"'";//Passing Query
            Statement stmt = con.createStatement();//Creating Statement
            ResultSet set = stmt.executeQuery(q);
            while (set.next()){
                mini.setText(mini.getText() + "<html>"+set.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+set.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+set.getString("amount")+"<br><br><html>");
            }
        }catch (Exception e){
            System.out.println(e);
        }

        mini.setBounds(20,140,400,200);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }


    public static void main(String[] args) {
        new MiniStatement("");
    }
}
