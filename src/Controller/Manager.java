package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Common.Algorithm;
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

                break;
            case 3:
                System.exit(0);
        }

    }

    public static void main(String[] args) throws IOException {
        new Manager().run();
    }
}
