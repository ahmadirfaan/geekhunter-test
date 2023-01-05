package com.irfaan.taxcalculation.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author irfaanhibatullah
 * @version $Id: BaseResult.java, v 0.1 2023‐01‐05 23.13 irfaanhibatullah Exp $$
 */

@Data
@ToString
public class BaseResult {

    private String message;

    private String status;
}