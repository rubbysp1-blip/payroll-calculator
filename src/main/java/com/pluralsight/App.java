package com.pluralsight;

import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Scanner input = new Scanner(System.in);

        String extensionCSV = ".csv";
        String extensionJSON = ".json";

        try {

            System.out.print("Enter the name of the file to process: ");
            String processFile = input.nextLine();

            System.out.print("Enter the name of the payroll file to create: ");
            String payrollFile = input.nextLine();

            FileWriter writer = new FileWriter(payrollFile + extensionCSV);
            FileWriter fileWriter = new FileWriter(payrollFile + extensionJSON);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            BufferedWriter buffedWriter = new BufferedWriter(fileWriter);

            FileReader fileReader = new FileReader(processFile + extensionCSV);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){

                String[] tokens = line.split(Pattern.quote("|"));

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);
                employee = new Employee(employeeId, name, hoursWorked, payRate);
                employee.getGrossPay(hoursWorked,payRate);

                writer.write(employee.toCSV() + "\n");
                fileWriter.write(employee.toJSON() +"\n");

            }
            closeWriterReader(writer, fileReader, bufferedReader, bufferedWriter, buffedWriter);

        } catch (IOException e) {
            System.out.println("Fail to read file please check file details.");
        }
    }

    public static void closeWriterReader(FileWriter writer, FileReader fileReader, BufferedReader bufferedReader, BufferedWriter bufferedWriter, BufferedWriter buffedWriter){
        try {
            writer.close();
            fileReader.close();
            bufferedReader.close();
            bufferedWriter.close();
            buffedWriter.close();
        } catch (IOException e) {
            System.out.println("Unable to close writer or file reader.");
            //throw new RuntimeException(e);
        }
    }

}
