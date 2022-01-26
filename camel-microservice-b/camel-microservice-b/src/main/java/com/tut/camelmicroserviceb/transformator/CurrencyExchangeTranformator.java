package com.tut.camelmicroserviceb.transformator;

import com.tut.camelmicroserviceb.beans.CurrencyExchangeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyExchangeTranformator {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeBean.class);

    public CurrencyExchangeBean processMessage(CurrencyExchangeBean currencyExchangeBean) {

        BigDecimal valX10 = currencyExchangeBean.getConversionMultiple()
                .multiply(BigDecimal.TEN);

        logger.info("multiplying by 10 getConversionMultiple() {}", valX10);
        currencyExchangeBean.setConversionMultiple(valX10);
        return currencyExchangeBean;
    }
}
