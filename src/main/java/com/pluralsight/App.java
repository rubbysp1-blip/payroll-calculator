package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Employee employee = new Employee();

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            //Employee employee1 = new Employee();

            //int token = 0;

            bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){
                //String[] tokens = line.split("\\|");
                String[] tokens = line.split(Pattern.quote("|"));

//                employee[0]);
//                System.out.printf(employee[1]);
//                System.out.printf(employee[2]);
//                System.out.printf(employee[3]);
//
                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);
                employee = new Employee(employeeId, name, hoursWorked, payRate);
                double grossPay = employee.getGrossPay(hoursWorked,payRate);

//                employee1.getGrossPay(Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
//                line = bufferedReader.readLine();
                System.out.println(employee);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
