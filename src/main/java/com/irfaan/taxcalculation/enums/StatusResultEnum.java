/**
 * DANA
 * Copyright (c) 2018‐2023 All Rights Reserved.
 */
package com.irfaan.taxcalculation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author irfaanhibatullah
 * @version $Id: StatusResultEnum.java, v 0.1 2023‐01‐05 23.18 irfaanhibatullah Exp $$
 */

@Getter
@AllArgsConstructor
public enum StatusResultEnum {

    SUCCESS("success", "result means success"),
    FAILED("failed", "success got failed");


    private final String code;

    private final String description;
}