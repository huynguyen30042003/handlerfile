package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
}
