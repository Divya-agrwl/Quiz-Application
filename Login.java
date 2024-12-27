package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
 JButton rules,back;
 JTextField tfname;
    Login(){
       
        
        setSize(1300,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,500);  // set bounds of label
        add(image);
        
        JLabel heading = new JLabel("Java Language Quiz");
        heading.setBounds(750,70,400,50);
       heading.setFont(new Font("Viner Hand ITC", Font.ITALIC, 40));
        heading.setForeground(new Color(30 , 144 , 254));
        add(heading);
        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(810,150,300,20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30 , 144 , 254));
        add(name);

        tfname=new JTextField();
        tfname.setBounds(735,200,300,25);
        tfname.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(tfname);
        rules = new JButton("Rules");
        rules.setBounds(735,270,120,25);
        rules.setBackground(new Color(30,154,254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(915,270,125,25);
        back.setBackground(new Color(30,154,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setLocation(0,0);
        setVisible(true);
        
       


    }

     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);

        }else if (ae.getSource() == back){
            setVisible(false);
        }
     }
    public static void main(String[] args)  {
        new Login () ;
    }
}