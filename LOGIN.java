package ATM;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.io.File;

public class LOGIN {
public static String name;
public static int DebitCardNo;
public static int AccountNumber;
    public static void main() {
        JFrame frame = new JFrame("VIT AP ATM");
        frame.setPreferredSize(new Dimension(420, 420));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        Dimension Screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int CenterX=(Screensize.width-frame.getWidth())/2;
        int CenterY=(Screensize.height-frame.getHeight())/2;
        frame.setLocation(CenterX,CenterY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label=new JLabel();
        label.setBounds(150,2,350,350);
        label.setVisible(true);
        frame.add(label);

        ImageIcon image=new ImageIcon("C:\\Users\\SUBHADEEP GHORAI\\IdeaProjects\\ATM GUI\\LOG IN 3.png");

        JLabel label3=new JLabel();
        label3.setBounds(180,20,250,250);
        label3.setVisible(true);
        label3.setIcon(image);
        frame.add(label3);

        JLabel label1=new JLabel("Enter Card Number");
        label1.setBounds(10,10,160,40);
        label1.setOpaque(true);
        label1.setVisible(true);
        frame.add(label1);


        JLabel label2=new JLabel("Enter PIN");
        label2.setBounds(10,100,160,40);
        label2.setOpaque(true);
        label2.setVisible(true);
        frame.add(label2);

        JTextField txt1=new JTextField();
        txt1.setVisible(true);
        txt1.setBounds(10,55,160,40);
        frame.add(txt1);

        JPasswordField txt2=new JPasswordField();
        txt2.setVisible(true);
        txt2.setBounds(10,150,160,40);
        frame.add(txt2);

        JButton cnb=new JButton("Continue");
        cnb.setBounds(240,280,120,50);
        cnb.setOpaque(true);
        cnb.setVisible(true);
        frame.add(cnb);


        JButton exb=new JButton("Exit");
        exb.setBounds(20,280,120,50);
        exb.setOpaque(true);
        exb.setVisible(true);
        frame.add(exb);

        JPanel panel2 = new JPanel();
        panel2.setBounds(0, 370, 420, 50);
        panel2.setBackground(Color.CYAN);
        panel2.setVisible(true);
        panel2.setOpaque(true);
        frame.add(panel2);

        frame.setVisible(true);

        exb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TH th=new TH();
                frame.dispose();
                TH.main();

            }});

        cnb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.dispose();
                    int DebitCardNo = Integer.parseInt(txt1.getText());
                    int PinNo = Integer.parseInt(txt2.getText());
                    LOGINBASE LB = new LOGINBASE();
                    AccountNumber = LOGINBASE.CO.get(DebitCardNo);
                    name = LOGINBASE.CM.get(AccountNumber);
                    if (LOGINBASE.CN.containsKey(DebitCardNo) && LOGINBASE.CN.get(DebitCardNo) == PinNo) {
                        FileData FD = new FileData();
                        FD.CreateFile();
                        MENU mn = new MENU();
                        MENU.main();
                    } else {
                        LOGIN lg1 = new LOGIN();
                        lg1.main();
                        JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID DETAILS", null, JOptionPane.PLAIN_MESSAGE);
                    }
                }catch (Exception ex){
                    LOGIN lg1 = new LOGIN();
                    lg1.main();
                    JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID DETAILS", null, JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }
}
