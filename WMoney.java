package ATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.Scanner;

public class WMoney
{
    public static void main()
    {
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


        JTextField jt=new JTextField();
        jt.setBounds(10,121,300,50);
        jt.setBackground(Color.WHITE);
        jt.setVisible(true);
        frame.add(jt);

        JLabel Wmoney = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW ");
        Wmoney.setBounds(5, 20, 400, 100);
        Wmoney.setFont(new Font("Arial", Font.BOLD, 15));
        frame.add(Wmoney);

        JButton Bck=new JButton("Back");
        Bck.setBounds(20,320,100,40);
        frame.add(Bck);

        JButton cnb=new JButton("Continue");
        cnb.setBounds(300,320,100,40);
        frame.add(cnb);




        cnb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                AtmManage at = new AtmManage();
                    File User=new File(LOGIN.name+".txt");
                    Scanner Scan=new Scanner(User);
                    String AmountString=Scan.nextLine();
                    int Amount = Integer.parseInt(jt.getText());
                    int AmountInteger=Integer.parseInt(AmountString);
                if (Amount > AmountInteger) {
                    JOptionPane.showMessageDialog(null, "You have insufficient Balance", null, JOptionPane.PLAIN_MESSAGE);
                } else if (Amount != 0 && ((Amount % 500 == 0) || (Amount % 200 == 0) || (Amount % 100 == 0))) {

                    int NewBalance =AmountInteger- Amount;
                    String AmountStringNew=Integer.toString(NewBalance);
                    BufferedWriter writer=new BufferedWriter(new FileWriter(User));
                    writer.write(AmountStringNew);

                    JOptionPane.showMessageDialog(null, "Money Withdrawal Successfully\n Collect your amount", null, JOptionPane.PLAIN_MESSAGE);

                    MiniSt ms = new MiniSt();
                    ms.mini = ms.mini + " Amount Withdrawn: " + Amount + "\n";
                    writer.close();

                } else if (Amount == 0) {
                    JOptionPane.showMessageDialog(null, "Please Enter  Valid Amount", null, JOptionPane.PLAIN_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter the amount multiple of 500 , 200 or 100 only", null, JOptionPane.PLAIN_MESSAGE);
                }

                frame.dispose();

                MENU.main();
            }catch(Exception ex1){JOptionPane.showMessageDialog(null, "Please Enter Valid Amount", "VIT BANK", JOptionPane.PLAIN_MESSAGE);}
            }
        });


        Bck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MENU.main();
            }
        });


        frame.setVisible(true);
    }
}

