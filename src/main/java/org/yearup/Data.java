package org.yearup;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Data {
    private static LocalDate date;
    private static LocalTime time;
    private static String description;
    private static String vendor;
    private static BigDecimal amount;

    public Data(LocalDate date, LocalTime time, String description, String vendor, BigDecimal amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public static BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + amount +
                '}';
    }
    public static String toCsv() {
        return String.join("|", date.toString(), time.toString(), description, vendor, amount.toString());
    }

}