package com.incedo.workflow.controller;

import com.incedo.workflow.model.DataRequest;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
@RestController
public class HomeController {
    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final Random random = new Random();
    String bKey;
    public HomeController(@Autowired RuntimeService runtimeService,@Autowired TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        bKey = String.valueOf(Math.abs(random.nextInt()));
    }

    @PostMapping("/process")
    public ResponseEntity<String> invokeProcess(@RequestBody DataRequest dataRequest) {
        log.info("InvokeProcess :" + dataRequest);
        Map<String, Object> variables = new HashMap<>();
        variables.put("dataRequest", dataRequest);
        variables.put("bKey", bKey);
        variables.put("status", "submitted");
        variables.put("applicationTypeCode", dataRequest.getApplicationTypeCode());
        variables.put("applicationProcess", dataRequest.getApplicationProcess());
        this.runtimeService.correlateMessage("Message_CBS", bKey, variables);
        return new ResponseEntity<>("Customer on-boarding BPM is Running.", HttpStatus.OK);
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody DataRequest dataRequest) {
        log.info("sendMessage :" + dataRequest);
        List<Execution> listProcessInstance = runtimeService.createExecutionQuery().list();
        String exeId = listProcessInstance.get(0).getId();
        log.info("exe id :" + exeId);
        log.info("bKey :" + bKey);
        Map<String, Object> variables = new HashMap<>();
        variables.put("status", "submitted");
        variables.put("dataRequest", dataRequest);
        this.runtimeService.correlateMessage("Message_abc", bKey, variables);
        return new ResponseEntity<>("Customer on-boarding BPM is Running.", HttpStatus.OK);
    }

    @PostMapping("/completeTask")
    public ResponseEntity<String> completeTask(){
        List<Task> taskList = this.taskService.createTaskQuery().active().list();
        this.taskService.complete(taskList.get(0).getId());
        return new ResponseEntity<>("Task completed with name :" + taskList.get(0).getTaskDefinitionKey(), HttpStatus.OK);
    }

}
