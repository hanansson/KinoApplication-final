import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Favoritenliste {
    private JTextArea FlFeld;
    public JPanel flPanel;
    private JButton loeschenButton;
    private JButton zurückButton;
    private Hauptmenu hm1;
    Filter kategorien = new Filter();
    private Favoriten m1;

    public void favoritenlisteFunktionen(JFrame frame) {

        flPanel.setPreferredSize(flPanel.getPreferredSize());

        this.hm1 = new Hauptmenu(frame);
        this.m1 = new Favoriten();
        // String gespeichertefavoriten = "Keine Favoriten";
        String gespeichertefavoriten = null;
        try {
            gespeichertefavoriten = kategorien.favoritenaufnahme();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        FlFeld.setText(gespeichertefavoriten);


        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    m1.loeschen();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
               // String keinefavoriten = "Keine Favoriten";
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
