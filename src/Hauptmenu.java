import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hauptmenu extends JFrame {
    private JButton Suchbutton;
    public JPanel hmPanel;
    private JButton Favoritenbutton;
    private SucheAusfuehren sa1;
    private Favoritenliste fl1;


    public static void main (String[] args){
        JFrame frame = new JFrame("Hauptmenu");
        Hauptmenu haupt1 = new Hauptmenu(frame);
        frame.setContentPane(haupt1.hmPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setVisible(true);
    }

    public Hauptmenu(JFrame frame) {

        this.sa1 = new SucheAusfuehren();
        this.fl1 = new Favoritenliste();

        Suchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(sa1.saPanel);
                sa1.sucheAusfuehren(frame);
                frame.invalidate();
                frame.validate();
            }
        });
        Favoritenbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(fl1.flPanel);
                fl1.favoritenlisteFunktionen(frame);
                frame.invalidate();
                frame.validate();
            }
        });

    }
}
