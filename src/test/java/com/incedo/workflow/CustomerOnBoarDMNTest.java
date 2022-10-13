package com.incedo.workflow;

import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.junit.Rule;
import org.junit.Test;

import static org.camunda.bpm.engine.test.assertions.bpmn.AbstractAssertions.init;
import static org.camunda.bpm.engine.test.assertions.bpmn.AbstractAssertions.processEngine;
import static org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests.withVariables;
import static org.junit.Assert.assertEquals;

public class CustomerOnBoarDMNTest {
    private static final String PROCESS_KEY = "sampleTest";
    @Rule
    public ProcessEngineRule rule = new ProcessEngineRule();
    @Test
    public void setup() {
        init(rule.getProcessEngine());
    }

    @Test
    @Deployment(resources = {"CBSStatusDRD.dmn"})
    public void testDMN_case_I() {
        DmnDecisionResult dmnDecisionResult = processEngine().getDecisionService()
                .evaluateDecisionByKey("DRDCBSStatusDecision")
                .variables(withVariables("identityDecision", "Approved", "cbrDecision", "Approved", "creditScore", 650))
                .evaluate();
        assertEquals(1, dmnDecisionResult.size());
        assertEquals(dmnDecisionResult.get(0).values().toString(), "[gold]");
    }

    @Test
    @Deployment(resources = {"CBSStatusDRD.dmn"})
    public void testDMN_case_II() {
        DmnDecisionResult dmnDecisionResult = processEngine().getDecisionService()
                .evaluateDecisionByKey("DRDCBSStatusDecision")
                .variables(withVariables("identityDecision", "Approved", "cbrDecision", "Approved", "creditScore", 750))
                .evaluate();
        assertEquals(1, dmnDecisionResult.size());
        assertEquals(dmnDecisionResult.get(0).values().toString(), "[premium]");
    }

    @Test
    @Deployment(resources = {"CBSStatusDRD.dmn"})
    public void testDMN_case_III() {
        DmnDecisionResult dmnDecisionResult = processEngine().getDecisionService()
                .evaluateDecisionByKey("DRDCBSStatusDecision")
                .variables(withVariables("identityDecision", "Approved", "cbrDecision", "Denied", "creditScore", 770))
                .evaluate();
        assertEquals(1, dmnDecisionResult.size());
        assertEquals(dmnDecisionResult.get(0).values().toString(), "[Not Qualified] ");
    }

}
