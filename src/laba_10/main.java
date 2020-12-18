package laba_10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Main extends JFrame{
    JFrame jfm=new JFrame();
    JButton plus=new JButton("+");
    JButton minus=new JButton("-");
    JButton div=new JButton("/");
    JButton mul=new JButton("*");
    JButton res=new JButton("Рассчитать");
    JButton c=new JButton("С");
    
    JTextField jta=new JTextField(50);
    JTextField jtb=new JTextField(50);
    
    JLabel jlr=new JLabel("Результат: ");
    Font font=new Font("Times new roman", Font.BOLD, 20);
    
    DecimalFormat df=new DecimalFormat("#.####");
    public char sing;
    public double x=0.0;
    public double y=0.0;
    public double r=0.0;
    
    public Main()
    {
        setLayout(null);
        jfm.setBounds(10,10,1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       plus.setBounds(300, 200, 100, 100);
       minus.setBounds(500, 200, 100, 100);
       div.setBounds(700, 200, 100, 100);
       mul.setBounds(900, 200, 100, 100);
       res.setBounds(550, 500, 200, 50);
       c.setBounds(10, 10, 100, 100);
       add(plus);
       add(minus);
       add(div);
       add(mul);
       add(res);
       add(c);
        
       jta.setBounds(550, 50, 200, 50);
       jta.setFont(font);
       add(jta);
       
       jtb.setBounds(550, 375, 200, 50);
       jtb.setFont(font);
       add(jtb);
       
       jlr.setBounds(550, 600, 200, 50);
       jlr.setFont(font);
       add(jlr);
       ///////////////////////////////////////////////////////////////////
       plus.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
             sing='+';
           }
       });
       //////////////////////////////////////////////////////////////
      minus.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
             sing='-';
           }
       });
       ///////////////////////////////////////////////////////////
       div.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
             sing='/';
           }
       });
       //////////////////////////////////////////////////////////////
       mul.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
              sing='*'; 
           }
       });
       
       
       res.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e)
                   {
                       if(!jta.getText().matches("[0-9]+")||!jtb.getText().matches("[0-9]+"))
                       {
                           System.exit(0);
                       }
                      x=Double.parseDouble(jta.getText());
                      y=Double.parseDouble(jtb.getText());
                      switch (sing)
                      {
                          case '+': r=x+y;
                          break;
                          case '-': r=x-y;
                          break;
                          case '/': 
                          {
                              if(y==0.0)
                              {
                                  System.exit(0);
                              }
                              else r=x/y;
                          }
                          break;
                          case '*': r=x*y;
                          break;
                      }
                      jlr.setText("Результат: "+df.format(r));
                   }
               });
       c.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
              jta.setText(null);
              jtb.setText(null);
              jlr.setText("Результат: ");
           }
       });
    }
    public static void main(String[] args) 
    {
      Main m=new Main();
      m.setVisible(true);
    }
}
