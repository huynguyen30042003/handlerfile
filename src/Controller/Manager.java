package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Common.Algorithm;
import Common.Library;
import Model.Person;
import Views.Menu;

public class Manager extends Menu<String> {
    static String[] options = { "Find person info", "Copy Text to new file", "Exit" };

    Algorithm algorithm = new Algorithm();
    ArrayList<Person> dataPerson = new ArrayList<>();

    public Manager() {
        super("========== File Processing =========", options);
    }

    @Override
    public void execute(int n) throws IOException {
        switch (n) {
            case 1:
                algorithm.findPersonInfo(dataPerson);
                algorithm.MaxMin(dataPerson);
                break;
            case 2:
                // String fileName = Library.validString("Enter name file");
                // String fileName = "output.txt";
                // boolean copySuccessful = algorithm.copyWordOneTimes(fileName, "destination.txt");
                // if (copySuccessful) {
                //   System.out.println("Successfully copied words to destination file.");
                // }
                // break;

                try {
                    String sourcePath = Library.validString("Enter the source file path: ");
                    
                    String destinationPath = Library.validString("Enter the destination file path: ");
                    
                    boolean copySuccessful = algorithm.copyWordOneTimes(sourcePath, destinationPath);
                    
                    if (copySuccessful) {
                      System.out.println("Successfully copied words to destination file.");
                    }
                  } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                  }
            case 3:
                System.exit(0);
        }

    }

    public static void main(String[] args) throws IOException {
        new Manager().run();
    }
}
