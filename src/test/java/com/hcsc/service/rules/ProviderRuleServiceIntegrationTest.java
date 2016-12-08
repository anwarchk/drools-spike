package com.hcsc.service.rules;

import com.hcsc.rules.domain.Provider;
import com.hcsc.rules.domain.ProviderType;
import com.hcsc.rules.domain.Speciality;
import com.hcsc.rules.domain.SpecialityType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProviderRuleServiceIntegrationTest {

    @Autowired
    private ProviderRuleService ruleService;

    @Test
    public void shouldExecuteRulesForProvider() throws Exception {

        Collection<Speciality> specialities = new ArrayList<>();
        specialities.add(new Speciality(SpecialityType.FP));
        specialities.add(new Speciality(SpecialityType.GP));

        Provider provider = new Provider("", ProviderType.PCP, specialities);
        assertTrue("Should have passed for PCP provider with FP and GP",
                ruleService.executeRulesForProvider(provider));
    }
}