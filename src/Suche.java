import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Suche {

    public JPanel saPanel;
    private JButton suchenButton;
    private JButton hauptmenuButton;
    private JTextField nameFeld;
    private JComboBox genreCombo;
    private JComboBox kinoCombo;
    private JComboBox preisCombo;
    private JTextField zeitFeld;
    private JComboBox datumCombo;
    private Hauptmenu hm1;
    private Suchergebnisse se1;

    public ArrayList<Filmeintrag> gesamtEinträge = new java.util.ArrayList<Filmeintrag>();
    private ListenVerwaltung liste;

    public void sucheFunktionen(JFrame frame) {

        this.se1 = new Suchergebnisse();
        this.hm1 = new Hauptmenu(frame);
        this.liste = new ListenVerwaltung();

        String zeile1 = null;

        this.genreCombo.getModel();
        this.kinoCombo.getModel();
        this.datumCombo.getModel();
        this.preisCombo.getModel();

        genreCombo.addItem("");
        kinoCombo.addItem("");
        datumCombo.addItem("");
        preisCombo.addItem("");

        try {
            BufferedReader brx1 = new BufferedReader(new FileReader("Genre.txt"));
            while (brx1.ready()) {
                if ((zeile1 = brx1.readLine()) != null) {
                    genreCombo.addItem(zeile1);
                }
            }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        try {
            BufferedReader brx1 = new BufferedReader(new FileReader("Kino.txt"));
            while (brx1.ready()) {
                if ((zeile1 = brx1.readLine()) != null) {
                    kinoCombo.addItem(zeile1);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            BufferedReader brx1 = new BufferedReader(new FileReader("Datum.txt"));
            while (brx1.ready()) {
                if ((zeile1 = brx1.readLine()) != null) {
                    datumCombo.addItem(zeile1);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            BufferedReader brx1 = new BufferedReader(new FileReader("Preis.txt"));
            while (brx1.ready()) {
                if ((zeile1 = brx1.readLine()) != null) {
                    preisCombo.addItem(zeile1);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        suchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gesamtEinträge.clear();

                File er = new File("Ergebnisliste.txt");
                if (er.exists()) {
                    er.delete();
                }

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Ergebnisliste.txt"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                String zeile = null;

                String eingabeName = nameFeld.getText();
                String eingabeGenre = (String) genreCombo.getSelectedItem();
                String eingabeKino = (String) kinoCombo.getSelectedItem();
                String eingabeDatum = (String) datumCombo.getSelectedItem();
                String eingabeZeit = zeitFeld.getText();
                String eingabePreis = (String) preisCombo.getSelectedItem();

                try {
                    BufferedReader brx = new BufferedReader(new FileReader("Kinoliste.txt"));
                    while (brx.ready()) {
                        if ((zeile = brx.readLine()) != null) {
                            Filmeintrag neuerFilmeintrag = new Filmeintrag();
                            SucheAusfuehren s = new SucheAusfuehren();
                            s.vergleichen(zeile, eingabeName, eingabeGenre, eingabeKino, eingabeDatum, eingabeZeit, eingabePreis, neuerFilmeintrag);
                            if (neuerFilmeintrag.name != null) {
                                gesamtEinträge.add(neuerFilmeintrag);
                            }
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                    for (int i = 0; i < gesamtEinträge.size(); i++) {
                        String film = ("Name: " + gesamtEinträge.get(i).name + " Genre: " + gesamtEinträge.get(i).genre + " Kino: " + gesamtEinträge.get(i).kino + " Datum: " + gesamtEinträge.get(i).datum + " Zeit: " + gesamtEinträge.get(i).zeit + " Preis: " + gesamtEinträge.get(i).preis);
                        liste.writeToErgebnisliste(film);
                    }

                String ergebnisse = null;
                try {
                    ergebnisse = liste.ergebnisaufnahme();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                if (ergebnisse.length() != 0) {
                    frame.setContentPane(se1.sePanel);
                    se1.ergebnisanzeigen(ergebnisse, frame);
                    frame.invalidate();
                    frame.validate();
                }
            }
        });

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

    }
}

