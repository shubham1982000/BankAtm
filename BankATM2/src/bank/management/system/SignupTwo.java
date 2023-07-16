package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Statement;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

import com.toedter.calendar.JDateChooserCellEditor;
//import static com.sun.glass.ui.Cursor.setVisible;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField pan,addhar;

    JButton next;

    JRadioButton syes,sno,eyes,eno;

    JComboBox religion,category,occupation,income,education;

    String formno,phnno;

    SignupTwo(String formno,String phnno){
        this.formno = formno;
        this.phnno = phnno;
        setLayout(null);

        setTitle("New ACCOUNT APPLICATION FORM - PAGE 2");


        JLabel additionalDetails = new JLabel("page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway" ,Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        //******************************************************************
        JLabel name = new JLabel("Religion : ");
        name.setFont(new Font("Raleway" ,Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        //******************************************************************
        String valCategory[] = {"General","OBC","SC","ST","Other"};
         category = new JComboBox<>(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel fname = new JLabel("Category : ");
        fname.setFont(new Font("Raleway" ,Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        //******************************************************************

        String incomeCategory[] = {"Null","< 1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
         income = new JComboBox<>(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel dob = new JLabel("Income : ");
        dob.setFont(new Font("Raleway" ,Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        //******************************************************************


        JLabel gender = new JLabel("Educational  ");
        gender.setFont(new Font("Raleway" ,Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        JLabel email = new JLabel("Qualification : ");
        email.setFont(new Font("Raleway" ,Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String educationValues[] = {"Non-Graduation","Graduation","Post-Graduation","Phd","Others"};
         education = new JComboBox<>(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);


        //******************************************************************
        String occupationValues[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
         occupation = new JComboBox<>(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel marital = new JLabel("Occupation : ");
        marital.setFont(new Font("Raleway" ,Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        //******************************************************************
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel address = new JLabel("Pan no : ");
        address.setFont(new Font("Raleway" ,Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        //******************************************************************
        addhar = new JTextField();
        addhar.setFont(new Font("Raleway", Font.BOLD,14));
        addhar.setBounds(300,490,400,30);
        add(addhar);

        JLabel city = new JLabel("Addhar no : ");
        city.setFont(new Font("Raleway" ,Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        //******************************************************************
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup smaritalgroup = new ButtonGroup();
        smaritalgroup.add(syes);
        smaritalgroup.add(sno);


        JLabel state = new JLabel("Sinior Citizion : ");
        state.setFont(new Font("Raleway" ,Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        //******************************************************************
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);

        JLabel pincode = new JLabel("Exesting Account : ");
        pincode.setFont(new Font("Raleway" ,Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        //******************************************************************
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD ,14));
        next.setBounds(620 ,660, 80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 850);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen ="No";
        }

        String exestingaccount = null;
        if(eyes.isSelected()){
            exestingaccount = "Yes";
        } else if (eno.isSelected()) {
            exestingaccount = "No";
        }

        String span = pan.getText();
        String saddhar = addhar.getText();

        try{
//                Conn con = new Conn();
                String query  = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saddhar+"', '"+seniorcitizen+"', '"+exestingaccount+"')";
//                stmt.executeUpdate(query);
                Connection con =ConnectionProvider.getConnection();
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.executeUpdate();

                setVisible(false);
                new SignupThree(formno,phnno).setVisible(true);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("","");
    }
}
