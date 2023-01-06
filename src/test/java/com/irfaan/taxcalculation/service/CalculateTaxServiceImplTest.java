package com.irfaan.taxcalculation.service;

import com.irfaan.taxcalculation.exceptions.TaxAppException;
import com.irfaan.taxcalculation.model.TaxIncomeRequest;
import com.irfaan.taxcalculation.model.TaxIncomeResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class CalculateTaxServiceImplTest {


    @Mock
    private CalculateTaxService calculateTaxService;

    @Test
    public void testCalculationTaxIndonesian() {
        TaxIncomeRequest request = new TaxIncomeRequest();
        request.setGender("MALE");
        request.setNationality("IDR");
        request.setMaritalStatus("TK_0");
        request.setBasicSalary("10500000");

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