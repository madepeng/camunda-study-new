package com.shareniu.Test.gatewayvars;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName SetVars
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/27
 * @Version V1.0
 **/
public class SetVars implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("a" ,1);
        execution.setVariable("b" ,2);
        execution.setVariable("c" ,3);
        execution.setVariable("ff" ,true);
    }
}
