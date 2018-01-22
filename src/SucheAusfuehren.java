import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class SucheAusfuehren {

    private JButton suchenButton;
    private JTextField NameFeld;
    public JPanel saPanel;
    private JTextField GenreFeld;
    private JTextField KinoFeld;
    private JTextField PreisFeld;
    private JTextField ZeitFeld;
    private JButton zurückButton;
    private Hauptmenu hm1;
    private Suchergebnisse se1;

    public ArrayList<Filmeintrag> gesamtEinträge = new java.util.ArrayList<Filmeintrag>();
    private Favoriten merkliste;
    Filter kategorien = new Filter();

    public void sucheAusfuehren(JFrame frame) {

        this.se1 = new Suchergebnisse();
        this.hm1 = new Hauptmenu(frame);
        this.merkliste = new Favoriten();

        suchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gesamtEinträge.clear();

                File er = new File("Ergebnisse.txt");
                if (er.exists()) {
                    er.delete();
                }

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Ergebnisse.txt"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                String zeile = null;

                String eingabe = NameFeld.getText();
                String eingabe1 = GenreFeld.getText();
                String eingabe2 = KinoFeld.getText();
                String eingabe3 = ZeitFeld.getText();
                String eingabe4 = PreisFeld.getText();

                try {
                    BufferedReader brx = new BufferedReader(new FileReader("filmdaten.txt"));
                    while (brx.ready()) {
                        if ((zeile = brx.readLine()) != null) {
                            Filmeintrag neuerFilmeintrag = new Filmeintrag();
                            Suche s = new Suche();
                            s.suche1(zeile, eingabe, eingabe1, eingabe2, eingabe3, eingabe4, neuerFilmeintrag);
                            if (neuerFilmeintrag.name != null) {
                                //random Bedingung ...geht sicherlich auch schöner.
                                gesamtEinträge.add(neuerFilmeintrag);
                            }
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                for (int i = 0; i < gesamtEinträge.size(); i++) {
                    String s1 = ("Name: " + gesamtEinträge.get(i).name + " Genre: " + gesamtEinträge.get(i).genre + " Kino: " + gesamtEinträge.get(i).kino + " Zeit: " + gesamtEinträge.get(i).zeit + " Preis: " + gesamtEinträge.get(i).preis);
                    merkliste.writeToFile1(s1);
                }
                    String ergebnisse = "Keine Filme gefunden.";
                try {
                    ergebnisse=kategorien.ergebnisaufnahme();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                frame.setContentPane(se1.sePanel);
                se1.ergebnisanzeigen(ergebnisse, frame);
                frame.invalidate();
                frame.validate();
            }
        });

        zurückButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(hm1.hmPanel);
                frame.invalidate();
                frame.validate();
            }
        });

    }
}

