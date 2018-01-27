public class SucheAusfuehren {

    public void vergleichen(String zeile, String eingabeName, String eingabeGenre, String eingabeKino, String eingabeDatum, String eingabeZeit, String eingabePreis, Filmeintrag neuerFilmeintrag) {

        String[] filmeintragAttribute = zeile.split(";");
        if (filmeintragAttribute[0].toLowerCase().contains(eingabeName.toLowerCase()) && filmeintragAttribute[1].contains(eingabeGenre) && filmeintragAttribute[2].contains(eingabeKino) && filmeintragAttribute[3].contains(eingabeDatum) && filmeintragAttribute[4].contains(eingabeZeit) && filmeintragAttribute[5].contains(eingabePreis)) {
            eintragerstellen(neuerFilmeintrag, filmeintragAttribute);
        }
    }

    public void eintragerstellen(Filmeintrag neuerFilmeintrag, String[] filmeintragAttribute) {

        neuerFilmeintrag.name = filmeintragAttribute[0];
        neuerFilmeintrag.genre = filmeintragAttribute[1];
        neuerFilmeintrag.kino = filmeintragAttribute[2];
        neuerFilmeintrag.datum = filmeintragAttribute[3];
        neuerFilmeintrag.zeit = filmeintragAttribute[4];
        neuerFilmeintrag.preis = filmeintragAttribute[5];
    }
}
