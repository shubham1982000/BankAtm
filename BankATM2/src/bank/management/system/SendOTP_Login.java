package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.Random;



public class SendOTP_Login extends JFrame implements ActionListener {
    int otpsend  ;
    JTextField phn;
    JTextField otpp;

    JButton send, verify;
    String phnno,pinnumber;
    SendOTP_Login(String phnno,String pinnumber){
        this.phnno = phnno;
        this.pinnumber = pinnumber;
        setLayout(null);
        JLabel phoneno1 = new JLabel("Press SEND Button to generate OTP ");
        phoneno1.setFont(new Font("Railway" ,Font.BOLD,14));
        phoneno1.setBounds(150,30,500,30);
        add(phoneno1);
        JLabel phoneno2 = new JLabel("Your Register Mobile Number "+phnno);
        phoneno2.setFont(new Font("Railway" ,Font.BOLD,14));
        phoneno2.setBounds(150,70,500,30);
        add(phoneno2);
//
//        phn = new JTextField();
//        phn.setFont(new Font("Railway", Font.BOLD,15));
//        phn.setBounds(250,80,200,30);
//        add(phn);

        send = new JButton("Send OTP");
        send.setBounds(250,130,200,30);
        send.addActionListener(this);
        add(send);

        JLabel phnotp = new JLabel("OTP : ");
        phnotp.setFont(new Font("Railway" ,Font.BOLD,20));
        phnotp.setBounds(10,200,200,30);
        add(phnotp);

        otpp = new JTextField();
        otpp.setFont(new Font("Railway", Font.BOLD,15));
        otpp.setBounds(250,200,200,30);
        add(otpp);

        verify = new JButton("Verify");
        verify.setBounds(200,300,150,30);
        verify.addActionListener(this);
        add(verify);

        setSize(600,400);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        try {
            if (ae.getSource() == send) {
                Random rand = new Random();
                otpsend = rand.nextInt(999999);
                SendSMSOTP.sendSms(otpsend, phnno);
            }
            if (ae.getSource() == verify) {
                int otpcheck = Integer.parseInt(otpp.getText());
                System.out.println("this is otpcheck :" + otpcheck);
                if (otpcheck==otpsend) {
                    JOptionPane.showMessageDialog(null, "You are login successflly");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "otp is Wrong");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new SendOTP_Login("","");
    }
}

