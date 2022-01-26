package com.tut.camelmicroserviceb.routes;

import com.tut.camelmicroserviceb.beans.CurrencyExchangeBean;
import com.tut.camelmicroserviceb.processor.CurrencyExchangeProcessor;
import com.tut.camelmicroserviceb.transformator.CurrencyExchangeTranformator;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQReceiverRouter extends RouteBuilder {

    @Autowired
    private CurrencyExchangeProcessor currencyExchangeProcessor;

    @Autowired
    private CurrencyExchangeTranformator currencyExchangeTranformator;

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
        .unmarshal().json(JsonLibrary.Jackson, CurrencyExchangeBean.class)
        .bean(currencyExchangeProcessor)
        .bean(currencyExchangeTranformator)
        .to("log:received-message-from-activemq");
    }
}
