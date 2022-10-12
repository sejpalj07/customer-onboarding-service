package com.incedo.workflow.delegate;

import camundajar.impl.com.google.gson.Gson;
import com.incedo.workflow.model.CreditResult;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Component("CreditAPI")
public class CreditAPI implements JavaDelegate {
    private final Gson gson = new Gson();
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CreditAPI");
        String url = "https://apimocha.com/customer-onboarding/customer/getCredit/1001";
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        CreditResult creditResult = gson.fromJson(response.body(), CreditResult.class);
        execution.setVariable("creditResult", creditResult);
        log.info("Status : " + response.statusCode());
        log.info("Body : " + creditResult);
    }
}
