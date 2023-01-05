package com.irfaan.taxcalculation.service;

import com.irfaan.taxcalculation.enums.GenderEnum;
import com.irfaan.taxcalculation.enums.NonTaxableIncomeEnum;
import com.irfaan.taxcalculation.exceptions.TaxAppException;
import com.irfaan.taxcalculation.model.TaxIncomeRequest;
import com.irfaan.taxcalculation.model.TaxIncomeResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CalculateTaxServiceImpl implements CalculateTaxService {


    @Override
    public TaxIncomeResult calculateTaxFromIncome(TaxIncomeRequest request) throws TaxAppException {
        checkAllValidEnumRequest(request.getGender(), request.getMaritalStatus());
        return null;
    }

    private void checkAllValidEnumRequest(String gender, String maritalStatus) throws TaxAppException {
        GenderEnum genderEnum = GenderEnum.getEnumByCode(gender);
        NonTaxableIncomeEnum nonTaxableIncomeEnum = NonTaxableIncomeEnum.getEnumByCode(maritalStatus);
        if (genderEnum == null || nonTaxableIncomeEnum == null) {
            throw new TaxAppException("Not valid for request gender and maritalstatus", HttpStatus.BAD_REQUEST);
        }
    }

}
