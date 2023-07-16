package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {

    JButton signup,login,clear;
    JTextField cardTextfield;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TALLER MACHINE");//title to the frame

        setLayout(null);
//**************************** Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));//to set the image
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//Scalling the image icon
        ImageIcon i3 = new ImageIcon(i2);//passing i2 to the new object i3
        JLabel lable = new JLabel(i3);//to add to the frame
        lable.setBounds(70, 10, 100,100); //placing the image
        add(lable);//push to the frame

//************************** welcome text
        JLabel text1 = new JLabel("Welcome to ATM");//adding the text
        text1.setFont(new Font("osward",Font.BOLD, 38));
        text1.setBounds(250, 40, 400,40);
        add(text1);//push to the frame
        getContentPane().setBackground(Color.WHITE);

//************************** Card Number
        JLabel cardno = new JLabel("Card No :");//adding the text
        cardno.setFont(new Font("Railway",Font.BOLD, 20));
        cardno.setBounds(190, 140, 150,40);
        add(cardno);//push to the frame
        getContentPane().setBackground(Color.WHITE);

        cardTextfield = new JTextField();
        cardTextfield.setBounds(350, 140,250,40);
        cardTextfield.setFont(new Font("Arial",Font.BOLD,18));
        add(cardTextfield);

//************************** Pin Number
        JLabel pin = new JLabel("Pin :");//adding the text
        pin.setFont(new Font("Railway",Font.BOLD, 20));
        pin.setBounds(190, 200, 150,40);
        add(pin);//push to the frame


        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 200, 250, 40);
        cardTextfield.setFont(new Font("Arial",Font.BOLD,18));
        add(pinTextField);

//******************************Login Button
        login = new JButton("SIGN IN");
        login.setBounds(350, 300,100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);//Listens to the click / register click
        add(login);

        //******************************Clear Button
        clear = new JButton("CLEAR");
        clear.setBounds(500, 300,100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);//Listens to the click / register click
        add(clear);

        //******************************Sign Up Button
        signup = new JButton("SIGN UP");
        signup.setBounds(350, 350,250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);//Listens to the click / register click
        add(signup);


        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);//Setting a frame
        setVisible(true);//making it visible to user

        setLocation(350,200);//initial opening position on screen


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextfield.setText("");
            pinTextField.setText("");
        }
        else if (ae.getSource()==login) {
            Connection con =ConnectionProvider.getConnection();
            String cardnumber = cardTextfield.getText();
            String pinnumber = pinTextField.getText();

            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'and phone_num";
            try{
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                if(rs.next()){
                    String phnno="";
//                    while (rs.next()){
                        phnno = rs.getString("phone_num");
//                    }

                    setVisible(false);
                    new SendOTP_Login(phnno,pinnumber).setVisible(true);


//                    setVisible(false);
//                    new Transactions(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin ");
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SendOTP_SUOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
