package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;

    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit , cancel;

    String formno,phnno;

    SignupThree(String formno,String phnno){
        this.formno = formno;
        this.phnno = phnno;

        setLayout(null);

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Railway" ,Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
//***********************************************************************************
        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Railway" ,Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,200,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,200,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        //***********************************************************************************

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Railway" ,Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel carddetails = new JLabel("Your 16 Digit Card Number ");
        carddetails.setFont(new Font("Railway" ,Font.BOLD,12));
        carddetails.setBounds(100,330,300,20);
        add(carddetails);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1908");
        number.setFont(new Font("Railway" ,Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);
        //***********************************************************************************

        JLabel pin = new JLabel("Pin Number ");
        pin.setFont(new Font("Railway" ,Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pindetails = new JLabel("Your 4 Digit Password ");
        pindetails.setFont(new Font("Railway" ,Font.BOLD,12));
        pindetails.setBounds(100,400,300,20);
        add(pindetails);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Railway" ,Font.BOLD,22));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);

        //***********************************************************************************

        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Railway" ,Font.BOLD,22));
        services.setBounds(100,450,400,30);
        add(services);

        c1= new JCheckBox(" ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        c2= new JCheckBox(" Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        c3= new JCheckBox(" Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        c4= new JCheckBox(" Email And SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        c5= new JCheckBox(" Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        c6= new JCheckBox(" E - Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        c7= new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Railway",Font.BOLD,12));
        c7.setBounds(100,650,600,30);
        add(c7);

        //***********************************************************************************

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Railway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
//***********************************************************************************
        getContentPane().setBackground(Color.WHITE);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType="Saving Account";
            } else if (r2.isSelected()) {
                accountType="Fixed Deposit Account";
            }else if (r3.isSelected()) {
                accountType="Current Account";
            }else if (r4.isSelected()) {
                accountType="Recurring Deposit Account";
            }

            Random random =new Random();
            String cardnumber =""+ Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);

            String pinumber = ""+Math.abs((random.nextLong() % 9000L)+1000L);

            String facility ="";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            } else if (c2.isSelected()) {
                facility=facility + " Internet Banking";
            }else if (c3.isSelected()) {
                facility=facility + " Mobile Banking";
            }else if (c4.isSelected()) {
                facility=facility + " Email & SMS Alert";
            }else if (c5.isSelected()) {
                facility=facility + " Cheque Book";
            }else if (c6.isSelected()) {
                facility=facility + " E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else {
//                    Conn con = new Conn();
                    String query1  = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinumber+"', '"+facility+"')";
                    String query2  = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinumber+"','"+phnno+"')";

                    JOptionPane.showMessageDialog(null,"Card Number :"+cardnumber+"\n Pin :"+pinumber );
                    SendSMS.sendSms(formno,cardnumber,pinumber,phnno);

                    Connection con =ConnectionProvider.getConnection();
                    PreparedStatement pstmt1 = con.prepareStatement(query1);
                    PreparedStatement pstmt2 = con.prepareStatement(query2);
                    pstmt1.executeUpdate();
                    pstmt2.executeUpdate();

                    setVisible(false);
                    new Login().setVisible(true);

                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    

    public static void main(String[] args) {
        new SignupThree("","");
    }
}
