import java.io.*;

public class Filter {


    String ergebnisaufnahme() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Ergebnisse.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            int i = 0;
            while (line != null && i < 20) {
                    i ++;
                    sb.append(line);
                    sb.append("\n");
                    line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    String favoritenaufnahme() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Merkliste.txt"));
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
}
