import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Suche {

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
    //private KeineFilmeintraege kf1;

    public ArrayList<Filmeintrag> gesamtEinträge = new java.util.ArrayList<Filmeintrag>();
    private ListenVerwaltung liste;

    public void sucheFunktionen(JFrame frame) {

        this.se1 = new Suchergebnisse();
        this.hm1 = new Hauptmenu(frame);
        //this.kf1 = new KeineFilmeintraege();
        this.liste = new ListenVerwaltung();

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

                String eingabe = FilmFeld.getText();
                String eingabe1 = (String) GenreCombo.getSelectedItem();
                String eingabe2 = (String) KinoCombo.getSelectedItem();
                String eingabe3 = (String) DatumCombo.getSelectedItem();
                String eingabe4 = ZeitFeld.getText();
                String eingabe5 = (String) PreisCombo.getSelectedItem();

                try {
                    BufferedReader brx = new BufferedReader(new FileReader("Kinoliste.txt"));
                    while (brx.ready()) {
                        if ((zeile = brx.readLine()) != null) {
                            Filmeintrag neuerFilmeintrag = new Filmeintrag();
                            SucheAusfuehren s = new SucheAusfuehren();
                            s.vergleichen(zeile, eingabe, eingabe1, eingabe2, eingabe3, eingabe4, eingabe5, neuerFilmeintrag);
                            if (neuerFilmeintrag.name != null) {
                                //random Bedingung ...geht sicherlich auch schöner.
                                gesamtEinträge.add(neuerFilmeintrag);
                            }
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                /*int ii = gesamtEinträge.size();

                if(ii >= 0) {*/
                    for (int i = 0; i < gesamtEinträge.size(); i++) {
                        String s1 = ("Name: " + gesamtEinträge.get(i).name + " Genre: " + gesamtEinträge.get(i).genre + " Kino: " + gesamtEinträge.get(i).kino + " Datum: " + gesamtEinträge.get(i).datum + " Zeit: " + gesamtEinträge.get(i).zeit + " Preis: " + gesamtEinträge.get(i).preis);
                        liste.writeToErgebnisliste(s1);
                    }
                /*} else {
                    JFrame frame1 = new JFrame("Hinweis");
                    frame1.setVisible(true);
                    frame1.setContentPane(kf1.kfPanel);
                    frame1.setSize(300, 200);
                    kf1.akzeptieren(frame1);
                }*/

                String ergebnisse = "Keine Filme gefunden.";
                try {
                    ergebnisse = liste.ergebnisaufnahme();
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

