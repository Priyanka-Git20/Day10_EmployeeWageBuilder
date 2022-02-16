package com.bridgelabz;

public class EmployeeWageBuilderUC8 {
    public static final int IS_FULL_TIME = 2;
    public static final int IS_PART_TIME = 1;

    public static int employeeWageOfCompany(String companyName,int EMP_RATE_PER_HOUR,int NUM_OF_WORKING_DAYS ,int MAX_HOURS_IN_MONTH){
        //Variables
        int empHours = 0;
        int totalEmpHours= 0;
        int totalWorkingDays= 0;
        //Computation
        while ( totalEmpHours < MAX_HOURS_IN_MONTH &&
                totalWorkingDays < NUM_OF_WORKING_DAYS)
        {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random () * 10)%3;

            switch (empCheck){
                case IS_FULL_TIME:
                    empHours = 8;
                    break;
                case IS_PART_TIME:
                    empHours = 4;
                    break;
                default:
                    empHours = 0;
            }
            totalEmpHours += empHours;
            System.out.format("employee hours in day %d is %d \n ",totalWorkingDays,empHours );
        }
        System.out.format("totalEmpHours in %d days is %d \n ",totalWorkingDays,totalEmpHours );
        int totalEmpWage = totalEmpHours * EMP_RATE_PER_HOUR;
        System.out.format("Total Employee Wage for company %s is %d ",companyName,totalEmpWage );
        return totalEmpWage;
    }

    public static void main(String[] args) {
        employeeWageOfCompany("Tata",20,30,90);
        employeeWageOfCompany("Bajaj",17,25,120);
    }
}
