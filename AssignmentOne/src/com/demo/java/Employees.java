package com.demo.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Employees {
    private String fname;
    private String lname;
    private int ID = 0;
    private double salary = 0;
    private static int numEmployees = -1;

    public Employees(String nFname, String nLname, int nID, double nSalary ){//Public variables
        fname = nFname;
        lname = nLname;
        ID = nID;
        salary = nSalary;
        numEmployees++;//Object count, needs to be static
    }

    //Get/Set declarations
    public String getFname(){return fname; }
    public String getLname(){return lname; }
    public int getID() {return ID; }
    public double getSalary() {return salary;}
    public void setFname() { this.fname = fname; }
    public void setLname() { this.lname = lname; }
    public void setID() { this.ID = ID; }
    public void setSalary() {this.salary = salary; }

    public String toString(){
        String S = String.format("Employee - Name: %-5s  %-10s ID: %-10d Salary: %-10.0f \n",fname,lname,ID,salary);//toString /w formatting to meet requirements
        return S;
    }

    //Compare method, takes in the numbers enetered by the user along with a copy of the employee list
    public String compareSalary(double salOne, double salTwo, List<Employees> employees){
        List<Employees> place = new ArrayList<Employees>();//Creates a blank arraylist of type Employees
        String s = null;

        //for every item in the list, check if it is between the provided salary range and add it to the place list
        for (int i = 0; i < employees.size(); ++i){
            Employees current = employees.get(i);
            if(current.getSalary() > salOne && current.getSalary() < salTwo){
                place.add(current);
            }//if
        }

        s = place.stream().map(Object::toString).collect(Collectors.joining());//convert the objects in place into a string

        return "Employees: \n" + s + "Total employees within range: " + place.size();//output them to the toString Method

    }
}
