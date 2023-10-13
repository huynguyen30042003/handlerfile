package Common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Library {
    public String input() throws IOException {
        File file = new File("test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String data = "";
        String st;
        while ((st = br.readLine()) != null) {
            data = data + st.trim() + ".";
        }
        System.out.println(data);
        return data;
    }

    public static int getInt(String promt, int m, int n) {
        int a = -1;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public static String validString(String name) {
        Scanner sc = new Scanner(System.in);
        String s = null;

        while (s == null || s.isEmpty() == true) {
            System.out.print(name + ": ");

            s = sc.nextLine();
        }
        return s;
    }

    public static int validNumber(String name) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (number <= 0) {
            System.out.print("Enter " + name + " >0 :");
            number = sc.nextInt();
        }
        return number;
    }
}
