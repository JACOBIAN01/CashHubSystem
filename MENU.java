package ATM;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MENU {
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

            JLabel menu = new JLabel("MENU");
            menu.setBounds(130, 15, 200, 100);
            menu.setFont(new Font("Arial", Font.BOLD, 35));
            menu.setForeground(Color.WHITE);
            frame.add(menu);


            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 420, 105);
            panel.setBackground(Color.BLUE);
            panel.setVisible(true);
            frame.add(panel);

            JPanel panel2 = new JPanel();
            panel2.setBounds(0, 370, 420, 50);
            panel2.setBackground(Color.CYAN);
            panel2.setVisible(true);
            panel2.setOpaque(true);
            frame.add(panel2);

        LOGIN lg=new LOGIN();
        JLabel label4=new JLabel();
        label4.setText("WELCOME "+lg.name);
        label4.setBounds(20,10,350,100);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Arial",Font.ITALIC,18));
        label4.setVisible(true);

        panel.add(label4);

            JButton ACb = new JButton("Check BALANCE");
            ACb.setBounds(10, 120, 150, 50);

            JButton Depb = new JButton("Deposit Money");
            Depb.setBounds(220, 200, 150, 50);
            ACb.setVisible(true);

            JButton wB = new JButton("Withdraw Money");
            wB.setBounds(220, 120, 150, 50);
            wB.setVisible(true);

            JButton MSB = new JButton("View Mini Statement");
            MSB.setBounds(10, 200, 150, 50);
            MSB.setVisible(true);

            JButton Ex=new JButton("EXIT");
            Ex.setBounds(220, 300, 150, 50);
            Ex.setVisible(true);

            JButton BankTransfer=new JButton("Money Transfer");
           BankTransfer.setBounds(10, 300, 150, 50);
           BankTransfer.setVisible(true);




            frame.add(ACb);
            frame.add(Depb);
            frame.add(wB);
            frame.add(MSB);
            frame.add(Ex);
            frame.add(BankTransfer);

            wB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    WMoney wm=new WMoney();
                    wm.main();
                }

            });

        Depb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DMoney dm=new DMoney();
                dm.main();
            }
        });
        ACb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ACCOUNT ac=new ACCOUNT();
                ac.main();
            }

        });
MSB.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        MiniSt ms=new MiniSt();
        ms.main();
    }
});
Ex.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        MiniSt.mini=" ";
        LOGIN l=new LOGIN();
        l.main();
    }
});
BankTransfer.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        FileData.main();
    }
});
        frame.setVisible(true);
    }
}






