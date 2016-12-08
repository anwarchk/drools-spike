package com.hcsc.rules.domain;


public class Speciality {

    private SpecialityType specialityType;

    public Speciality(SpecialityType specialityType) {
        this.specialityType = specialityType;
    }

    public SpecialityType getSpecialityType() {
        return specialityType;
    }
}
