package ATM;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.io.File;

public class MiniSt {
    static String mini="";

    public static void main() {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(420, 420));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        Dimension Screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int CenterX=(Screensize.width-frame.getWidth())/2;
        int CenterY=(Screensize.height-frame.getHeight())/2;
        frame.setLocation(CenterX,CenterY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JLabel label=new JLabel("Your Transaction History");
        label.setBounds(80,10,300,20);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial",Font.BOLD,15));
        label.setOpaque(true);
        label.setLayout(null);
        label.setVisible(true);
        frame.add(label);


        JTextArea ta=new JTextArea();
        ta.setBounds(20,30,350,280);
        ta.setEditable(false);
        frame.add(ta);

        JTextArea ta2=new JTextArea();
        ta2.setText(mini);
        ta2.setBounds(3,80,350,80);
        ta2.setEditable(false);
        ta.add(ta2);


        JLabel label1=new JLabel("VITAP BANK");
        label1.setBounds(120,1,80,20);
        label1.setVisible(true);
        ta.add(label1);


        LOGIN lg=new LOGIN();
        JLabel label3=new JLabel("Account Number: "+lg.AccountNumber);
        label3.setBounds(3,18,180,15);
        label3.setVisible(true);
        ta.add(label3);


      LocalDate LD=LocalDate.now();
        JLabel label4=new JLabel("Date:"+LD);
        label4.setBounds(3,34,150,15);
        label4.setVisible(true);
        ta.add(label4);

        LocalTime LT=LocalTime.now();
        JLabel label5=new JLabel("Time:"+LT);
        label5.setBounds(3,51,150,13);
        label5.setVisible(true);
        ta.add(label5);


        JLabel label6=new JLabel("Receipt No: "+ (int) (Math.random() * 1000));
        label6.setBounds(3,65,150,13);
        label6.setVisible(true);
        ta.add(label6);



        JButton button=new JButton("Back");
        button.setBounds(220,320,100,50);
       frame.add(button);

       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
               MENU mn=new MENU();
               mn.main();

           }
       });
       frame.setVisible(true);
    }
}
