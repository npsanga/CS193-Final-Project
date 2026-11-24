import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataManagement {
    private ArrayList<String> data;
    String fileName;

    public DataManagement(String fileName) {
        this.fileName = fileName;
        data = new ArrayList<>();
    }

    public void addData(Double time, String date, Double actualLength, Double difference) {
        this.data.add(time + "," + date + "," + actualLength + "," + difference);
    }

    public void writeToFile() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for (String s : data) {
                pw.println(s);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
