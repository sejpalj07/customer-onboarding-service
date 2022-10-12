package com.incedo.workflow.delegate;

import com.incedo.workflow.model.DataRequest;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component("CreditRequest")
public class CreditRequest implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CreditRequest");
        DataRequest dataRequest = (DataRequest) execution.getVariable("dataRequest");
        Map<String, Object> variables = new HashMap<>();
        variables.put("dataRequest", dataRequest);

        execution.getProcessEngineServices()
                .getRuntimeService().correlateMessage("Message_Credit_request",
                        execution.getProcessInstance().getProcessBusinessKey(), variables);
    }
}
