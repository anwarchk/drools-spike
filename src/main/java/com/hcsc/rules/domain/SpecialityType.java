package com.hcsc.rules.domain;

public enum SpecialityType {

    GP("General Practice", "001"),
    FP("Family Practice", "008"),
    IM("Internal Medicine", "011"),
    GA("Geriatrics", "349"),
    NP("Nurse Practitioner", "102"),
    PA("Physician Assistant", "102"),
    OBGYN("OBGYN", "016"),
    PED("Pediatrics", "035"),
    CP("Chiropractic", "095"),
    MSP("Mixed Specialties", "079");

    private final String type;
    private final String code;

    SpecialityType(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
}
