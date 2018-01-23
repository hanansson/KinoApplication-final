import org.w3c.dom.Attr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class SucheAusfuehren {

    private JButton suchenButton;
    public JPanel saPanel;

    private JButton zurückButton;
    private JTextField FilmFeld;
    private JComboBox GenreCombo;
    private JComboBox KinoCombo;
    private JComboBox PreisCombo;
    private JTextField ZeitFeld;
    private JComboBox DatumCombo;
    private Hauptmenu hm1;
    private Suchergebnisse se1;

    public ArrayList<Filmeintrag> gesamtEinträge = new java.util.ArrayList<Filmeintrag>();
    private Favoriten merkliste;
    Filter kategorien = new Filter();


    public void sucheAusfuehren(JFrame frame) {

        this.se1 = new Suchergebnisse();
        this.hm1 = new Hauptmenu(frame);
        this.merkliste = new Favoriten();

        String zeile1 = null;

        this.GenreCombo.getModel();
        this.KinoCombo.getModel();
        this.DatumCombo.getModel();
        this.PreisCombo.getModel();

        GenreCombo.addItem("");
        KinoCombo.addItem("");
        DatumCombo.addItem("");
        PreisCombo.addItem("");

        try {
            BufferedReader brx1 = new BufferedReader(new FileReader("Genre.txt"));
            while (brx1.ready()) {
                if ((zeile1 = brx1.readLine()) != null) {
                    GenreCombo.addItem(zeile1);
                }
            }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        try {
            BufferedReader brx1 = new BufferedReader(new FileReader("Kino.txt"));
            while (brx1.ready()) {
                if ((zeile1 = brx1.readLine()) != null) {
                    KinoCombo.addItem(zeile1);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            BufferedReader brx1 = new BufferedReader(new FileReader("Datum.txt"));
            while (brx1.ready()) {
                if ((zeile1 = brx1.readLine()) != null) {
                    DatumCombo.addItem(zeile1);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            BufferedReader brx1 = new BufferedReader(new FileReader("Preis.txt"));
            while (brx1.ready()) {
                if ((zeile1 = brx1.readLine()) != null) {
                    PreisCombo.addItem(zeile1);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

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

                String eingabe = FilmFeld.getText();
                String eingabe1 = (String) GenreCombo.getSelectedItem();
                String eingabe2 = (String) KinoCombo.getSelectedItem();
                String eingabe3 = (String) DatumCombo.getSelectedItem();
                String eingabe4 = ZeitFeld.getText();
                String eingabe5 = (String) PreisCombo.getSelectedItem();

                try {
                    BufferedReader brx = new BufferedReader(new FileReader("kinoliste.txt"));
                    while (brx.ready()) {
                        if ((zeile = brx.readLine()) != null) {
                            Filmeintrag neuerFilmeintrag = new Filmeintrag();
                            Suche s = new Suche();
                            s.suche1(zeile, eingabe, eingabe1, eingabe2, eingabe3, eingabe4, eingabe5, neuerFilmeintrag);
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
                    String s1 = ("Name: " + gesamtEinträge.get(i).name + " Genre: " + gesamtEinträge.get(i).genre + " Kino: " + gesamtEinträge.get(i).kino + " Datum: " + gesamtEinträge.get(i).datum + " Zeit: " + gesamtEinträge.get(i).zeit + " Preis: " + gesamtEinträge.get(i).preis);
                    merkliste.writeToFile1(s1);
                }
                String ergebnisse = "Keine Filme gefunden.";
                try {
                    ergebnisse = kategorien.ergebnisaufnahme();
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
                hm1.hmPanel.setPreferredSize(hm1.hmPanel.getPreferredSize());
                frame.setSize(400, 300);
                frame.invalidate();
                frame.validate();
            }
        });

    }
}

