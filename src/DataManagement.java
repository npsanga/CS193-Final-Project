import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
}
