import java.io.*;

public class ListenVerwaltung {

    String ergebnisaufnahme() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Ergebnisliste.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int i = 0;
            while (line != null && i < 20) {
                    i ++;
                    sb.append(line);
                    line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    //

    String favoritenaufnahme() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Favoritenliste.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    public void writeToErgebnisliste(String s1) {

        try (FileWriter fw1 = new FileWriter("Ergebnisliste.txt", true);
             BufferedWriter bw1 = new BufferedWriter(fw1);
             PrintWriter out = new PrintWriter(bw1)) {
            out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeToFavoritenliste(String s) {
        try (FileWriter fw = new FileWriter("Favoritenliste.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void favoritenLoeschen() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("Favoritenliste.txt");
        writer.print("");
        writer.close();
    }
}
