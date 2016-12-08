package com.hcsc.service.rules;

import com.hcsc.rules.domain.Provider;
import com.hcsc.rules.domain.Specialities;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;


@Component
public class ProviderRuleServiceImpl implements ProviderRuleService {

    private final KieContainer kieContainer;

    public ProviderRuleServiceImpl(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Override
    public boolean executeRulesForProvider(Provider provider) {

        KieSession kSession = kieContainer.newKieSession("DecisionServiceSession");

        // Add order to be validated
        kSession.insert(provider);

        Specialities specialities = new Specialities();
        specialities.add("001");
        specialities.add("008");
        specialities.add("011");

        kSession.insert(specialities);

        kSession.fireAllRules();

        kSession.dispose();

        return provider.isValid();
    }
}
