package com.runhang.framework.mqtt;

import lombok.Data;

@Data
public class MqttOutboundProperties {
    private String urls;
    private String username;
    private String password;
    private String clientId;
    private String topic;
}
