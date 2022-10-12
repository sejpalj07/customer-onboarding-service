package com.incedo.workflow.delegate;

import com.incedo.workflow.model.DataRequest;
import com.incedo.workflow.model.IdentityResult;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.EventSubscription;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component("IdentityResponse")
public class IdentityResponse implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("IdentityResponse");
        IdentityResult identityResult = (IdentityResult) execution.getVariable("identityResult");
        Map<String, Object> variables = new HashMap<>();
        variables.put("identityResult", identityResult);
        variables.put("identityDecision", identityResult.getDecision());

        execution.getProcessEngineServices()
                .getRuntimeService().correlateMessage("Message_Identity_Response",
                execution.getProcessInstance().getProcessBusinessKey(), variables);
    }
}
