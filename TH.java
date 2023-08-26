package ATM;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.io.File;
public class TH {

    public static void main() {
        JFrame frame = new JFrame("VITAP ATM");
        frame.setPreferredSize(new Dimension(420, 420));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        Dimension Screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int CenterX=(Screensize.width-frame.getWidth())/2;
        int CenterY=(Screensize.height-frame.getHeight())/2;
        frame.setLocation(CenterX,CenterY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        ImageIcon image=new ImageIcon("C:\\Users\\SUBHADEEP GHORAI\\IdeaProjects\\ATM GUI\\th2.png");

        JLabel label=new JLabel();
        label.setBounds(30,40,320,350);
        label.setIcon(image);
        label.setVisible(true);
        label.setLayout(null);
        frame.add(label);

        JLabel label1=new JLabel("THANK YOU");
        label1.setBounds(100,10,250,90);
        label1.setFont(new Font("Arial",Font.BOLD,30));
        label1.setVisible(true);
        label1.setLayout(null);
        frame.add(label1);

        frame.setVisible(true);

    }
}


