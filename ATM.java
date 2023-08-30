import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ATM {
    Map<String, Double> atm;

    public ATM() {
        atm = new HashMap<String, Double>();
    }

    public void openAccount(String userid, Double amount) {

        // create a new name + accout
        if (atm.get(userid) == null)
            atm.put(userid, amount);
    }

    public void closeAccount(String userid) {
        if (checkBalance(userid) != 0) {
            System.out.println("Nope, uou still have money");
            return;
        } else {
            atm.remove(userid);
        }
    }

    public Double checkBalance(String userid) {
        return atm.get(userid);
    }

    public Double depositMoney(String userid, Double amount) {
        atm.put(userid, atm.get(userid) + amount);
        return checkBalance(userid);
    } // dfd

    public void withdrawMoney(String userid, Double amount) {
    }

    public void transferMoney(String fromAccount, String toAccount, Double amount) {
    }

    public void audit() {

    }

    public static void writeFile(String toWrite) {
        String name = "write_this.txt";

        // Write the string to the file
        try {
            FileWriter fileWriter = new FileWriter(name);
            fileWriter.write(toWrite);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("some didn't work");
        }
    }

    public static String readFile(File file) {
        String currentString = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready()) {
                char nextChar = (char) reader.read();
                currentString += nextChar;

            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("nah");
        }
        return currentString;

    }

    public static void main(String[] args) {

    }
}