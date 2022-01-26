package com.tut.camelmicroserviceb.processor;

import com.tut.camelmicroserviceb.beans.CurrencyExchangeBean;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CurrencyExchangeProcessor {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeBean.class);

    public void processMessage(CurrencyExchangeBean currencyExchangeBean) {
        logger.info("do some processing with getConversionMultiple() {}", currencyExchangeBean.getConversionMultiple());
    }
}
