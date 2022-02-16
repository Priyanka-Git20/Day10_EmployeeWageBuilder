package com.bridgelabz;

class CompanyEmpWage {
    public final String companyName;
    public  final int empRatePerHours;
    public final int numberOfWorkingDays;
    public final int maximumHoursPerMonth;
    public int totalEmpWage;

    public CompanyEmpWage(String companyName,int empRatePerHours,int numberOfWorkingDays ,int maximumHoursPerMonth) {
        this.companyName = companyName;
        this.empRatePerHours = empRatePerHours;
        this.numberOfWorkingDays = numberOfWorkingDays;
        this.maximumHoursPerMonth = maximumHoursPerMonth;
    }

    public void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage = totalEmpWage;
    }

    @Override
    public String toString() {
        return "Total employee wage for company:" +companyName+ " is :" + totalEmpWage;
    }
}
public class EmployeeWageBuilderArray {
    public static final int IS_FULL_TIME = 2;
    public static final int IS_PART_TIME = 1;

    private int numOfCompany = 0;
    private CompanyEmpWage[]companyEmpWageArray;

    public EmployeeWageBuilderArray(){
        companyEmpWageArray = new CompanyEmpWage[5];
    }

     private void addCompanyEmpWage(String companyName,int empRatePerHours,int numberOfWorkingDays ,int maximumHoursPerMonth){
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(companyName, empRatePerHours, numberOfWorkingDays , maximumHoursPerMonth);
        numOfCompany++;
     }

     private void computeEmpWage(){
        for (int i = 0; i < numOfCompany; i++){
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
     }
     
    private int  computeEmpWage(CompanyEmpWage companyEmpWage){
        //variables
        int empHours = 0;
        int totalEmpHours= 0;
        int totalWorkingDays= 0;

        //Computation
        while ( totalEmpHours < companyEmpWage.maximumHoursPerMonth &&
                totalWorkingDays < companyEmpWage.numberOfWorkingDays)
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
         return totalEmpHours * companyEmpWage.empRatePerHours;
    }

    public static void main(String[] args) {
        EmployeeWageBuilderArray employeeWageBuilderArray = new EmployeeWageBuilderArray();
        employeeWageBuilderArray.addCompanyEmpWage("DMart",20,2,10);
        employeeWageBuilderArray.addCompanyEmpWage("Relience",10,4,20);
        employeeWageBuilderArray.computeEmpWage();
    }
}

