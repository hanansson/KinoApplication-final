import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Favoriten {
    private JTextArea FlFeld;
    public JPanel flPanel;
    private JButton loeschenButton;
    private JButton zurückButton;
    private Hauptmenu hm1;
    ListenVerwaltung liste = new ListenVerwaltung();
    private ListenVerwaltung m1;

    public void favoritenlisteFunktionen(JFrame frame) {

        flPanel.setPreferredSize(flPanel.getPreferredSize());

        this.hm1 = new Hauptmenu(frame);
        this.m1 = new ListenVerwaltung();
        String gespeicherteFavoriten = null;
        try {
            gespeicherteFavoriten = liste.favoritenaufnahme();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        FlFeld.setText(gespeicherteFavoriten);


        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    m1.favoritenLoeschen();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                FlFeld.setText(null);
            }
        });

        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(hm1.hmPanel);
                hm1.hmPanel.setPreferredSize(hm1.hmPanel.getPreferredSize());
                frame.setSize(400, 300);
                frame.invalidate();
                frame.validate();
            }
        });
    }
}
