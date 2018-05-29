package com.runhang.framework.event;

import lombok.Data;

import java.util.UUID;

/**
 * @author runhang
 * @create 2018-02-15 上午8:41
 **/
@Data
public abstract class AbstractEvent {

    // event id
    private String _id;
    private String sourceServiceName;

    public AbstractEvent() {
        this._id = UUID.randomUUID().toString();
    }
}
