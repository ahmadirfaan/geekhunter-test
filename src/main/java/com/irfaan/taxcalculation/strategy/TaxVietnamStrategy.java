package com.irfaan.taxcalculation.strategy;


import com.irfaan.taxcalculation.configs.TaxIncomeConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
@AllArgsConstructor
public class TaxVietnamStrategy implements TaxStrategy {

    @Override
    public double calculateBasedNationality(double incomePerMonth, String maritalStatus, double nonDeductibleEarning) {
        double incomePerYear = incomePerMonth * 12;
        AtomicReference<Double> percentTax = new AtomicReference<>((double) 0);
        TaxIncomeConfig.getPercentTaxConfigVnd().forEach( (k,v) -> {
            if(incomePerYear < v) {
                percentTax.set(k);
            }
        });

        return (percentTax.get() * incomePerYear) / 2;
    }
}
