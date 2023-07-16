package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class Withdrawal extends JFrame  implements ActionListener {
    JTextField amount;
    JButton withdrawal, back;
    String pinnumber;
    Withdrawal(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 =i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Railway", Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(355,460,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(355,495,150,30);
        back.addActionListener(this);
        image.add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdrawal ){
            String number = amount.getText();
            Date date = new Date();
            try{ if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }else{
                Connection con =ConnectionProvider.getConnection();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+number+"')";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }}catch (Exception e){

            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }



}
