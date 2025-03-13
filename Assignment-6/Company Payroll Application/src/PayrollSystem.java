/* A company pays its employees on a weekly basis. The employees are of four types: 
Salaried employees are paid a fixed weekly salary regardless of the number of hours worked, 
hourly employees are paid by the hour and receive overtime pay (i.e., 1.5 times their hourly salary rate) 
for all hours worked in excess of 40 hours, 
commission employees are paid a percentage of their sales and 
base-salaried commission employees receive a base salary plus a percentage of their sales. 
For the current pay period, the company has decided to reward salaried- commission employees by adding 10% to their base salaries. 
The company wants to write an application that performs its payroll calculations polymorphically.  */



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class Employee
abstract class Employee {
    private String name;
    private String socialSecurityNumber;

    public Employee(String name, String socialSecurityNumber) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // Abstract method to calculate earnings
    public abstract double earnings();

    @Override
    public String toString() {
        return "Name: " + name + "\nSSN: " + socialSecurityNumber;
    }
}

// SalariedEmployee class
class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, String socialSecurityNumber, double weeklySalary) {
        super(name, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }
    public void setWeeklySalary(double weeklySalary) {
    	this.weeklySalary = weeklySalary;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Salaried\nWeekly Salary: $" + String.format("%.2f", weeklySalary);
    }
}

// HourlyEmployee class
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String name, String socialSecurityNumber, double hourlyRate, double hoursWorked) {
        super(name, socialSecurityNumber);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
     public double getHourlyRate(){
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate){
        this.hourlyRate = hourlyRate;
    }
    
    public double getHoursWorked(){
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked){
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double earnings() {
        if (hoursWorked <= 40) {
            return hourlyRate * hoursWorked;
        } else {
            return (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Hourly\nHourly Rate: $" + String.format("%.2f", hourlyRate) + "\nHours Worked: " + String.format("%.2f", hoursWorked);
    }
}

// CommissionEmployee class
class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String name, String socialSecurityNumber, double grossSales, double commissionRate) {
        super(name, socialSecurityNumber);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
     public double getGrossSales(){
        return grossSales;
    }
    public void setGrossSales(double grossSales){
        this.grossSales = grossSales;
    }
    
    public double getCommissionRate(){
        return commissionRate;
    }
    public void setCommissionRate(double commissionRate){
        this.commissionRate = commissionRate;
    }

    @Override
    public double earnings() {
        return grossSales * commissionRate;
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Commission\nGross Sales: $" + String.format("%.2f", grossSales) + "\nCommission Rate: " + String.format("%.2f", commissionRate);
    }
}

// BasePlusCommissionEmployee class
class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String name, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary) {
        super(name, socialSecurityNumber, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }
    
    public double getBaseSalary(){
        return baseSalary;
    }
    
    public void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }

    // Apply the 10% bonus to base salary for the current pay period
    public void applyBonus() {
        baseSalary *= 1.10; // Increase base salary by 10%
    }

    @Override
    public double earnings() {
        return baseSalary + super.earnings();
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Base Plus Commission\nBase Salary: $" + String.format("%.2f", baseSalary);
    }
}

// Enum for Employee Types
enum EmployeeType {
    SALARIED,
    HOURLY,
    COMMISSION,
    BASE_PLUS_COMMISSION
}

public class PayrollSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Input employee data (using a loop for multiple employees)
        while (true) {
            System.out.println("\nEnter employee data (or type 'done' to finish):");
            System.out.print("Employee Type: "
            		+"\n1) SALARIED \n2) HOURLY \n3) COMMISSION \n4) BASE_PLUS_COMMISSION ");
            String employeeTypeStr = scanner.nextLine().toUpperCase(); // Convert to uppercase for case-insensitivity

            if (employeeTypeStr.equalsIgnoreCase("done")) {
                break;
            }

            EmployeeType employeeType;
            try {
                employeeType = EmployeeType.valueOf(employeeTypeStr); // Convert string to enum
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid employee type. Please enter SALARIED, HOURLY, COMMISSION, or BASE_PLUS_COMMISSION.");
                continue;
            }

            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Social Security Number: ");
            String ssn = scanner.nextLine();

            switch (employeeType) {
                case SALARIED:
                    System.out.print("Weekly Salary: ");
                    double weeklySalary = scanner.nextDouble();
                    scanner.nextLine(); //consume extra line
                    employees.add(new SalariedEmployee(name, ssn, weeklySalary));
                    break;
                case HOURLY:
                    System.out.print("Hourly Rate: ");
                    double hourlyRate = scanner.nextDouble();
                    System.out.print("Hours Worked: ");
                    double hoursWorked = scanner.nextDouble();
                    scanner.nextLine(); //consume extra line
                    employees.add(new HourlyEmployee(name, ssn, hourlyRate, hoursWorked));
                    break;
                case COMMISSION:
                    System.out.print("Gross Sales: ");
                    double grossSales = scanner.nextDouble();
                    System.out.print("Commission Rate (e.g., 0.10 for 10%): ");
                    double commissionRate = scanner.nextDouble();
                    scanner.nextLine(); //consume extra line
                    employees.add(new CommissionEmployee(name, ssn, grossSales, commissionRate));
                    break;
                case BASE_PLUS_COMMISSION:
                    System.out.print("Gross Sales: ");
                    double grossSalesB = scanner.nextDouble();
                    System.out.print("Commission Rate: ");
                    double commissionRateB = scanner.nextDouble();
                    System.out.print("Base Salary: ");
                    double baseSalary = scanner.nextDouble();
                    scanner.nextLine(); //consume extra line
                    BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee(name, ssn, grossSalesB, commissionRateB, baseSalary);
                    bpce.applyBonus();  // Apply the 10% bonus
                    employees.add(bpce);
                    break;
            }
        }

        // Process payroll polymorphically
        System.out.println("\nPayroll Report:");
        double totalPayroll = 0;
        for (Employee employee : employees) {
            System.out.println("\n" + employee);
            System.out.println("Earnings: " + String.format("%.2f", employee.earnings()));
            totalPayroll += employee.earnings();
        }
        System.out.println("\nTotal Payroll: " + String.format("%.2f", totalPayroll));

        scanner.close();
    }
}