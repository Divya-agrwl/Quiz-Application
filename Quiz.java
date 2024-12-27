package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(0, 0, 1440, 900);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(90, 450, 50, 30);
        qno.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(qno);
        
        question = new JLabel();
        question.setBounds(130, 450, 900, 20);
        question.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(question);
        
        questions[0][0] = "Which of the following option leads to the portability and security of Java?";
        questions[0][1] = "Bytecode is executed by JVM";
        questions[0][2] = "The applet makes the Java code secure and portable";
        questions[0][3]= "Use of exception handling";
        questions[0][4] = "Dynamic binding between objects";

        questions[1][0] = "Which of the following is not a Java features?";
        questions[1][1]= "Dynamic";
        questions[1][2] = "Architecture Neutral";
        questions[1][3] = "Use of pointers";
        questions[1][4] = "Object-oriented";

       questions[2][0] = "The u0021 article referred to as a";
        questions[2][1] ="Unicode escape sequence";
       questions[2][2] = " Octal escape";
        questions[2][3]="Hexadecimal";
        questions[2][4]= "Line feed";

        questions[3][0] =" _____is used to find and fix bugs in the Java programs.";
        questions[3][1] ="JVM";
        questions[3][2] =" JRE";
        questions[3][3] = "JDK";
        questions[3][4] =" JDB";

    questions[4][0]  = " Which of the following is a valid declaration of a char?";
    questions[4][1] ="char ch = '/utea'";
    questions[4][2] = "char ca = tea";
    questions[4][3]  = "char cr = \u0223";
    questions[4][4] = "char cc = itea";

    questions[5][0] = "  Which of the following is a valid long literal?";
    questions[5][1] = "ABH8097";
    questions[5][2] = "L990023";
    questions[5][3] = "904423";
    questions[5][4] = "0xnf029L";

    questions[6][0] = "What does the expression float a = 35 / 0 return?";
    questions[6][1] = "0";
    questions[6][2] = "Not a Number";
    questions[6][3] = "Infinity";
    questions[6][4] = "Run time exception";

    questions[7][0] = "Evaluate the following Java expression, if x=3, y=5, and z=10:" +" "+"++z + y++ - --y + z++ + x++" ;
    questions[7][1] = "24";
    questions[7][2] = "23";
    questions[7][3] = "20";
    questions[7][4] = " 25 ";

    questions[8][0] = "Which of the following for loop declaration is not valid?" ;
    questions[8][1] = "for ( int i = 99; i >= 0; i / 9 )" ;
    questions[8][2] = "for ( int i = 7; i <= 77; i += 7 )";
    questions[8][3] = "for ( int i = 20; i >= 2; - -i )";
    questions[8][4] = " for ( int i = 2; i <= 20; i = 2* i ) ";

    questions[9][0] = "Which method of the Class.class is used to determine the name of a class represented by the class object as a String?" ;
    questions[9][1] = "getClass()" ;
    questions[9][2] = "intern()";
    questions[9][3] = "getName()";
    questions[9][4] = "toString()";


    answers[0][1] = "Bytecode is executed by JVM";
    answers[1][1] = "Use of pointers";
    answers[2][1] = "Unicode escape sequence";
    answers[3][1] = "JDB";
    answers[4][1] = "char ch = '/utea'";
    answers[5][1] = "0xnf029L";
    answers[6][1] = "Infinity";
    answers[7][1] = "25";   
    answers[8][1] = "for ( int i = 99; i >= 0; i / 9 )";
    answers[9][1] = "getName()";

        opt1 = new JRadioButton();
        opt1.setBounds(150, 500, 700, 20);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(150, 530, 700, 20);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(150, 560, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(150, 590, 700, 20);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 20));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 600, 200, 30);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 650, 200,30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
     new Quiz("User");
    }
}