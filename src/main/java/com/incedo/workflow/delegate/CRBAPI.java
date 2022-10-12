package com.incedo.workflow.delegate;

import camundajar.impl.com.google.gson.Gson;
import com.incedo.workflow.model.CBRResult;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component("CRBAPI")
public class CRBAPI implements JavaDelegate {
    private final Gson gson = new Gson();
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CRBAPI");
        String url = "https://apimocha.com/customer-onboarding/customer/verifyCRB/1001";
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        CBRResult cbrResult = gson.fromJson(response.body(), CBRResult.class);
        execution.setVariable("cbrResult", cbrResult);
        log.info("Status : " + response.statusCode());
        log.info("Body : " + cbrResult);
    }
}
