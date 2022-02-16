package com.bridgelabz;

public class EmployeeWageBuilderUC7 {
    public static final int IS_FULL_TIME = 2;
    public static final int IS_PART_TIME = 1;
    public static final int EMP_RATE_PER_HOUR = 20;
    public static final int NUM_OF_WORKING_DAYS = 20;
    public static final int MAX_HOURS_IN_MONTH = 100;

    public static int employeeWageTillCondition(){
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
        System.out.println("Total Emp Wage is " + totalEmpWage );
        return totalEmpWage;
    }

    public static void main(String[] args) {
        employeeWageTillCondition();
    }
}
