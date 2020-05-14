package com.shareniu.Test;

import com.shareniu.Test.bean.ValueBean;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/11
 * @Version V1.0
 **/
public class RepositoryServiceTest {
    ProcessEngineConfigurationImpl processEngineConfiguration;
    RepositoryService repositoryService;
    RuntimeService runtimeService;
    TaskService taskService;
    DecisionService decisionService;

    @Before
    public void init() {
        processEngineConfiguration = (ProcessEngineConfigurationImpl) ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("com/shareniu/test/camunda.cfg.xml");
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        repositoryService = processEngine.getRepositoryService();
        runtimeService = processEngine.getRuntimeService();
        taskService = processEngine.getTaskService();
        decisionService = processEngine.getDecisionService();
    }

    @Test
    public void createDeployment() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("testttttttttt")
                .source("本地测试")
                .tenantId("var")
                .addClasspathResource("com/shareniu/test/service1.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void startProcessInstanceByKeyService1() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "1");
        ProcessInstance processInstance = runtimeService.
                createProcessInstanceByKey("service1").setVariables(map).execute();
    }

    @Test
    public void repositoryServiceQuery() {
        ProcessDefinition a = repositoryService.createProcessDefinitionQuery().tenantIdIn("var").latestVersion().singleResult();
        System.out.println(a);
        System.out.println(a.getDescription());
        System.out.println(a.getVersion());
        System.out.println(a.getName());
    }

    @Test
    public void repositoryServiceQueryByVersion() {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("service1")
                .tenantIdIn("var").processDefinitionVersion(6).singleResult();
        System.out.println(processDefinition.getId());
    }

    @Test
    public void startProcessInstanceById() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "1");
        ProcessInstance processInstance = runtimeService.startProcessInstanceById("leave:1:603", map);
        System.out.println(processInstance);
    }

    @Test
    public void startProcessInstanceByKey() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "1");
        ProcessInstance processInstance = runtimeService.
                createProcessInstanceByKey("leave").setVariables(map).execute();
    }

    @Test
    public void startProcessInstanceByKeyAndId() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "1");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave","vaddr", map);
    }

    @Test
    public void service1() {
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey("service1","123456");
    }

    @Test
    public void service2() {
        Map<String, Object> map = new HashMap<>();
        map.put("test", new ValueBean("okokok"));
        map.put("result","fdfsdf");
        ProcessInstanceWithVariables service2 = runtimeService.
                createProcessInstanceByKey("service2").setVariables(map).executeWithVariablesInReturn();
        System.out.println("result:" + service2.getVariables().values());
    }

    @Test
    public void service3() {
        Map<String, Object> map = new HashMap<>();
        map.put("test", new ValueBean("okokok"));
        map.put("result","fdfsdf");
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey("service3","123456",map);
    }

    @Test
    public void msg1() {
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByMessage("msgname");
    }

    @Test
    public void msg2() {
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByMessage("msg2_2");
    }

    @Test
    public void signal1() {
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey("signal5");
    }

    @Test
    public void time1() {
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey("time3");
    }


    @Test
    public void tripDeployment() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("trip")
                .source("trip")
                .addClasspathResource("com/shareniu/test/trip.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void trip() {
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("trip");
    }

    @Test
    public void error1Deployment() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("error1")
                .source("error1")
                .addClasspathResource("com/shareniu/test/error1.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void error1() {
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("Process_1q3886a");
    }

}
