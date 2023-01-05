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
    public long calculateBasedNationality(String gender, long incomePerMonth, String maritalStatus, long nonDeductibleEarning) {
        NonTaxableIncomeEnum nonTaxableIncomeEnum = NonTaxableIncomeEnum.getEnumByCode(maritalStatus);
        if (nonTaxableIncomeEnum != null) {
            long amountOfNonTaxableIncome = TaxIncomeConfig.getAmountOfNonTaxableIncome(nonTaxableIncomeEnum);

            //multiply basicSalary for a year
            long incomePerYear = incomePerMonth * 12;
            long totalNonDeductibleEarning = nonDeductibleEarning * 12;
            //incomePerYear minus non taxable income
            long netto = incomePerYear - amountOfNonTaxableIncome - totalNonDeductibleEarning;
            double result = 0.0;
            Map<Double, Long> percentTaxConfig = TaxIncomeConfig.getPercentTaxConfig();
            for (Map.Entry<Double, Long> doubleLongEntry : percentTaxConfig.entrySet()) {
                if (netto > 0) {
                    Double key = doubleLongEntry.getKey();
                    long value = doubleLongEntry.getValue();
                    double deductionTaxLayer = key * netto;
                    result += deductionTaxLayer;
                    netto = netto - value;
                }
            }

            return (long) result / 12;
        }

        return 0;

    }
}
