package com.bridgelabz;

public class EmployeeWageBuilderUC9 {
    public static final int IS_FULL_TIME = 2;
    public static final int IS_PART_TIME = 1;

    private final String companyName;
    private final int empRatePerHours;
    private final int numberOfWorkingDays;
    private final int maximumHoursPerMonth;
    private int totalEmpWage;

    public EmployeeWageBuilderUC9(String companyName, int empRatePerHours, int numberOfWorkingDays , int maximumHoursPerMonth) {
        this.companyName = companyName;
        this.empRatePerHours = empRatePerHours;
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.maximumHoursPerMonth = maximumHoursPerMonth;
    }

    public void computeEmployeeWage(){
        //variables
        int empHours = 0;
        int totalEmpHours= 0;
        int totalWorkingDays= 0;

        //Computation
        while ( totalEmpHours < maximumHoursPerMonth &&
                totalWorkingDays < numberOfWorkingDays)
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
        totalEmpWage = totalEmpHours * empRatePerHours;
    }

    @Override
    public String toString() {
        return "Total employee wage for company:" +companyName+ " is :" + totalEmpWage;
    }

    public static void main(String[] args) {
        EmployeeWageBuilderUC9 tata = new EmployeeWageBuilderUC9("Tata",20,30,90);
        EmployeeWageBuilderUC9 bajaj = new EmployeeWageBuilderUC9("Bajaj",17,25,120);
        tata.computeEmployeeWage();
        System.out.println(tata);
        bajaj.computeEmployeeWage();
        System.out.println(bajaj);
    }
}


