package part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadAccounts {
    private BufferedReader reader;
    private String url;

    public ReadAccounts(String URL) {
        this.url = URL;
        try {
            reader = new BufferedReader(new FileReader(url));
            reader.mark(1048576); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> getFirstNames() {
        LinkedList<String> firstNames = new LinkedList<>();
        try {
            reader.reset(); 
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                firstNames.add(data[0].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstNames;
    }

    public LinkedList<String> getLastNames() {
        LinkedList<String> lastNames = new LinkedList<>();
        try {
            reader.reset();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                lastNames.add(data[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastNames;
    }

    public LinkedList<Integer> getAccounts() {
        LinkedList<Integer> accounts = new LinkedList<>();
        try {
            reader.reset(); 
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                accounts.add(Integer.parseInt(data[3].trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public LinkedList<Integer> getBalances() {
        LinkedList<Integer> balances = new LinkedList<>();
        try {
            reader.reset();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                balances.add(Integer.parseInt(data[2].trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balances;
    }
}
