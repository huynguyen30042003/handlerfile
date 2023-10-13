package Common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Model.Person;

public class Algorithm {
    public void findPersonInfo(ArrayList<Person> dataPerson) throws IOException {
        String path = Library.validString("Enter Path");
        int moneyRes = Library.validNumber("Enter Money");
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            Person person = new Person();
            String[] s = str.split(";");
            person.setName(s[0]);
            person.setAddress(s[1]);
            person.setMoney(Integer.parseInt(s[2]));
            if (moneyRes < person.getMoney()) {
                dataPerson.add(person);
            }
        }
    }

    public void display(ArrayList<Person> dataPerson) {

    }

    public void MaxMin(ArrayList<Person> dataPerson) {
        int max, min;
        max = min = dataPerson.get(0).getMoney();
        for (Person person : dataPerson) {
            if (max < person.getMoney()) {
                max = person.getMoney();
            }
            if (min > person.getMoney()) {
                min = person.getMoney();
            }
        }
        System.out.print("Min: ");
        for (Person person : dataPerson) {
            if (person.getMoney() == min) {
                System.out.print(person.getName() + " ");
            }
        }
        System.out.println();
        System.out.print("Max: ");
        for (Person person : dataPerson) {
            if (person.getMoney() == max) {
                System.out.print(person.getName() + " ");
            }
        }
        System.out.println();

    }

    public  boolean copyWordOneTimes(String source, String destination) throws Exception {
        File sourceFile = new File(source);
        File destinationFile = new File(destination);

        if (!sourceFile.exists()) {
            throw new Exception("Source file path doesn't exist.");
        }

        if (!destinationFile.exists()) {
            throw new Exception("Destination file path doesn't exist.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            Set<String> words = new HashSet<>();

            while ((line = reader.readLine()) != null) {
                String[] wordsInLine = line.split("\\s+");

                for (String word : wordsInLine) {
                    if (!words.contains(word)) {
                        writer.write(word);
                        writer.newLine();
                        words.add(word);
                    }
                }
            }

            return true;

        } catch (IOException e) {
            throw new Exception("Error reading or writing files.");
        }
    }
}
