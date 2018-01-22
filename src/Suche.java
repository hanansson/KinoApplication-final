import java.util.ArrayList;

public class Suche {

    public void suche1 (String zeile, String eingabe, String eingabe1, String eingabe2, String eingabe3, String eingabe4, Filmeintrag neuerFilmeintrag) {
        String searchChar = ";";
        String[] teile = zeile.split(searchChar);
        //suchfelder stehen von anfang an dort, und erscheinen nicht erst bei eingabe des vorherigen suchfeldes
        if (teile[0].toLowerCase().contains(eingabe.toLowerCase()) && teile[1].toLowerCase().contains(eingabe1.toLowerCase()) && teile[2].toLowerCase().contains(eingabe2.toLowerCase()) && teile[3].toLowerCase().contains(eingabe3.toLowerCase()) && teile[4].toLowerCase().contains(eingabe4.toLowerCase())) {
            zeileerstellen(zeile, neuerFilmeintrag);
        }
    }

    public void zeileerstellen (String zeile, Filmeintrag neuerFilmeintrag) {

        String[] filmeintragAttribute = zeile.split(";");

        neuerFilmeintrag.name= filmeintragAttribute[0];
        neuerFilmeintrag.genre= filmeintragAttribute[1];
        neuerFilmeintrag.kino= filmeintragAttribute[2];
        filmeintragAttribute[3] = filmeintragAttribute[3].substring(filmeintragAttribute[3].indexOf("§") +1, filmeintragAttribute[3].indexOf("$"));
        neuerFilmeintrag.zeit= filmeintragAttribute[3];
        neuerFilmeintrag.preis= filmeintragAttribute[4];
    }
}
