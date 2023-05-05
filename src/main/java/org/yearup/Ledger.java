package org.yearup;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Ledger {
    public static void main(String[] args) {
        Ledger ledger = new Ledger();
        ledger.run();
    }

    public void run() {
        Transaction transactionManager = new Transaction();
        boolean run = true;


        while (run) {
            System.out.println();
            System.out.println();
            System.out.println(ColorCodes.GREEN + "Accounting Ledger" + ColorCodes.RESET);
            System.out.println("--------------------------");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");

            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "D":

                    System.out.println("Enter deposit amount: ");
                    BigDecimal depositAmount = new BigDecimal(scanner.nextLine());

                    if (depositAmount.compareTo(BigDecimal.ZERO) == 1) {
                        Transaction.addDeposit(depositAmount);
                        System.out.println("You have deposited $" + depositAmount);
                        break;
                    } else
                        System.out.println(ColorCodes.RED + "Invalid option" + ColorCodes.RESET );
                    break;

                case "P":

                    System.out.println("Enter payment amount: ");
                    BigDecimal paymentAmount = new BigDecimal(scanner.nextLine());

                    if (paymentAmount.compareTo(BigDecimal.ZERO) == 1){
                        Transaction.addPayment(paymentAmount);
                        System.out.println("You have made a payment of $" + paymentAmount);
                        break;
                    }
                    else
                        System.out.println(ColorCodes.RED + "Invalid option" + ColorCodes.RESET );
                    break;

                case "L":
                    Transaction.showLedger();
                    break;


                case "X":
                    run = false;
                    break;


                default:
                    System.out.println(ColorCodes.RED + "Invalid option" + ColorCodes.RESET );
                    break;
            }
        }
    }
}