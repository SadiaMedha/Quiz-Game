package com.mycompany.quizgame;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class QuizGame implements ActionListener
{
    JFrame fr;
    JRadioButton rb1,rb2,rb3,rb4;
    JButton b1,b2;
    JLabel lb1,lb2;
    ButtonGroup bg;
    String ques[]={"Who developed JAVA?"," Who is the author of the Harry Potter?","What is the largest planet?","Who painted Mona Lisa?","What is the capital of Italy?"};
    String op1[]={"Tim","J.R.R. Tolkien","Mars","Vincent van Gogh","Venice"};
    String op2[]={"Steve","J.K. Rowling","Jupiter","Leonardo da Vinci","Milan"};
    String op3[]={"Mark","George R.R. Martin","Earth","Pablo Picasso","Rome"};
    String op4[]={"James","C.S. Lewis","Saturn","Michelangelo","Florence"};
    String ans[]={"James","J.K. Rowling","Jupiter","Leonardo da Vinci","Rome"};
    int cn;

    public QuizGame()
    {
        fr = new JFrame();
        fr.setLayout(null);
        fr.setSize(700,500);
        
        lb1 = new JLabel(ques[0]);
        lb1.setBounds(50,50,600,100); 
        lb1.setFont(new Font("default",Font.BOLD,30));
        fr.add(lb1);
                
        rb1 = new JRadioButton(op1[0]);
        rb1.setBounds(100,150,150,30);
        fr.add(rb1);
        
        rb2 = new JRadioButton(op2[0]);
        rb2.setBounds(300,150,150,30);
        fr.add(rb2);
        
        rb3 = new JRadioButton(op3[0]);
        rb3.setBounds(100,200,150,30);
        fr.add(rb3);
        
        rb4 = new JRadioButton(op4[0]);
        rb4.setBounds(300,200,150,30);
        fr.add(rb4);
        
        bg = new ButtonGroup();
        
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        
        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);
        rb4.addActionListener(this);
        
        b1 = new JButton("Sumbit");
        b1.setBounds(150,350,100,30);
        fr.add(b1);
        
        b2 = new JButton("Next");
        b2.setBounds(280,350,100,30);
        fr.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        fr.setVisible(true);        
    } 
    
    public static void main(String[] args)    
    {
        new QuizGame();
    }
    
    class GenericClass<E> 
    {    
        private E value;    
        public void setValue(E value)    
        {        
            this.value = value;    
        }    
        public E getValue() 
        {           
            return this.value;   
        }   
    }
    
    class QuizThread implements Runnable 
    {        
        public void run()     
        {               
            Thread quizThread = new Thread(new QuizThread());        
            quizThread.start();    
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        try
        {        
            if(e.getSource()==b1)        
            {           
                String en = "";           
                if(rb1.isSelected())                
                    en = rb1.getText();            
                if(rb2.isSelected())                
                    en = rb2.getText();               
                if(rb3.isSelected())               
                    en = rb3.getText();            
                if(rb4.isSelected())                
                    en = rb4.getText();
                if(en.equals(ans[cn]))                
                    JOptionPane.showMessageDialog(null,"Right Answer");            
                else               
                    JOptionPane.showMessageDialog(null,"Wrong Answer");
            }
        }
        catch(Exception ex)
        {
           JOptionPane.showMessageDialog(fr, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (e.getSource() == b2)
        {
            cn++;
            lb1.setText(ques[cn]);
            rb1.setText(op1[cn]);
            rb2.setText(op2[cn]);
            rb3.setText(op3[cn]);
            rb4.setText(op4[cn]);
        }
    }
}