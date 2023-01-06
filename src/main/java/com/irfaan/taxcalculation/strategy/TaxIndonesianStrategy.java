package com.irfaan.taxcalculation.strategy;

import com.irfaan.taxcalculation.configs.TaxIncomeConfig;
import com.irfaan.taxcalculation.enums.NonTaxableIncomeEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@AllArgsConstructor
@Component
public class TaxIndonesianStrategy implements TaxStrategy {


    @Override
    public double calculateBasedNationality(double incomePerMonth, String maritalStatus, double nonDeductibleEarning) {
        NonTaxableIncomeEnum nonTaxableIncomeEnum = NonTaxableIncomeEnum.getEnumByCode(maritalStatus);
        if (nonTaxableIncomeEnum != null) {
            double amountOfNonTaxableIncome = TaxIncomeConfig.getAmountOfNonTaxableIncome(nonTaxableIncomeEnum);

            //multiply basicSalary for a year
            double incomePerYear = incomePerMonth * 12;
            double totalNonDeductibleEarning = nonDeductibleEarning * 12;
            //incomePerYear minus non taxable income
            double netto = incomePerYear - amountOfNonTaxableIncome - totalNonDeductibleEarning;
            double result = 0.0;
            Map<Double, Double> percentTaxConfig = TaxIncomeConfig.getPercentTaxConfigIdr();
            for (Map.Entry<Double, Double> doubleLongEntry : percentTaxConfig.entrySet()) {
                if (netto > 0) {
                    double key = doubleLongEntry.getKey();
                    double value = doubleLongEntry.getValue();
                    if(netto < value) {
                        result += (netto * key);
                    } else {
                        result += (value * key);

                    }
                    netto = netto - value;
                }
            }

            return result / 12;
        }

        return 0;

    }
}
