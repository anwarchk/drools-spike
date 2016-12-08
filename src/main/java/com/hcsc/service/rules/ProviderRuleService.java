package com.hcsc.service.rules;


import com.hcsc.rules.domain.Provider;

public interface ProviderRuleService {

    boolean executeRulesForProvider(Provider provider);

}
