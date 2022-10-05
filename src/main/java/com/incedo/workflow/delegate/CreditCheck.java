package com.incedo.workflow.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component("CreditCheck")
public class CreditCheck implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CreditCheck");
    }
}
