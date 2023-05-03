package org.example;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Ledger {
    public static void main(String[] args) throws IOException {


            home();


    }


    public static void home() throws IOException {
        boolean run = true;
        Scanner sc = new Scanner(System.in);


        while (run) {


            System.out.println("Accounting Ledger");
            System.out.println("-----------------------");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");


            String input = sc.nextLine().toUpperCase();

            switch (input) {
                case "D":
                    Transaction.addDeposit();
                   Transaction.displayAllDeposit();
                    break;


                case "P":


                default:
                    System.out.println("Invalid option");
                break;
            }

        }



    }
}