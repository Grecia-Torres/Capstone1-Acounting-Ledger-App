package com.pluralsight.capstone1;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static com.pluralsight.capstone1.Ledger.allLedgerEntries;
import static com.pluralsight.capstone1.Ledger.depositEntries;


public class AccountingLedgerApp {
    public static void main(String[] args) {
        homeScreen();

    }

    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("                 HOME   ");
        System.out.println("Please choose an option from the following: ");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment");
        System.out.println("L) Ledger");
        System.out.println("X) Exit\n");
        String options = scanner.nextLine();


        switch (options) {
            case "D":
                deposit();
                break;
            case "P":
                payment();
                break;
            case "L":
                System.out.println("L) Ledger:");
                displayLedger();
                break;
            case "X":
                System.out.println("X) Exit: ");
                scanner.close();
                return;

        }
    }

    public static void displayLedger() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose an option from the options below:");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            String ledgerOptions = scanner.nextLine();

            switch (ledgerOptions) {
                case "A":
                    System.out.println("You chose option A ");
                    System.out.println("Below are ALL the transactions that have been made:\n");
                    allLedgerEntries();
                    break;
                case "D":
                    System.out.println("D) Deposits: ");
                    depositEntries();
                    break;
                case "P":
                    System.out.println("P) Payments: ");
                    break;
                case "R":
                    System.out.println("R) Reports: ");
                    displayReports();
                    break;
                case "H":
                    System.out.println("You are being directed back to the HOME SCREEN");
                    homeScreen();
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void displayReports() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose one of the options below:");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search By Vendor");
            System.out.println("0) Back");
            String reportOptions = scanner.nextLine();

            switch (reportOptions) {
                case "0":
                    System.out.println("0) Back");
                    homeScreen();
                case "1":
                    System.out.println("1) Month to Date");
                    break;
                case "2":
                    System.out.println("2) Previous Month");
                    break;
                case "3":
                    System.out.println("3) Year To Date");
                    break;
                case "4":
                    System.out.println("4) Previous Year");
                    break;
                case "5":
                    System.out.println("5) Search By Vendor");
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void deposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter deposit details below: ");
        System.out.println("Please enter a description");
        String description = scanner.nextLine();
        System.out.println("Please enter a vendor");
        String vendor = scanner.nextLine();
        System.out.println("Please enter an amount");
        String amount = scanner.nextLine();

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String transactionsFile = "transactions.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionsFile, true))) {
            writer.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
            writer.newLine();
            System.out.println("Your deposit has been accepted.");
        } catch (IOException e) {
            System.out.println("Error");
        }
        scanner.close();
    }

    public static void payment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter deposit details below: ");
        System.out.println("Please enter a description");
        String description = scanner.nextLine();
        System.out.println("Please enter a vendor");
        String vendor = scanner.nextLine();
        System.out.println("Please enter an amount");
        String amountInput = scanner.nextLine();
        double amount = -Double.parseDouble(amountInput);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String transactionsFile = "transactions.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionsFile, true))) {
            writer.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
            writer.newLine();
            System.out.println("Your payment has been accepted.");
        } catch (IOException e) {
            System.out.println("Error");
        }
        scanner.close();




        }

    }








