package com.irfaan.taxcalculation.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GenderEnum {

    MALE("MALE", "laki-laki"),

    FEMALE("FEMALE", "wanita");

    private String code;

    private String description;

    public static GenderEnum getEnumByCode(String code) {
        for (GenderEnum gender : values()) {
            if (gender.code.equals(code)) {
                return gender;
            }
        }
        return null;
    }
}
