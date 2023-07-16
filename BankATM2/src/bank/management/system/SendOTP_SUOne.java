package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.Random;



public class SendOTP_SUOne extends JFrame implements ActionListener {
    int otpsend  ;
    JTextField phn, otpp;

    JButton send, verify;
    SendOTP_SUOne(){
        setLayout(null);
        JLabel phoneno1 = new JLabel("Phone Number : ");
        phoneno1.setFont(new Font("Railway" ,Font.BOLD,20));
        phoneno1.setBounds(10,80,200,30);
        add(phoneno1);

        phn = new JTextField();
        phn.setFont(new Font("Railway", Font.BOLD,15));
        phn.setBounds(250,80,200,30);
        add(phn);

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
            System.out.println("this is randotp :" + otpsend);
            String phnno = phn.getText();
            if (ae.getSource() == send) {
                Random rand = new Random();
                otpsend = rand.nextInt(999999);
                System.out.println("this is randotp send :" + otpsend);
                SendSMSOTP.sendSms(otpsend, phnno);
            }
            if (ae.getSource() == verify) {
                int otpcheck = Integer.parseInt(otpp.getText());
                System.out.println("this is otpcheck :" + otpcheck);
                if (otpcheck==otpsend) {
                    JOptionPane.showMessageDialog(null, "You are login successflly");
                    setVisible(false);
                    new SignUpOne(phnno).setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "otp is Wrong");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new SendOTP_SUOne();
    }
}

