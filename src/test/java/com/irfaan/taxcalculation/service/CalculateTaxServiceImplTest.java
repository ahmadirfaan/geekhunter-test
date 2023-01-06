package com.irfaan.taxcalculation.service;

import com.irfaan.taxcalculation.exceptions.TaxAppException;
import com.irfaan.taxcalculation.model.TaxIncomeRequest;
import com.irfaan.taxcalculation.model.TaxIncomeResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CalculateTaxServiceImplTest {


    @Autowired
    private CalculateTaxService calculateTaxService;

    @Test
    void testCalculationTaxIndonesian() {
        TaxIncomeRequest request = new TaxIncomeRequest();
        request.setGender("MALE");
        request.setNationality("IDR");
        request.setMaritalStatus("TK_0");
        request.setBasicSalary("10500000");
        request.setDeductibleIncome(new HashMap<>());
        request.setNonDeductibleIncome(new HashMap<>());

        //if tax income from value then must be
        double taxResult = 5_800_000.00 / 12;
        String stringTax = String.format("%.2f", taxResult);
        try {
            TaxIncomeResult taxIncomeResult = calculateTaxService.calculateTaxFromIncome(request);
            Assertions.assertEquals("IDR", taxIncomeResult.getCodeCurrency());
            Assertions.assertEquals(stringTax, taxIncomeResult.getTaxIncome());
        } catch (TaxAppException e) {
            e.printStackTrace();
        }
    }


}