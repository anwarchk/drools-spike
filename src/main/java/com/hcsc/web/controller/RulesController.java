package com.hcsc.web.controller;


import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RulesController {

    @Autowired
    private KieContainer kieContainer;

    @GetMapping
    public RuleResult triggerRules() {
        KieSession kSession = kieContainer.newKieSession("DecisionServiceSession");

//        // Add order to be validated
//        kSession.insert(provider);
//
//        Specialities specialities = new Specialities();
//        specialities.add("001");
//        specialities.add("008");
//        specialities.add("011");
//
//        kSession.insert(specialities);

        kSession.fireAllRules();

        kSession.dispose();

        //return provider.isValid();


        return new RuleResult();

    }

    static class RuleResult {
        private boolean valid = true;

        public boolean isValid() {
            return valid;
        }
    }

}
