package com.irfaan.taxcalculation.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Map;

/**
 * @author irfaanhibatullah
 * @version $Id: TaxIncomeRequest.java, v 0.1 2023‐01‐05 22.56 irfaanhibatullah Exp $$
 */

@Data
public class TaxIncomeRequest {

    @NotBlank(message = "marital status is not defined")
    private String maritalStatus;

    @NotBlank(message = "gender is not defined")
    private String gender;

    @NotBlank(message = "nationality is not blank")
    private String nationality;

    @Positive
    private String basicSalary;

    private Map<String, String> deductibleIncome;

    private Map<String, String> nonDeductibleIncome;
}