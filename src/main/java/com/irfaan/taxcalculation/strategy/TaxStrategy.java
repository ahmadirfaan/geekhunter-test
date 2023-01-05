package com.irfaan.taxcalculation.strategy;

public interface TaxStrategy {

    long calculateBasedNationality(String gender, long incomePerMonth, String maritalStatus, long nonDeductibleEarning);

}
