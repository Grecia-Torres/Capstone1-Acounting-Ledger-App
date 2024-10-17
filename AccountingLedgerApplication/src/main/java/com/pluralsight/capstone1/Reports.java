package com.pluralsight.capstone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import static com.pluralsight.capstone1.AccountingLedgerApp.homeScreen;

public class Reports {
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
                    searchByVendor();
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void monthToDate() {


    }

    public static void previousMonth() {

    }

    public static void yearToDate() {

    }

    public static void previousYear() {

    }

    public static void searchByVendor() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vendor name below");
        String vendorInput = scanner.nextLine();
        String line;

        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] entries = line.split("\\|");
            String vendorNames = entries[3];
            if (Objects.equals(vendorInput, vendorNames)) {
                System.out.println(line);
            }
        }
    }


}


