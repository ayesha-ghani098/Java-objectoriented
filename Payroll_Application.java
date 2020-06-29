/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll_application;

import java.util.Scanner;
import java.util.ArrayList;

//Employee Class  
abstract class Employee {

    String firstName;
    String lastName;
    String socialsecurityNumber;
    double earned;
    
    abstract double earning();

}
//
//
// Salaried Employee Class
//
//

class Salaried_Employee extends Employee {

    double weeklySalary;

    public Salaried_Employee(String fn, String Ln, String ssn, double ws) {
        this.firstName = fn;
        this.lastName = Ln;
        this.socialsecurityNumber = ssn;
        this.weeklySalary = ws;

    }

    public double earning() {
        earned = weeklySalary;
        return earned;
    }

    @Override
    public String toString() {
        return "Salaried Employee: " + firstName + " " + lastName + "\n Social Security Number:  " + socialsecurityNumber + "\n Weekly Salary: " + weeklySalary;
    }
}
//
//
//Hourly Emlpoyee Class
//
//

class Hourly_Employee extends Employee {

    double hourlywage;
    int hours_worked;

    public Hourly_Employee(String fn, String Ln, String ssn, double hw, int hwk) {
        this.firstName = fn;
        this.lastName = Ln;
        this.socialsecurityNumber = ssn;
        this.hourlywage = hw;
        this.hours_worked = hwk;

    }

    public double earning() {
        if (hours_worked <= 40) {
            earned = hourlywage * hours_worked;
        } else if (hours_worked > 40) {
            earned = 40 * hourlywage + (hours_worked - 40) * hourlywage * 1.5;
        }
        return earned;

    }

    @Override
    public String toString() {
        return "Hourly Employee " + firstName + " " + lastName + "\n Social Security Number  " + socialsecurityNumber + "\n Hourly Wage " + hourlywage + "Hours Worked " + hours_worked;
    }
}
//
//
// Commision Employee Class 
//
//

class Commission_Employee extends Employee {

    double gross_sales;
    double commission_rates;

    public Commission_Employee(String fn, String Ln, String ssn, double cr, double gs) {
        this.firstName = fn;
        this.lastName = Ln;
        this.socialsecurityNumber = ssn;
        this.commission_rates = cr;
        this.gross_sales = gs;

    }

    public double earning() {
        earned = commission_rates * gross_sales;
        return earned;
    }

    @Override
    public String toString() {
        return "Commission Employee " + firstName + " " + lastName + "\n Social Security Number  is " + socialsecurityNumber + "\n Gross Sales " + gross_sales + " \n Commission Rates " + commission_rates;
    }
}
//
//
//Base + Commission Employee Class
//
//

class BasePlus_Commission_Employee extends Commission_Employee {

    double base_salary;

    public BasePlus_Commission_Employee(String fn, String Ln, String ssn, double cr, double gs, double bs) {
        super(fn, Ln, ssn, cr, gs);
        this.base_salary = bs;
    }

    @Override
    public String toString() {
        return "Commission Employee " + firstName + " " + lastName + "\n Social Security Number  is " + socialsecurityNumber + "\n Gross Sales " + gross_sales + "  Commission Rates " + commission_rates + " Base Salary " + base_salary + "\n New Base Salary With "+commission_rates+ "% Increase is " + base_salary * commission_rates;
    }

    public double earning() {
        earned = (commission_rates * gross_sales) + base_salary;
        return earned;
    }
}

class Payroll_Application {

    public static void main(String[] args) {
        // TODO code application logic here

        //
        // Array List
        //
        ArrayList Employees = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.println("1.Wanna Check Out List?");
        System.out.println("Or");
        System.out.println("2.Check Earning");
        int t = input.nextInt();
        if (t == 1) {
            for (int a = 0; a < Employees.size(); a++) {
                System.out.println("Employee " + a + " is a " + Employees.get(a));
            }
        } else {
            System.out.println("Hows many Employees you wanna enter");
            int check = input.nextInt();

            int E_category;
            for (int i = 1; i <= check; i++) {
                System.out.println("Which Employee Are you");
                System.out.println("1.Salaried Employee");
                System.out.println("2.Hourly Employee");
                System.out.println("3.Commision Employee");
                System.out.println("4.Commission + Base Salary Employee");
                E_category = input.nextInt();

                if (E_category == 1) {
                    Employees.add("SalariedEmployee");
                    System.out.println("Enter Your First Name");
                    String firstname = input.next();
                    System.out.println("Enter Your Last Name");
                    String lastname = input.next();
                    System.out.println("Enter Your SSN Number");
                    String ssnnumber = input.next();
                    System.out.println("Enter Your Weekly Salary");
                    double weeklysalary = input.nextDouble();

                    Salaried_Employee obj = new Salaried_Employee(firstname, lastname, ssnnumber, weeklysalary);

                    System.out.println(obj.toString());
                    System.out.println("Earned: " + obj.earning());

                } else if (E_category == 2) {
                    Employees.add("HourlyEmployee");
                    System.out.println("Enter Your First Name");
                    String firstname = input.next();
                    System.out.println("Enter Your Last Name");
                    String lastname = input.next();
                    System.out.println("Enter Your SSN Number");
                    String ssnnumber = input.next();
                    System.out.println("Enter Your Hourly Wage");
                    double hourlywage = input.nextDouble();
                    System.out.println("How Many hours you worked?");
                    int hourswork = input.nextInt();

                    Hourly_Employee obj = new Hourly_Employee(firstname, lastname, ssnnumber, hourlywage, hourswork);
                    System.out.println(obj.toString());
                    System.out.println("Earned: " + obj.earning());
                } else if (E_category == 3) {
                    Employees.add("CommissionEmployee");
                    System.out.println("Enter Your First Name");
                    String firstname = input.next();
                    System.out.println("Enter Your Last Name");
                    String lastname = input.next();
                    System.out.println("Enter Your SSN Number");
                    String ssnnumber = input.next();
                    System.out.println("Enter Your Sales");
                    double sales = input.nextDouble();
                    System.out.println("Enter your Comission Rates");
                    double cm = input.nextDouble();

                    Commission_Employee obj = new Commission_Employee(firstname, lastname, ssnnumber, cm, sales);
                    System.out.println(obj.toString());
                    System.out.println("Earned: " + obj.earning());
                } else if (E_category == 4) {
                    Employees.add("Base+CommissionEmployee");
                    System.out.println("Enter Your First Name");
                    String firstname = input.next();
                    System.out.println("Enter Your Last Name");
                    String lastname = input.next();
                    System.out.println("Enter Your SSN Number");
                    String ssnnumber = input.next();
                    System.out.println("Enter Your Sales");
                    double sales = input.nextDouble();
                    System.out.println("Enter your Comission Rates");
                    double cm = input.nextDouble();
                    System.out.println("Enter your Base Salary");
                    double bs = input.nextDouble();

                    BasePlus_Commission_Employee obj = new BasePlus_Commission_Employee(firstname, lastname, ssnnumber, cm, sales, bs);
                    System.out.println(obj.toString());
                    System.out.println("Earned: " + obj.earning());
                } else {
                    System.out.println("Entered Invalid Number");
                    System.out.println("Enter  Again");
                    E_category = input.nextInt();
                }

            }
        }

        System.out.println("Wanna Check Out List? Enter Yes or No");
        String s = input.next();
        if (s == "Yes") {
            for (int a = 0; a < Employees.size(); a++) {
                System.out.println("Employee " + a + " is a " + Employees.get(a));
            }

        } else {
            System.out.println("Fine! As you Wish");
        }

    }

}
