package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = LogManager.getLogger(App.class);
    private static PrintStream printStream = new PrintStream(new FileOutputStream(FileDescriptor.out));

    public static void main(String[] args) throws Exception {
        LOGGER.info("Main Method started");
        printStream.println("Enter 1 to calculate Simple or Compound Interest\n" +
                "Enter 2 to calculate House Construction cost\n" +
                "Enter 0 to exit");
        execute(scanner.nextInt());
        LOGGER.debug("Main method ends");
    }

    static void execute(int choice) throws Exception {
        if (choice == 1) {
            calculateInterest();
        } else if (choice == 2) {
            calculateHouseConstructionCost();
        } else if (choice == 0) {
            printStream.println("Exiting Program");
        } else {
            throw new Exception("Invalid Input");
        }
    }

    private static void calculateHouseConstructionCost() {
        printStream.println("Enter area of the house");
        double area = scanner.nextDouble();
        printConstructionInstructions();
        int choice = scanner.nextInt();
        try {
            printStream.println(new HouseConstructionCost().getCost(choice - 1, area));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printConstructionInstructions() {
        printStream.println("Press 1 for Standard Material\n" +
                "Press 2 for Above Standards\n" +
                "Press 3 for High Standards\n" +
                "Press 4 for Fully Automated");
    }

    private static void calculateInterest() throws Exception {
        printStream.println("Enter principal amount");
        double principal = scanner.nextDouble();
        printStream.println("Enter rate of interest");
        double rate = scanner.nextDouble();
        printStream.println("Enter time span");
        double time = scanner.nextDouble();

        printStream.println("Enter 1 to calculate Simple Interest\n" +
                "Enter 2 to calculate Compound Interest\n" +
                "Enter 0 to exit ");
        int choice = scanner.nextInt();

        Interest interest = new Interest(principal, rate, time);
        if (choice == 1) {
            printStream.println(interest.getSimpleInterest());
        } else if (choice == 2) {
            printStream.println(interest.getCompoundInterest());
        } else {
            throw new Exception("Invalid Input");
        }
    }
}
