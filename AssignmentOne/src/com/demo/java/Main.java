package com.demo.java;
import java.io.*;
import java.util.*;

public class Main {
    private static void displayInfo() {//Display info method as required by assignment instructions
        System.out.println("--------------------------------------");
        System.out.println("Assignment 1, 159.234 Semester 1 2021");
        System.out.println("Submitted by Brown, Phillip 21011867");
        System.out.println("--------------------------------------");

    }

    public static void main(String[] args) throws IOException {

        double upperSal = 0;
        double lowerSal = 0;

        String first = null;
        String last = null;
        int ID = 0;
        double Sal = 2;

        Scanner kb = new Scanner(System.in);//Reads from keyboard input
        List<String> employeesArrayList = new ArrayList<String>();//Arraylist for info from file to be feed into
        List<Employees> employeesList = new ArrayList<Employees>();//List of employeeclass
        List<Employees> employeesList1ist = new ArrayList<Employees>();//List of employeeclass
        Employees test = new Employees(first, last, ID, Sal);
        try (BufferedReader datain = new BufferedReader(new FileReader("a1.txt"))) {//file reader

            try {
                String line = "";
                while ((line = datain.readLine()) != null) {
                    employeesArrayList.add(line);//adds items into arraylist.

                }//While
            }//t2
            finally {
                datain.close();
                // System.out.println("Finished Reading");//Debugging line
            }
        }//t1
        catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("Test Print: \n" +employeesArrayList + employeesArrayList.size());//Debug to see what is being inputted into the array

        //For loop that reads each array item into a string, splits it, puts the values to correct variables and feeds that into employee class.
        for (int i = 0; i < employeesArrayList.size(); ++i) {

            String lines = employeesArrayList.get(i);
            String[] parts = lines.split(" ");

            first = parts[1];
            last = parts[0];
            ID = Integer.parseInt(parts[2]);
            Sal = Double.parseDouble(parts[3]);

            test = new Employees(first, last, ID, Sal);

            employeesList.add(test);//adds new employee instances to employeeList
            employeesList1ist.add(test);
            //System.out.println("Loaded " + first + " " + last + " " + i);//DEBUG
            //System.out.print(test); //Prints all items in employee class DEBUG
        }//For

        displayInfo();
        salaryCalc(employeesList);
        System.out.println("");

        System.out.println("Do you want to find employees whose salaries are between the specified range?");
        System.out.println("Type 'n' to quit or 'y' to continue");

        String Line = kb.next();//reads from input

        while (Line.equals("y") || Line.equals("Y")){//If that input is a y then contiune into the while loop, else if will break

            System.out.println("Enter lower boundary for salary range: ");
            lowerSal = kb.nextDouble();
            System.out.println("Enter upper boundary for salary range: ");
            upperSal = kb.nextDouble();

            System.out.println(test.compareSalary(lowerSal,upperSal,employeesList1ist) + "\n");//Sends doubles entered off to the compare method along with a array list of employees

            System.out.println("Do you want to find employees whose salaries are between the specified range?");
            System.out.println("Type 'n' to quit or 'y' to continue");

            Line = kb.next();
        }//while

    }//Main method

    public static void salaryCalc (List<Employees> employeesList){//Method to display the stats on the employees in the file
        int count = 0;
        double lowest = 1000000000;
        double highest = 0;
        double hold = 0;
        double avg = 0;
        double next = 0;

        while (!employeesList.isEmpty()){
            Employees current = employeesList.get(0);
            hold = current.getSalary();

            if(hold < lowest) {
                lowest = hold;
            }

            else if (hold > highest) {
                highest = hold;
            }

            next = next + current.getSalary();
            count++;
            employeesList.remove(0);
        }//While

        avg = next / count;

        System.out.println("Number of employees: " + count);
        System.out.println("Average salary: " + avg);
        System.out.println("The lowest salary is: " + lowest);
        System.out.println("The highest salary is: " + highest);

    }//salcalc

}//main class


