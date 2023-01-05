package com.irfaan.taxcalculation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author irfaanhibatullah
 * @version $Id: NonTaxableIncomeEnum.java, v 0.1 2023‐01‐05 23.26 irfaanhibatullah Exp $$
 */
@AllArgsConstructor
@Getter
public enum NonTaxableIncomeEnum {

    TK_O("TK_0", "non married"),

    K_0("K_0", "married with 0 children"),

    K_1("K_1", "married with 1 childen"),

    K_2("K_2", "married with 2 childen"),

    K_3("K_3", "married with 3 childen"),
    ;
    private final String code;

    private final String description;
}