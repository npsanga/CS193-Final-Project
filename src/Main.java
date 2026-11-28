import java.lang.IO;

public class Main {
    public void main() {
        Integer input;
        Double time;
        String date;
        Double actualLength;
        Double difference;
        DataManagement dm = new DataManagement("sessions.csv");
        dm.writeToFile(0.0, "", 0.0, 0.0);
        dm.readFromFile();

        while (true) {
            while (true) {
                try {
                input = Integer.parseInt(IO.readln("New Session [1]\nView Sessions [2]\nExit [3]\n"));
                if (input < 1 || input > 3) {
                    IO.println("Invalid");
                } else {
                    break;
                }
                } catch (NumberFormatException | NullPointerException e) {
                    IO.println("Invalid");
                }
            }
            if (input == 1) {
                while (true) {
                    try {
                        time = Double.parseDouble(IO.readln("Enter session time in minutes:\n"));
                        date = IO.readln("Enter session date:\n");
                        actualLength = Double.parseDouble(IO.readln("Enter actual session length in minutes:\n"));
                        difference = time - actualLength;
                        dm.writeToFile(time, date, actualLength, difference);
                        break;
                    } catch (NumberFormatException | NullPointerException e) {
                        IO.println("Invalid");
                    }
                }
            } else if (input == 2) {
                dm.displayData();
            } else {
                IO.println("Thank you for using screen time session tracker :)");
                break;
            }
        }
    }
}