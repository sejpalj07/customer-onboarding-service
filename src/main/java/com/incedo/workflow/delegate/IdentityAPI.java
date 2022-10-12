package com.incedo.workflow.delegate;

import camundajar.impl.com.google.gson.Gson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incedo.workflow.model.IdentityResult;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Slf4j
@Component("IdentityAPI")
public class IdentityAPI implements JavaDelegate {
    private final Gson gson = new Gson();
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("IdentityAPI");
        String url = "https://apimocha.com/customer-onboarding/customer/verify/1001";
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        IdentityResult identityResult = gson.fromJson(response.body(), IdentityResult.class);
        execution.setVariable("identityResult", identityResult);
        log.info("decision : " + identityResult.getDecision());
        log.info("data :" + identityResult);
        log.info("status : " + response.statusCode());
    }
}
