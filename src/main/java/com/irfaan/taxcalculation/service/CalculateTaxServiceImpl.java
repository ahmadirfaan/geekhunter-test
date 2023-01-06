package com.irfaan.taxcalculation.service;

import com.irfaan.taxcalculation.enums.GenderEnum;
import com.irfaan.taxcalculation.enums.NonTaxableIncomeEnum;
import com.irfaan.taxcalculation.enums.StatusResultEnum;
import com.irfaan.taxcalculation.exceptions.TaxAppException;
import com.irfaan.taxcalculation.model.TaxIncomeRequest;
import com.irfaan.taxcalculation.model.TaxIncomeResult;
import com.irfaan.taxcalculation.strategy.TaxStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculateTaxServiceImpl implements CalculateTaxService {

    private final Map<String, TaxStrategy> taxStrategyMap;

    public CalculateTaxServiceImpl(@Qualifier(value = "taxStrategyHashMap")
                                   Map<String, TaxStrategy> taxStrategyMap) {
        this.taxStrategyMap = taxStrategyMap;
    }

    @Override
    public TaxIncomeResult calculateTaxFromIncome(TaxIncomeRequest request) throws TaxAppException {
        checkAllValidEnumRequest(request.getGender(), request.getMaritalStatus());
        TaxStrategy taxStrategy = taxStrategyMap.get(request.getNationality());
        if (taxStrategy == null) {
            throw new TaxAppException("Not valid for request nationality", HttpStatus.BAD_REQUEST);
        }
        TaxIncomeResult taxIncomeResult = new TaxIncomeResult();
        double totalNonDeductibleIncome = 0.0;
        for (Map.Entry<String, String> entry : request.getNonDeductibleIncome().entrySet()) {
            totalNonDeductibleIncome += Double.parseDouble(entry.getValue());
        }
        double incomePerMonth = Double.parseDouble(request.getBasicSalary()) + totalNonDeductibleIncome;

        double totalDeductibleIncome = 0.0;
        for (Map.Entry<String, String> entry : request.getDeductibleIncome().entrySet()) {
            totalDeductibleIncome += Double.parseDouble(entry.getValue());
        }

        double totalTax = taxStrategy.calculateBasedNationality(incomePerMonth, request.getMaritalStatus(), totalDeductibleIncome);

        taxIncomeResult.setStatus(StatusResultEnum.SUCCESS.getCode());
        taxIncomeResult.setTaxIncome(String.format("%.2f", totalTax));
        taxIncomeResult.setStatusCode(String.valueOf(HttpStatus.OK.value()));
        taxIncomeResult.setCodeCurrency(request.getNationality());
        taxIncomeResult.setMessage("success calculate tax");
        return taxIncomeResult;
    }

    private void checkAllValidEnumRequest(String gender, String maritalStatus) throws TaxAppException {
        GenderEnum genderEnum = GenderEnum.getEnumByCode(gender);
        NonTaxableIncomeEnum nonTaxableIncomeEnum = NonTaxableIncomeEnum.getEnumByCode(maritalStatus);
        if (genderEnum == null || nonTaxableIncomeEnum == null) {
            throw new TaxAppException("Not valid for request gender and maritalstatus", HttpStatus.BAD_REQUEST);
        }
    }

}
