public class SucheAusfuehren {

    public void vergleichen (String zeile, String eingabe, String eingabe1, String eingabe2, String eingabe3, String eingabe4, String eingabe5, Filmeintrag neuerFilmeintrag) {

        String[] filmeintragAttribute = zeile.split(";");
        if (filmeintragAttribute[0].toLowerCase().contains(eingabe.toLowerCase()) && filmeintragAttribute[1].toLowerCase().contains(eingabe1.toLowerCase()) && filmeintragAttribute[2].toLowerCase().contains(eingabe2.toLowerCase()) && filmeintragAttribute[3].toLowerCase().contains(eingabe3.toLowerCase()) && filmeintragAttribute[4].toLowerCase().contains(eingabe4.toLowerCase()) && filmeintragAttribute[5].toLowerCase().contains(eingabe5.toLowerCase())) {
            eintragerstellen(neuerFilmeintrag, filmeintragAttribute);
        }
    }

    public void eintragerstellen (Filmeintrag neuerFilmeintrag, String[] filmeintragAttribute) {

        neuerFilmeintrag.name= filmeintragAttribute[0];
        neuerFilmeintrag.genre= filmeintragAttribute[1];
        neuerFilmeintrag.kino= filmeintragAttribute[2];
        neuerFilmeintrag.datum = filmeintragAttribute[3];
        neuerFilmeintrag.zeit= filmeintragAttribute[4];
        neuerFilmeintrag.preis= filmeintragAttribute[5];
    }
}
