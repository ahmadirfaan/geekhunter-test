package com.irfaan.taxcalculation.strategy;

import com.irfaan.taxcalculation.configs.NonTaxableIncomeConfig;
import com.irfaan.taxcalculation.enums.NonTaxableIncomeEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TaxIndonesianStrategy implements TaxStrategy {


    @Override
    public long calculateBasedNationality(String gender, long basicSalary, String maritalStatus) {
        NonTaxableIncomeEnum nonTaxableIncomeEnum = NonTaxableIncomeEnum.getEnumByCode(maritalStatus);
        if(nonTaxableIncomeEnum != null) {
            long amountOfNonTaxableIncome = NonTaxableIncomeConfig.getAmountOfNonTaxableIncome(nonTaxableIncomeEnum);
        }

        return 0;
    }
}
