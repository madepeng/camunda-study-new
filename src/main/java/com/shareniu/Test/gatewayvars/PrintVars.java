package com.shareniu.Test.gatewayvars;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName PrintVars
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/28
 * @Version V1.0
 **/
public class PrintVars implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("vars:" + execution.getVariables());
    }
}
