package com.incedo.workflow.delegate;

import com.incedo.workflow.model.CreditResult;
import com.incedo.workflow.model.DataRequest;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component("CreditResponse")
public class CreditResponse implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CreditResponse");
        CreditResult creditResult = (CreditResult) execution.getVariable("creditResult");
        Map<String, Object> variables = new HashMap<>();
        variables.put("creditResult", creditResult);
        variables.put("creditScore", creditResult.getCreditScore());

        execution.getProcessEngineServices()
                .getRuntimeService().correlateMessage("Message_Credit_Response",
                        execution.getProcessInstance().getProcessBusinessKey(), variables);
    }
}
