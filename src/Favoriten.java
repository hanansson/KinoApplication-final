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


    public void writeToFile(String ergebnisse) {

        try (FileWriter fw = new FileWriter("Merkliste.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(ergebnisse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(ergebnisse);
    }

    public void loeschen() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("Merkliste.txt");
        writer.print("");
        writer.close();
    }

    /*public String[][] read() throws IOException {
        List<String[]> list = new ArrayList<String[]>();
        try {
            BufferedReader read = new BufferedReader(new FileReader("Merkliste.txt"));
            String in = read.readLine();

            while (in != null) {
                String[] line = in.split(";");
                list.add(line);
                in = read.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[][] tmp = new String[list.size()][];
        return list.toArray(tmp);
    }

    public void overwrite() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Ergebnisse.txt"));
            for (int i = 0; i < gesamtEinträge.size(); i++) {
                writer.write("");
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}