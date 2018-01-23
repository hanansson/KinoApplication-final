import javax.swing.*;
import java.util.ArrayList;

public class Suche {

    public void suche1 (String zeile, String eingabe, String eingabe1, String eingabe2, String eingabe3, String eingabe4, String eingabe5, Filmeintrag neuerFilmeintrag) {
        String searchChar = ";";
        String[] teile = zeile.split(searchChar);
        //suchfelder stehen von anfang an dort, und erscheinen nicht erst bei eingabe des vorherigen suchfeldes
        if (teile[0].toLowerCase().contains(eingabe.toLowerCase()) && teile[1].toLowerCase().contains(eingabe1.toLowerCase()) && teile[2].toLowerCase().contains(eingabe2.toLowerCase()) && teile[3].toLowerCase().contains(eingabe3.toLowerCase()) && teile[4].toLowerCase().contains(eingabe4.toLowerCase()) && teile[5].toLowerCase().contains(eingabe5.toLowerCase())) {
            zeileerstellen(zeile, neuerFilmeintrag);
        }
    }

    public void zeileerstellen (String zeile, Filmeintrag neuerFilmeintrag) {

        String[] filmeintragAttribute = zeile.split(";");

        neuerFilmeintrag.name= filmeintragAttribute[0];
        neuerFilmeintrag.genre= filmeintragAttribute[1];
        neuerFilmeintrag.kino= filmeintragAttribute[2];
        neuerFilmeintrag.datum = filmeintragAttribute[3];
        neuerFilmeintrag.zeit= filmeintragAttribute[4];
        neuerFilmeintrag.preis= filmeintragAttribute[5];
    }

    /*public void combofelderstellen (String zeile1, JComboBox FilmCombo, JComboBox GenreCombo, JComboBox KinoCombo, JComboBox ZeitCombo, JComboBox PreisCombo){

        String[] menuAttribute = zeile1.split(";");

        FilmCombo.addItem(menuAttribute[0]);
        GenreCombo.addItem(menuAttribute[1]);
        KinoCombo.addItem(menuAttribute[2]);
        ZeitCombo.addItem(menuAttribute[3]);
        PreisCombo.addItem(menuAttribute[4]);
    }*/
}
