package ATM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;



public class FileData {


    public void CreateFile() {
        try {
            LOGIN LG = new LOGIN();
            File User = new File(LG.name + ".txt");
            if (User.createNewFile()) {
                if (User.length() == 0)
                {
                    FileWriter FW = new FileWriter(User);
                    FW.write("0000");
                    FW.close();
                }

            } else if (User.exists() && User.length() == 0) {
                FileWriter FW = new FileWriter(User);
                FW.write("0000");
                FW.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main() {
        JFrame frame = new JFrame("MONEY TRANSFER");
        frame.setPreferredSize(new Dimension(420, 420));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        Dimension Screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int CenterX=(Screensize.width-frame.getWidth())/2;
        int CenterY=(Screensize.height-frame.getHeight())/2;
        frame.setLocation(CenterX,CenterY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("ENTER RECEIVER BANK ACCOUNT ");
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setBounds(20, 5, 300, 20);
        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setVisible(true);

        JLabel label1 = new JLabel("ENTER AMOUNT ");
        label1.setFont(new Font("Arial", Font.BOLD, 15));
        label1.setBounds(20, 235, 300, 20);
        label1.setOpaque(true);
        label1.setForeground(Color.BLUE);
        label1.setVisible(true);

        JLabel label2 = new JLabel("ACCOUNT VERIFICATION");
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        label2.setBounds(20, 100, 250, 50);
        label2.setOpaque(true);
        label2.setForeground(Color.BLUE);
        label2.setVisible(true);

        JTextField JT = new JTextField();//Account
        JT.setBounds(20, 30, 200, 30);
        JT.setVisible(true);


        JTextField JT1 = new JTextField();//Verify
        JT1.setBounds(20, 185, 300, 35);
        JT1.setForeground(Color.BLACK);
        JT1.setBackground(Color.WHITE);
        JT1.setEditable(false);
        JT1.setVisible(true);

        JTextField VerifyAccount=new JTextField();
        VerifyAccount.setBounds(20,160,300,20);
        VerifyAccount.setEditable(false);
        VerifyAccount.setVisible(true);


        JTextField JT2 = new JTextField();//Money
        JT2.setBounds(20, 260, 200, 30);
        JT2.setVisible(true);

        JButton JB = new JButton("Continue");
        JB.setBounds(250, 62, 120, 40);
        JB.setVisible(true);

        JButton JB1 = new JButton("CONFIRM");
        JB1.setBounds(250, 300, 120, 40);
        JB1.setVisible(true);

        JButton JB2=new JButton("Back");
        JB2.setBounds(20,300,120,40);
        JB2.setVisible(true);



        JB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
try{
        Collection<Integer>AccountNumber=LOGINBASE.CO.values();

        int ReceiverAccountNumber= Integer.parseInt(JT.getText());
        for(Integer Account:AccountNumber) {
            if (ReceiverAccountNumber == Account) {
                String NewName = LOGINBASE.CM.get(ReceiverAccountNumber);
                File NewUser = new File(NewName + ".txt");
            }else{
                JT1.setText("  Please Enter Valid Account Number!");
            }
        }
    String NewName = LOGINBASE.CM.get(ReceiverAccountNumber);
    File NewUser = new File(NewName + ".txt");
        if(NewUser.exists()){
            JT1.setText("           "+NewName);
            VerifyAccount.setText("                   ACCOUNT VERIFIED");
            VerifyAccount.setFont(new Font("Bold",Font.BOLD,15));
            JT1.setFont(new Font("Bold",Font.BOLD,18));
            JT1.setEditable(false);
            JT1.setForeground(Color.GREEN);
            VerifyAccount.setForeground(Color.GREEN);
            }

        else{
            VerifyAccount.setText("                  ACCOUNT NOT FOUND!!");
            VerifyAccount.setFont(new Font("Bold",Font.BOLD,15));
            VerifyAccount.setForeground(Color.RED);
            JT1.setFont(new Font("Bold",Font.BOLD,14));
            JT1.setText("Please Enter valid Account Details");
            JT1.setForeground(Color.RED);
            JT1.setEditable(false);
        }
}catch(NumberFormatException ex){

    JOptionPane.showMessageDialog(null,"INVALID ACCOUNT NUMBER");

}
            }
        });

        JB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int ReceiverAccountNumber= Integer.parseInt(JT.getText());
                    String NewName = LOGINBASE.CM.get(ReceiverAccountNumber);
                    File NewUser = new File(NewName + ".txt");
                    File User = new File(LOGIN.name+ ".txt");
                    Scanner NewScan=new Scanner(NewUser);
                    String ReceiveStringMoney=NewScan.nextLine();
                    int ReceiveIntMoney=Integer.parseInt(ReceiveStringMoney);

                    int SendAmount=Integer.parseInt(JT2.getText());
                    Scanner Sc=new Scanner(User);
                    String SenderStringMoney=Sc.nextLine();
                    int SenderIntMoney=Integer.parseInt(SenderStringMoney);

                    if(SendAmount<=SenderIntMoney) {
                        int NewBalance = SenderIntMoney - SendAmount;
                        int UpdateBalance = ReceiveIntMoney + SendAmount;
                        JOptionPane.showMessageDialog(null, "Amount Successfully Transferred","Transaction Status",Font.BOLD);
                        String NewAmountString = Integer.toString(NewBalance);
                        String NewReceivedAmountString = Integer.toString(UpdateBalance);
                        BufferedWriter writer = new BufferedWriter(new FileWriter(User));
                        writer.write(NewAmountString);
                        writer.close();
                        BufferedWriter Newwriter = new BufferedWriter(new FileWriter(NewUser));
                        Newwriter.write(NewReceivedAmountString);
                        Newwriter.close();
                        MiniSt ms = new MiniSt();
                        ms.mini = ms.mini + " Amount Send To " +NewName+" "+ Integer.parseInt(JT2.getText()) + "\n";
                    }else{
                        JOptionPane.showMessageDialog(null, "Transaction Error","Transaction Status",Font.BOLD);
                    }
                }catch (Exception exp){
                    JOptionPane.showMessageDialog(null, "Invalid Transaction","Transaction Status",Font.BOLD);
                }
            }
        });
        JB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                MENU.main();
            }
        });

        frame.add(JB2);
        frame.add(JB);
        frame.add(JB1);
        frame.add(JT);
        frame.add(JT1);
        frame.add(JT2);
        frame.add(VerifyAccount);
        frame.add(label);
        frame.add(label1);
        frame.add(label2);
        frame.setVisible(true);
    }
}




