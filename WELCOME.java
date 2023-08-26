package ATM;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.File;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class WELCOME {

    public static void main(String[] args) {
        

        JFrame frame = new JFrame("WELCOME");
        frame.setPreferredSize(new Dimension(420, 420));
        frame.pack();
        Dimension Screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int CenterX=(Screensize.width-frame.getWidth())/2;
        int CenterY=(Screensize.height-frame.getHeight())/2;
        frame.setLocation(CenterX,CenterY);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("VITAP BANK");
        label1.setBounds(120, 10, 125, 35);
        label1.setFont(new Font("High Tower", Font.BOLD, 20));
        label1.setBackground(Color.BLUE);
        label1.setForeground(Color.WHITE);
        label1.setOpaque(true);
        frame.add(label1);

        ImageIcon image = new ImageIcon("C:\\Users\\SUBHADEEP GHORAI\\IdeaProjects\\ATM GUI\\Image.png");

        JLabel label4 = new JLabel();
        label4.setBounds(70, 75, 450, 210);
        label4.setOpaque(true);
        label4.setVisible(true);
        label4.setIcon(image);
        frame.add(label4);



        JLabel label2 = new JLabel("Welcome to VITAP ATM");
        label2.setBounds(90, 50, 180, 30);
        label2.setFont(new Font("Arial", Font.BOLD, 15));
        label2.setForeground(Color.BLACK);
        label2.setOpaque(true);
        frame.add(label2);

        JButton button = new JButton("LOG IN");
        button.setBounds(120, 330, 150, 45);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LOGIN.main();
            }
        });
        frame.setVisible(true);
    }
}
