import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Suchergebnisse {
    public JTextArea ErgebnisArea;
    public JPanel sePanel;
    private JButton speichernButton;
    private JButton zurück;
    private JButton hauptmenuButton;
    private Hauptmenu hm1;
    private SucheAusfuehren sa1;
    private Favoriten merkliste;

    public void ergebnisanzeigen(String ergenbnisse, JFrame frame){

        ErgebnisArea.setText(ergenbnisse);
        frame.setSize(1200, 500);
        // zum testen, ob etwas ankommt! System.out.println(ergenbnisse);
        this.hm1 = new Hauptmenu(frame);
        this.merkliste = new Favoriten();
        this.sa1 = new SucheAusfuehren();

        hauptmenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(hm1.hmPanel);
                hm1.hmPanel.setPreferredSize(hm1.hmPanel.getPreferredSize());
                frame.setSize(400, 300);
                frame.invalidate();
                frame.validate();
            }
        });

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                merkliste.writeToFile(ergenbnisse);
            }
        });

        zurück.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(sa1.saPanel);
                frame.setSize(400, 300);
                sa1.sucheAusfuehren(frame);
                frame.invalidate();
                frame.validate();
            }
        });
    }
}