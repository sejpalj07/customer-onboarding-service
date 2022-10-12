package com.incedo.workflow.delegate;

import com.incedo.workflow.model.CBRResult;
import com.incedo.workflow.model.DataRequest;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component("CBRResponse")
public class CBRResponse implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CBRResponse");
        CBRResult cbrResult = (CBRResult) execution.getVariable("cbrResult");
        Map<String, Object> variables = new HashMap<>();
        variables.put("cbrResult", cbrResult);
        variables.put("cbrDecision", cbrResult.getDecision());

        execution.getProcessEngineServices()
                .getRuntimeService().correlateMessage("Message_CBR_Response",
                        execution.getProcessInstance().getProcessBusinessKey(), variables);
    }
}
