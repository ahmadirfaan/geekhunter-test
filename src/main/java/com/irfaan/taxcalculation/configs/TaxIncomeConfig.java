package com.irfaan.taxcalculation.configs;

import com.irfaan.taxcalculation.enums.NonTaxableIncomeEnum;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author irfaanhibatullah
 * @version $Id: NonTaxableIncomeConfig.java, v 0.1 2023‐01‐05 23.25 irfaanhibatullah Exp $$
 */
public class TaxIncomeConfig {

    private static final Map<NonTaxableIncomeEnum, Double> configsOfNonTaxableIncomeConfig = new LinkedHashMap<>();

    private static final Map<Double, Double> percentTaxConfigIdr = new LinkedHashMap<>();

    private static final Map<Double, Double> percentTaxConfigVnd  = new LinkedHashMap<>();

    static {
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.TK_O, 54_000_000.0);
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.K_0, 58_500_000.0);
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.K_1, 63_000_000.0);
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.K_2, 67_000_000.0);
        configsOfNonTaxableIncomeConfig.put(NonTaxableIncomeEnum.K_3, 72_000_000.0);
        percentTaxConfigIdr.put(0.05, 50_000_000.0);
        percentTaxConfigIdr.put(0.15, 250_000_000.0);
        percentTaxConfigIdr.put(0.25, 500_000_000.0);
        percentTaxConfigIdr.put(0.30, 5_000_000_000.0);
        percentTaxConfigIdr.put(0.35, Double.MAX_VALUE);
        percentTaxConfigVnd.put(0.05, 5_000_000.0);
        percentTaxConfigVnd.put(0.10, 10_000_000.0);
        percentTaxConfigVnd.put(0.15, 18_000_000.0);
        percentTaxConfigVnd.put(0.20, 32_000_000.0);
        percentTaxConfigVnd.put(0.25, 52_000_000.0);
        percentTaxConfigVnd.put(0.30, 80_000_000.0);
        percentTaxConfigVnd.put(0.35, Double.MAX_VALUE);
    }

    private TaxIncomeConfig() {
        throw new IllegalStateException("Utility class");
    }


    public static double getAmountOfNonTaxableIncome(NonTaxableIncomeEnum nonTaxableIncomeEnum) {
        return configsOfNonTaxableIncomeConfig.getOrDefault(nonTaxableIncomeEnum, 0.0);
    }

    public static Map<Double, Double> getPercentTaxConfigIdr() {
        return percentTaxConfigIdr;
    }

    public static Map<Double, Double> getPercentTaxConfigVnd() {
        return percentTaxConfigVnd;
    }

}