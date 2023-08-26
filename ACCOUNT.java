package ATM;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ACCOUNT {
    public static void main() {
        try {
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

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 420, 105);
            panel.setBackground(Color.BLUE);
            panel.setVisible(true);
            frame.add(panel);

//            AtmManage at = new AtmManage();
            File User = new File(LOGIN.name + ".txt");
            Scanner scan = new Scanner(User);
            String StringAmount = scan.nextLine();
            int ACCBalance = Integer.parseInt(StringAmount);

            JLabel label = new JLabel("Current Account Balance: " + ACCBalance);
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Arial", Font.BOLD, 15));
            label.setBounds(15, 20, 400, 100);
            panel.add(label);


            JButton Bck = new JButton("Back");
            Bck.setBounds(300, 320, 100, 40);
            frame.add(Bck);
            Bck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    MENU.main();
                }
            });

            frame.setVisible(true);
        }catch (Exception e){
            System.out.println(e);
            //ACCOUNT.main();
        }

    }
}
