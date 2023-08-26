package ATM;
import java.io.BufferedWriter;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Map;
import java.util.Scanner;

public class DMoney {
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

        JLabel dlabel=new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT: ");
        dlabel.setBounds(30,50,300,20);
        frame.add(dlabel);

        JTextField Dtxt=new JTextField();
        Dtxt.setBounds(30,80,200,40);
        frame.add(Dtxt);

        JButton Dbtn=new JButton("Continue");
        Dbtn.setBounds(170,150,120,40);
        frame.add(Dbtn);

        JButton Bck=new JButton("Back");
        Bck.setBounds(30,150,100,40);
        frame.add(Bck);

    Dbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                File User=new File(LOGIN.name+".txt");
                Scanner scan=new Scanner(User);
                String StringAmount=scan.nextLine();
                int OldBalance=Integer.parseInt(StringAmount);

                int Amount = Integer.parseInt(Dtxt.getText());
                int NewBalance = OldBalance+Amount;

                BufferedWriter writer=new BufferedWriter(new FileWriter(User));
                String NumberString=Integer.toString(NewBalance);
                writer.write(NumberString);



                JOptionPane.showMessageDialog(null, "Money Deposited Successfully", "VIT BANK", JOptionPane.PLAIN_MESSAGE);
                //AtmManage at=new AtmManage();
               // at.ministmt.put((double) Integer.parseInt(Dtxt.getText()), " Amount Deposited");

                MiniSt.mini = MiniSt.mini + " Amount Deposited: " + Integer.parseInt(Dtxt.getText()) + "\n";

                writer.close();
                frame.dispose();
                MENU.main();
            }catch(Exception ex){
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "Please Enter Valid Amount", "VIT BANK", JOptionPane.PLAIN_MESSAGE);}
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
