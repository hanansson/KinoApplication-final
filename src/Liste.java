/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Liste {

    public ArrayList<Filmeintrag> gesamtEinträge = new java.util.ArrayList<Filmeintrag>();
    private Favoriten merkliste;

    public void Suchen() throws IOException {

        this.merkliste = new Favoriten();

        String zeile = null;

        Filter kategorien = new Filter();
        String eingabe = kategorien.suchparameter();
        String eingabe1 = kategorien.suchparameter1();
        String eingabe2 = kategorien.suchparameter2();
        String eingabe3 = kategorien.suchparameter3();
        String eingabe4 = kategorien.suchparameter4();

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
        for (Filmeintrag f : gesamtEinträge) {
            System.out.println("Name: " + f.name + " Genre: " + f.genre + " Kino: " + f.kino + " Zeit: " + f.zeit + " Preis: " + f.preis);
        }

        for (int i=0; i < gesamtEinträge.size(); i++) {
            String s = ("Name: " + gesamtEinträge.get(i).name + " Genre: " + gesamtEinträge.get(i).genre + " Kino: " + gesamtEinträge.get(i).kino + " Zeit: " + gesamtEinträge.get(i).zeit + " Preis: " + gesamtEinträge.get(i).preis);
                int Ergebnisnummer = i;
                Ergebnisnummer ++;
                System.out.print(Ergebnisnummer + ".Ergebnis speichern: ");
                InputStreamReader isrj = new InputStreamReader(System.in);
                BufferedReader brj = new BufferedReader(isrj);
                String antwort = brj.readLine();
                if (antwort.toLowerCase().equals("ja")) {
                    merkliste.writeToFile(s);
                }
            }
    }
}
*/

