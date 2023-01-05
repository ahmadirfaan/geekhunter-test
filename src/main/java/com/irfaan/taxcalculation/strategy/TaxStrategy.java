package com.irfaan.taxcalculation.strategy;

public interface TaxStrategy {

    double calculateBasedNationality(String gender, double incomePerMonth, String maritalStatus, double nonDeductibleEarning);

}
