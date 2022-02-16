package com.bridgelabz;

public interface IComputeEmpWage {
    public void addCompanyEmpWage(String companyName,int empRatePerHours,int numberOfWorkingDays ,int maximumHoursPerMonth);
    public void computeEmpWage();
    public int getTotalWage(String company);
}

class CompanyEmpWage1 {
    public final String companyName;
    public  final int empRatePerHours;
    public final int numberOfWorkingDays;
    public final int maximumHoursPerMonth;
    public int totalEmpWage;

    public CompanyEmpWage1(String companyName,int empRatePerHours,int numberOfWorkingDays ,int maximumHoursPerMonth) {
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

class EmployeeWageBuilderArray1 implements IComputeEmpWage{
    public static final int IS_FULL_TIME = 2;
    public static final int IS_PART_TIME = 1;

    private int numOfCompany = 0;
    private CompanyEmpWage[]companyEmpWageArray;

    public EmployeeWageBuilderArray1(){
        companyEmpWageArray = new CompanyEmpWage[5];
    }

    public void addCompanyEmpWage(String companyName,int empRatePerHours,int numberOfWorkingDays ,int maximumHoursPerMonth){
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(companyName, empRatePerHours, numberOfWorkingDays , maximumHoursPerMonth);
        numOfCompany++;
    }

    public void computeEmpWage (){
        for (int i = 0; i < numOfCompany; i++){
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }

    @Override
    public int getTotalWage(String company) {
        return 0;
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
        EmployeeWageBuilderArray1 employeeWageBuilderArray1 = new EmployeeWageBuilderArray1();
        employeeWageBuilderArray1.addCompanyEmpWage("DMart",20,2,10);
        employeeWageBuilderArray1.addCompanyEmpWage("Relience",10,4,20);
        employeeWageBuilderArray1.computeEmpWage();
    }
}


