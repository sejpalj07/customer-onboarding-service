package com.incedo.workflow;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incedo.workflow.delegate.*;
import com.incedo.workflow.model.DataRequest;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRule;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.camunda.bpm.scenario.ProcessScenario;
import org.camunda.bpm.scenario.Scenario;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.nio.file.Paths;
import java.util.Map;

import static org.mockito.Mockito.*;

@Deployment(resources = {"CustomerOnboard.bpmn", "Address.bpmn", "CBR.bpmn", "CBSStatusDRD.dmn", "Credit.bpmn"})
public class CustomerOnboardingTest {
    public static final String DRDCBSStatusDecision = "DRDCBSStatusDecision";

    @Rule
    @ClassRule
    public static TestCoverageProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create()
            .excludeProcessDefinitionKeys(DRDCBSStatusDecision)
            .assertClassCoverageAtLeast(0.02)
            .build();
    @Mock
    private ProcessScenario CustomerOnBoard;

    @Mock
    private ProcessScenario Process_Address;

    @Mock
    private ProcessScenario Process_Credit;

    @Mock
    private ProcessScenario Process_CBR;


    @Before
    public void defaultScenario() {
        MockitoAnnotations.initMocks(this);
        Mocks.register("CustomerInformation", new CustomerInformation());
        IdentityRequest identityRequest = new IdentityRequest();

        Mocks.register("IdentityRequest", mock(IdentityRequest.class));
        Mocks.register("IdentityDocs", new IdentityDocs());
        Mocks.register("IdentityAPI", new IdentityAPI());
        Mocks.register("IdentityResponse", mock(IdentityResponse.class));

        Mocks.register("CreditRequest", mock(CreditRequest.class));
        Mocks.register("CreditDocs", new CreditDocs());
        Mocks.register("CreditAPI", new CreditAPI());
        Mocks.register("CreditResponse", mock(CreditResponse.class));

        Mocks.register("CBRRequest", mock(CBRRequest.class));
        Mocks.register("CBRDocs", new CBRDocs());
        Mocks.register("CRBAPI", new CRBAPI());
        Mocks.register("CBRResponse", mock(CBRResponse.class));

        when(CustomerOnBoard.waitsAtUserTask("SP_gather_info_agent_Task"))
                .thenReturn(task -> {
                    task.complete();
                });
        when(CustomerOnBoard.waitsAtUserTask("UT_ack_customer"))
                .thenReturn(task -> {
                    task.complete();
                });
        when(CustomerOnBoard.waitsAtEventBasedGateway("Gateway_identity"))
                .thenReturn(event -> {
                    event.getEventSubscription().receive();
                });
        when(CustomerOnBoard.waitsAtEventBasedGateway("Gateway_credit"))
                .thenReturn(event -> {
                    event.getEventSubscription().receive();
                });
        when(CustomerOnBoard.waitsAtEventBasedGateway("Gateway_CBR"))
                .thenReturn(event -> {
                    event.getEventSubscription().receive();
                });
        when(CustomerOnBoard.waitsAtUserTask("UT_upload_docs"))
                .thenReturn(task -> {
                    task.complete();
                });
        when(CustomerOnBoard.waitsAtUserTask("UT_approve_CBS"))
                .thenReturn(task -> {
                    task.complete();
                });
    }

    @Test
    public void onlineCustomerOnBoardTest() throws Exception {
        String path = "src/test/resources/data/online_401K.json";
        ObjectMapper mapper = new ObjectMapper();
        DataRequest data = mapper.readValue(Paths.get(path).toFile(),
                new TypeReference<DataRequest>() {
                });
        Map<String, Object> dataRequest = mapper.convertValue(data, new TypeReference<Map<String, Object>>() {});
        Scenario.run(CustomerOnBoard)
                .startByMessage("Message_CBS", dataRequest)
                .execute();
        verify(CustomerOnBoard).hasCompleted("CBS_receive_info");
    }

    @Test
    public void agentCustomerOnBoardTest() throws Exception {
        String path = "src/test/resources/data/agent_401K.json";
        ObjectMapper mapper = new ObjectMapper();
        DataRequest data = mapper.readValue(Paths.get(path).toFile(),
                new TypeReference<DataRequest>() {
                });
        Map<String, Object> dataRequest = mapper.convertValue(data, new TypeReference<Map<String, Object>>() {});
        Scenario.run(CustomerOnBoard)
                .startByMessage("Message_CBS", dataRequest)
                .execute();

        verify(CustomerOnBoard).hasCompleted("CBS_receive_info");
    }

}
