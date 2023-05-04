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


            System.out.println(ColorCodes.GREEN + "Accounting Ledger" + ColorCodes.RESET);
            System.out.println("-----------------------");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");


            String input = sc.nextLine().toUpperCase();

            switch (input) {
                case "D":
                    Transaction.addDeposit();

                    break;


                case "P":

                case "L":
                case "X":
                    run = false;
                    break;
                default:
                    System.out.println(ColorCodes.RED + "Invalid option");
                break;
            }

        }



    }
}