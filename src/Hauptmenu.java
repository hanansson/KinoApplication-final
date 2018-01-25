import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hauptmenu extends JFrame {
    private JButton sucheButton;
    public JPanel hmPanel;
    private JButton favoritenButton;
    private JButton beendenButton;
    private JLabel filmfinder;
    private Suche sa1;
    private Favoriten fl1;


    public static void main (String[] args){

        JFrame frame = new JFrame("Filmfinder");
        Hauptmenu haupt1 = new Hauptmenu(frame);
        frame.setContentPane(haupt1.hmPanel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Hauptmenu(JFrame frame) {

        filmfinder.setForeground(Color.GRAY);
        hmPanel.setPreferredSize(hmPanel.getPreferredSize());

        this.sa1 = new Suche();
        this.fl1 = new Favoriten();

        sucheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(sa1.saPanel);
                sa1.sucheFunktionen(frame);
                frame.setSize(400, 300);
                frame.invalidate();
                frame.validate();
            }

        });
        favoritenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(fl1.flPanel);
                fl1.favoritenlisteFunktionen(frame);
                frame.setSize(1200, 500);
                frame.invalidate();
                frame.validate();
            }
        });

        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
