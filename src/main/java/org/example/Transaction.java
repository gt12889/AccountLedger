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


public class Transaction {

    private static final String transaction_file = "transactions.csv";
    private transactions

    private List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(transaction_file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                transactions.add(new Transaction(LocalDate.parse(data[0]), LocalTime.parse(data[1]),
                        data[2], data[3], new BigDecimal(data[4])));
            }
        } catch (IOException e) {
            System.err.println("Error loading transactions: " + e.getMessage());
        }
        return transactions;
    }
}
