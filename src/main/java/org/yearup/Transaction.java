package org.yearup;

import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
     private static List<Data> transactions;
        private static final String transactionfile = "transactions.csv";



        public Transaction() {
            createTransactionFile();
            transactions = loadTransactions();

        }
    public static void showLedger() {
        for (Data transaction : transactions) {
            System.out.println(transaction);
        }
    }
        public static void addDeposit(BigDecimal amount) {
            saveTransaction(new Data(LocalDate.now(), LocalTime.now(), "Deposit", "User", amount));
        }

        public static void addPayment(BigDecimal amount) {
            saveTransaction(new Data(LocalDate.now(), LocalTime.now(), "Payment", "User", amount));
        }



        private static void createTransactionFile() {
            try {
                Path path = Paths.get(transactionfile);
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
            } catch (IOException e) {
                System.out.println(ColorCodes.RED + "Error creating transactions file: " + e.getMessage() + ColorCodes.RESET);
            }
        }



        private static void saveTransaction(Data tr) {
            transactions.add(tr);
            try (FileWriter fw = new FileWriter(transactionfile, true);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(Data.toCsv());
                bw.newLine();
            } catch (IOException e) {
                System.out.println(ColorCodes.RED + "Error saving transaction: " + e.getMessage() + ColorCodes.RESET);
            }
        }
    private List<Data> loadTransactions() {
        List<Data> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(transactionfile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                transactions.add(new Data(LocalDate.parse(data[0]), LocalTime.parse(data[1]),
                        data[2], data[3], new BigDecimal(data[4])));
            }
        } catch (IOException e) {

            System.out.println(ColorCodes.RED +"Error loading transactions: " + e.getMessage() + ColorCodes.RESET);
        }
        return transactions;
    }
    }


