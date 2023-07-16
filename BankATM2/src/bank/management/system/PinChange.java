package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change , back;
    String pinnumber;
    PinChange(String pinchange){
        this.pinnumber = pinchange;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD, 16));
        text.setBounds(250,280,500,35);
        image.add(text);
//******************************************************************************
        JLabel pintext = new JLabel("New Pin :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD, 16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

         pin = new JPasswordField();
        pin.setFont(new Font("Railway",Font.BOLD,25));
        pin.setBounds(320,320,180,25);
        image.add(pin);
//******************************************************************************
        JLabel repintext = new JLabel("Re-Enter New Pin :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD, 16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

         repin = new JPasswordField();
        repin.setFont(new Font("Railway",Font.BOLD,25));
        repin.setBounds(320,360,180,25);
        image.add(repin);

        change = new JButton("Change");
        change.setBounds(355,460,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355,495,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
        try{
            String npin = pin.getText();
            String rpin = repin.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered Pin does not match");
                return;
            }

            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                return;
            }
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-Enter New Pin");
                return;
            }


            String q1 = "update bank set pin = '"+rpin+"' where pin ='"+ pinnumber +"'";
            String q2 = "update login set pin = '"+rpin+"' where pin ='"+ pinnumber +"'";
            String q3 = "update signupthree set pin = '"+rpin+"' where pin ='"+ pinnumber +"'";

            Connection con =ConnectionProvider.getConnection();
            PreparedStatement pstmt1 = con.prepareStatement(q1);
            PreparedStatement pstmt2 = con.prepareStatement(q2);
            PreparedStatement pstmt3 = con.prepareStatement(q3);
            pstmt1.executeUpdate();
            pstmt2.executeUpdate();
            pstmt3.executeUpdate();

            JOptionPane.showMessageDialog(null,"Pin Changed Successfully");

            setVisible(false);
            new Transactions(rpin).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }
    }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
