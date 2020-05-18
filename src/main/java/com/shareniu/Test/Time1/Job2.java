package com.shareniu.Test.Time1;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName Job2
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/16
 * @Version V1.0
 **/
public class Job2 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("job2,index:"+execution.getVariable("index"));
    }
}
