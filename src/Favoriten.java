import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Favoriten {

    public ArrayList<Filmeintrag> gesamtEinträge;

    public void writeToFile1(String s1) {

        try (FileWriter fw1 = new FileWriter("Ergebnisse.txt", true);
             BufferedWriter bw1 = new BufferedWriter(fw1);
             PrintWriter out = new PrintWriter(bw1)) {
            out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeToFile(String s) {
        try (FileWriter fw = new FileWriter("Merkliste.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(ergebnisse);
    }
    /*public void loeschen() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Merkliste.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append("");
                line = br.readLine();
            }
        } finally {
            br.close();
        }
    }*/
    public void loeschen() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("Merkliste.txt");
        writer.print("");
        writer.close();
    }
}