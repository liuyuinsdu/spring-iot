package com.runhang.framework.event;

/**
 * @author runhang
 * @create 2018-02-10 上午7:23
 **/
public interface EventBus {

    <E> void publishEvent(E event);

}
