package com.irfaan.taxcalculation.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author irfaanhibatullah
 * @version $Id: TaxIncomeResult.java, v 0.1 2023‐01‐05 23.01 irfaanhibatullah Exp $$
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class TaxIncomeResult extends BaseResult {

    private long taxIncome;

    private String codeCurrency;
}