package com.irfaan.taxcalculation.service;

import com.irfaan.taxcalculation.enums.GenderEnum;
import com.irfaan.taxcalculation.enums.NonTaxableIncomeEnum;
import com.irfaan.taxcalculation.enums.StatusResultEnum;
import com.irfaan.taxcalculation.exceptions.TaxAppException;
import com.irfaan.taxcalculation.model.TaxIncomeRequest;
import com.irfaan.taxcalculation.model.TaxIncomeResult;
import com.irfaan.taxcalculation.strategy.TaxStrategy;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class CalculateTaxServiceImpl implements CalculateTaxService {

    private Map<String, TaxStrategy> taxStrategyMap;

    private Map<String, String> pairOfBeansName;


    @Override
    public TaxIncomeResult calculateTaxFromIncome(TaxIncomeRequest request) throws TaxAppException {
        checkAllValidEnumRequest(request.getGender(), request.getMaritalStatus());
        String taxStrategyName = pairOfBeansName.get(request.getNationality());
        TaxStrategy taxStrategy = taxStrategyMap.get(taxStrategyName);
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

        double totalTax = taxStrategy.calculateBasedNationality(request.getGender(), incomePerMonth, request.getMaritalStatus(), totalDeductibleIncome);

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
