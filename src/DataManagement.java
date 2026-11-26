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

    public String fileName() {
        return fileName;
    }

    public void writeToFile(Double time, String date, Double actualLength, Double difference) {
        if (time == 0 && date.equals("") && actualLength == 0 && difference == 0) {
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
                pw.println(time + "," + date + "," + actualLength + "," + difference);
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
    
    public void displayData() {
        int i = 1;
        if (data.isEmpty()) {
            IO.println("No available sessions to view");
        }
        for (String s : data) {
            String[] parts = s.split(",");
            if (i == 1) {
                IO.println("=============================================");
            }
            IO.println("Session: " + i);
            IO.println("Desired Session Length: " + parts[0] + " minutes");
            IO.println("Session Date: " + parts[1]);
            IO.println("Actual Session Length: " + parts[2] + " minutes");
            double difference = Double.parseDouble(parts[3]);
            if (difference < 0) {
                IO.println(Math.abs(difference) + " minutes over expected length :(");
            } else if (difference > 0){
                IO.println(Math.abs(difference) + " minutes under expected length :)");
            } else if (Math.abs(difference) < 1){
                IO.println("Session length was close enough | Good job!");
            } else {
                IO.println("Session length was exactly as expected | Good job!");
            }
            IO.println("=============================================");
            i++;
        }
    }
}
