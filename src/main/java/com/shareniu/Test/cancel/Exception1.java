package com.shareniu.Test.cancel;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @ClassName Exception1
 * @Description: TODO
 * @Author madepeng
 * @Date 2020/5/14
 * @Version V1.0
 **/
public class Exception1 implements JavaDelegate {
    private static Integer count = 0;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        count++;
        System.out.println("excetion1,count:" + count);
        if (count.equals(1)) {
            throw new Exception("excetion1 happen");
        }
    }
}
