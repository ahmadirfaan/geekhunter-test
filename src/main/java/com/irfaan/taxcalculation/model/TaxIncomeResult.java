package com.irfaan.taxcalculation.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author irfaanhibatullah
 * @version $Id: TaxIncomeResult.java, v 0.1 2023‐01‐05 23.01 irfaanhibatullah Exp $$
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class TaxIncomeResult extends BaseResult {

    private String taxIncome;

    private String codeCurrency;
}