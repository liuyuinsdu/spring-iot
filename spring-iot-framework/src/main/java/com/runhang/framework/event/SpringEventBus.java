package com.runhang.framework.event;

import org.springframework.context.ApplicationContext;

/**
 * @author runhang
 * @create 2018-02-10 上午7:24
 **/
public class SpringEventBus extends ApplicationEventBus {

    private ApplicationContext applicationContext;

    public SpringEventBus(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <E> void publishEvent(E event) {
        this.applicationContext.publishEvent(event);
    }
}
