package com.tut.camelmicroserviceb.routes;

import com.tut.camelmicroserviceb.beans.CurrencyExchangeBean;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQReceiverRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
        .unmarshal().json(JsonLibrary.Jackson, CurrencyExchangeBean.class)
        .to("log:received-message-from-activemq");
    }
}
