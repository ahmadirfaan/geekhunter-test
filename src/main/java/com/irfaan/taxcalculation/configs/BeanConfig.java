package com.irfaan.taxcalculation.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeanConfig {


    @Bean
    public Map<String, String> taxStrategyMap() {
        Map<String, String> stringTaxStrategyHashMap = new HashMap<>();
//        TaxStrategy taxVietnamStrategy = (TaxStrategy) applicationContext.getBean("taxVietnamStrategy");
        stringTaxStrategyHashMap.put("IDR", "taxIndonesianStrategy");
//        stringTaxStrategyHashMap.put("VND", taxVietnamStrategy);
        return stringTaxStrategyHashMap;
    }

}
