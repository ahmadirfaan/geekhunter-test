package com.irfaan.taxcalculation.strategy;

public interface TaxStrategy {

    double calculateBasedNationality(double incomePerMonth, String maritalStatus, double nonDeductibleEarning);

}
