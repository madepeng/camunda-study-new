package com.shareniu.Test;

import com.shareniu.Test.bean.ValueBean;
import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.repository.Deployment;
import org.camunda.bpm.engine.repository.DeploymentBuilder;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.repository.ProcessDefinitionQuery;
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
    ManagementService managementService;

    @Before
    public void init() {
        processEngineConfiguration = (ProcessEngineConfigurationImpl) ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("com/shareniu/test/camunda.cfg.xml");
        processEngineConfiguration.setJobExecutorActivate(true);
        processEngineConfiguration.setJobExecutorAcquireByDueDate(true);
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        repositoryService = processEngine.getRepositoryService();
        runtimeService = processEngine.getRuntimeService();
        taskService = processEngine.getTaskService();
        decisionService = processEngine.getDecisionService();
        managementService = processEngine.getManagementService();
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
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave", "vaddr", map);
    }

    @Test
    public void service1() {
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey("service1", "123456");
    }

    @Test
    public void service2() {
        Map<String, Object> map = new HashMap<>();
        map.put("test", new ValueBean("okokok"));
        map.put("result", "fdfsdf");
        ProcessInstanceWithVariables service2 = runtimeService.
                createProcessInstanceByKey("service2").setVariables(map).executeWithVariablesInReturn();
        System.out.println("result:" + service2.getVariables().values());
    }

    @Test
    public void service3() {
        Map<String, Object> map = new HashMap<>();
        map.put("test", new ValueBean("okokok"));
        map.put("result", "fdfsdf");
        ProcessInstance processInstance = runtimeService.
                startProcessInstanceByKey("service3", "123456", map);
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

    @Test
    public void cancel1Deployment() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("cancel1")
                .source("cancel1")
                .addClasspathResource("com/shareniu/test/cancel1.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void cancel1() {
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("cancel1");
    }

    @Test
    public void callDeployment() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("pool")
                .source("pool")
                .addClasspathResource("com/shareniu/test/pool.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void call() {
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("Process_1to6arj");
    }

    @Test
    public void groupDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("group")
                .source("group")
                .addClasspathResource("com/shareniu/test/group.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void group() {
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("group");
    }

    @Test
    public void varDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("var")
                .source("var")
                .addClasspathResource("com/shareniu/test/var.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void var() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 1);
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("var", map);
    }

    @Test
    public void timerDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("timer")
                .source("timer")
                .addClasspathResource("com/shareniu/test/timer.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void timer() throws InterruptedException {
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("timer");
        System.out.println("end");
    }

    @Test
    public void timer1Del() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("time4")
                .source("time4")
                .addClasspathResource("com/shareniu/test/time4.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void timer1() {
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("time4");
    }

    @Test
    public void timer1job1() {
        managementService.executeJob("19906");
    }


    @Test
    public void timer2Del() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("timer2")
                .source("timer2")
                .addClasspathResource("com/shareniu/test/timer2.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void timer2() {
        Map<String, Object> map = new HashMap<>();
        map.put("index", 0);
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("Process_0n3nq5d", map);
    }


    @Test
    public void dmn1Del() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("dmn1")
                .source("dmn1")
                .addClasspathResource("com/shareniu/test/dmn1.dmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void dmn1() {
        Map<String, Object> map = new HashMap<>();
        map.put("InputValue", 1);
        DmnDecisionResult dmn1 = decisionService.evaluateDecisionByKey("Decision_Test").variables(map).evaluate();
        System.out.println(dmn1.getSingleResult().getEntryMap());
    }


    @Test
    public void dm1_processDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("dm1_process")
                .source("dm1_process")
                .addClasspathResource("com/shareniu/test/dm1_process.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void dm1_process() {
        Map<String, Object> map = new HashMap<>();
        map.put("InputValue", 1);
        ProcessInstanceWithVariables dm1_process = runtimeService.createProcessInstanceByKey("dm1_process").setVariables(map).executeWithVariablesInReturn();
        System.out.println(dm1_process.getVariables().get("result"));
    }


    @Test
    public void gatewayDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("gateway")
                .source("gateway")
                .addClasspathResource("com/shareniu/test/gateway.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void gateway() {
        Map<String, Object> map = new HashMap<>();
        map.put("index", 0);
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("gateway", map);
    }

    @Test
    public void lastVersion() {
        int gateway = repositoryService.createProcessDefinitionQuery().processDefinitionKey("gateway").latestVersion().singleResult().getVersion();
        System.out.println("result:" + gateway);
    }

    @Test
    public void BOF_WITHDRAWDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("BOF_WITHDRAW")
                .source("BOF_WITHDRAW")
                .addClasspathResource("com/shareniu/test/BOF_WITHDRAW.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void BOF_WITHDRAW() {
        Map<String, Object> map = new HashMap<>();
        map.put("index", 0);
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("gateway", map);
    }


    @Test
    public void listenerDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("listener")
                .source("listener")
                .addClasspathResource("com/shareniu/test/listener.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void listener() {
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("listener");
    }

    @Test
    public void gatewayvarsDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("gatewayvars")
                .source("gatewayvars")
                .addClasspathResource("com/shareniu/test/gatewayvars.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void gatewayvars() {
        Map<String, Object> map = new HashMap<>();
        map.put("index", 0);
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("gatewayvars", map);
    }


    @Test
    public void COMPOSITION_WITHDRAWDel() {
        DeploymentBuilder deploymentBuilder = repositoryService.createDeployment();
        Deployment deployment = deploymentBuilder
                .name("COMPOSITION_WITHDRAWDel")
                .source("COMPOSITION_WITHDRAWDel")
                .addClasspathResource("com/shareniu/test/COMPOSITION_WITHDRAW.bpmn")
                .deploy();
        System.out.println("result:" + deployment);
    }

    @Test
    public void COMPOSITION_WITHDRAW() {
        Map<String, Object> map = new HashMap<>();
        map.put("index", 0);
        ProcessInstance trip = runtimeService.
                startProcessInstanceByKey("gatewayvars", map);
    }
}
