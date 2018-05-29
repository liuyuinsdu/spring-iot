package com.runhang.framework.mqtt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.runhang.framework.mqtt")
public class MqttProperties {
    private MqttInboundProperties inbound;
    private MqttOutboundProperties outbound;
    public MqttInboundProperties getInbound() {
        return inbound;
    }
    public void setInbound(MqttInboundProperties inbound) {
        this.inbound = inbound;
    }
    public MqttOutboundProperties getOutbound() {
        return outbound;
    }
    public void setOutbound(MqttOutboundProperties outbound) {
        this.outbound = outbound;
    }
}
