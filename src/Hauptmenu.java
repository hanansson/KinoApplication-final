import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hauptmenu extends JFrame {
    private JButton Suchbutton;
    public JPanel hmPanel;
    private JButton Favoritenbutton;
    private JButton Beendenbutton;
    private SucheAusfuehren sa1;
    private Favoritenliste fl1;


    public static void main (String[] args){
        JFrame frame = new JFrame("Hauptmenu");
        Hauptmenu haupt1 = new Hauptmenu(frame);
        frame.setContentPane(haupt1.hmPanel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Hauptmenu(JFrame frame) {

        hmPanel.setPreferredSize(hmPanel.getPreferredSize());

        this.sa1 = new SucheAusfuehren();
        this.fl1 = new Favoritenliste();

        Suchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(sa1.saPanel);
                sa1.sucheAusfuehren(frame);
                frame.setSize(400, 300);
                frame.invalidate();
                frame.validate();
            }
        });
        Favoritenbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(fl1.flPanel);
                fl1.favoritenlisteFunktionen(frame);
                frame.setSize(1200, 500);
                frame.invalidate();
                frame.validate();
            }
        });

        Beendenbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
