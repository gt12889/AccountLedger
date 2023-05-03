package org.example;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileReader;

public class Transaction {

    private static final String transaction_file = "transactions.csv";


    public static void addDeposit() throws IOException {
        FileWriter fw = new FileWriter("target/transactions.csv", true);
        BufferedWriter writer = new BufferedWriter(fw);

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter the deposit description: ");
            String description = scanner.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String[] record = {LocalDate.now().toString(), LocalTime.now().format(formatter), description, String.valueOf(amount)};

            writer.write(String.join("|", record));
            writer.newLine();

            System.out.println("Deposit added");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        } catch (IOException e) {
            System.out.println("An error occurred while adding the deposit");
        } finally {
            writer.close();
        }

    }

    public void displayAllDeposit() {
        ArrayList<org.yearup.Data> records = new ArrayList<>();
        // load the array
        FileInputStream stream;
        Scanner fileScanner = null;
        try {
            stream = new FileInputStream("target/transactions.csv");
            fileScanner = new Scanner(stream);
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //split line into fields
                String[] columns = line.split("\\|");
                LocalDate date = LocalDate.parse(columns[0]);
                LocalTime time = LocalTime.parse(columns[1]);
                String description = columns[2];
                String vendor = columns[3];
                double amount = Double.parseDouble(columns[4]);

                //create ArrayList
                org.yearup.Data record = new org.yearup.Data(date, time, description, vendor, amount);
            }

        } catch (FileNotFoundException e) {
            System.out.println("There was an error loading the file");
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }


    }
}
