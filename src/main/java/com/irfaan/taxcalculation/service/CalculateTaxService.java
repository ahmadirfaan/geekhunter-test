/**
 * DANA
 * Copyright (c) 2018‐2023 All Rights Reserved.
 */
package com.irfaan.taxcalculation.service;

import com.irfaan.taxcalculation.model.TaxIncomeRequest;
import com.irfaan.taxcalculation.model.TaxIncomeResult;

/**
 * @author irfaanhibatullah
 * @version $Id: CalculateTextService.java, v 0.1 2023‐01‐05 23.01 irfaanhibatullah Exp $$
 */


public interface CalculateTaxService {

    TaxIncomeResult calculateTaxFromIncome(TaxIncomeRequest request);
}