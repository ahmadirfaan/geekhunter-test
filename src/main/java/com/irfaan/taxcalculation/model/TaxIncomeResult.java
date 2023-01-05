package com.irfaan.taxcalculation.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author irfaanhibatullah
 * @version $Id: TaxIncomeResult.java, v 0.1 2023‐01‐05 23.01 irfaanhibatullah Exp $$
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class TaxIncomeResult extends BaseResult {

    private double taxIncome;

    private String codeCurrency;
}