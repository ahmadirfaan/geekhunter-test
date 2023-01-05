package com.irfaan.taxcalculation.configs;

import com.irfaan.taxcalculation.enums.NonTaxableIncomeEnum;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author irfaanhibatullah
 * @version $Id: NonTaxableIncomeConfig.java, v 0.1 2023‐01‐05 23.25 irfaanhibatullah Exp $$
 */
public class TaxIncomeConfig {

    private static final Map<NonTaxableIncomeEnum, Long> configsOfNonTaxableIncomeConfig = new LinkedHashMap<>();

    private static final Map<Double, Long> percentTaxConfig = new LinkedHashMap<>();

    static {
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.TK_O, 54_000_000L);
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.K_0, 58_500_000L);
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.K_1, 63_000_000L);
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.K_2, 67_000_000L);
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.K_3, 72_000_000L);
        percentTaxConfig.put(0.05, 50_000_000L);
        percentTaxConfig.put(0.15, 250_000_000L);
        percentTaxConfig.put(0.25, 500_000_000L);
        percentTaxConfig.put(0.30, 500_000_000L);
    }

    public static long getAmountOfNonTaxableIncome(NonTaxableIncomeEnum nonTaxableIncomeEnum) {
        return configsOfNonTaxableIncomeConfig.getOrDefault(nonTaxableIncomeEnum, 0L);
    }

    public static Map<Double, Long> getPercentTaxConfig() {
        return percentTaxConfig;
    }

}