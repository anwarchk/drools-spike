package com.hcsc.rules.domain;


import java.util.Collection;

public class Provider {

    private String name;
    private ProviderType providerType;
    private Collection<Speciality> specialities;
    private boolean valid = true;


    public Provider(String name, ProviderType providerType, Collection<Speciality> specialities) {
        this.name = name;
        this.providerType = providerType;
        this.specialities = specialities;
    }

    public boolean hasAnySpeciality(Specialities sps) {
        for (String sp : sps) {
            for (Speciality speciality1 : this.specialities) {
                if (sp.equals(speciality1.getSpecialityType().getCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }
}




