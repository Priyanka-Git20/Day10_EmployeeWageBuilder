package com.bridgelabz;

import java.util.LinkedList;

public interface IComputeEmpWage1 {
    public void addCompanyEmpWage(String companyName,int empRatePerHours,int numberOfWorkingDays ,int maximumHoursPerMonth);
    public void computeEmpWage();
    public int getTotalWage(String company);
}

class CompanyEmpWage2 {
    public final String companyName;
    public  final int empRatePerHours;
    public final int numberOfWorkingDays;
    public final int maximumHoursPerMonth;
    public int totalEmpWage;

    public CompanyEmpWage2(String companyName, int empRatePerHours, int numberOfWorkingDays , int maximumHoursPerMonth) {
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

class EmployeeWageBuilderArrayList implements IComputeEmpWage1 {
    public static final int IS_FULL_TIME = 2;
    public static final int IS_PART_TIME = 1;

    private int numOfCompany = 0;
    private LinkedList<CompanyEmpWage2>companyEmpWageList;

    public EmployeeWageBuilderArrayList(){
        companyEmpWageList = new LinkedList<>();
    }

    public void addCompanyEmpWage(String companyName,int empRatePerHours,int numberOfWorkingDays ,int maximumHoursPerMonth){
        CompanyEmpWage2 companyEmpWage = new CompanyEmpWage2(companyName, empRatePerHours, numberOfWorkingDays , maximumHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
    }

    public void computeEmpWage (){
        for (int i = 0; i < companyEmpWageList.size(); i++){
            CompanyEmpWage2 companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }

    @Override
    public int getTotalWage(String company) {
        return 0;
    }

    private int  computeEmpWage(CompanyEmpWage2 companyEmpWage){
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
        EmployeeWageBuilderArrayList employeeWageBuilderArrayList = new EmployeeWageBuilderArrayList();
        employeeWageBuilderArrayList.addCompanyEmpWage("DMart",20,2,10);
        employeeWageBuilderArrayList.addCompanyEmpWage("Relience",10,4,20);
        employeeWageBuilderArrayList.computeEmpWage();
    }
}


