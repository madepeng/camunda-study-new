package com.shareniu.Test.fail;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName Success1
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/14
 * @Version V1.0
 **/
public class Success1 implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("success");
    }
}
