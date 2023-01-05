package com.irfaan.taxcalculation.configs;

import com.irfaan.taxcalculation.strategy.TaxStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeanConfig {


    @Bean
    public Map<String, TaxStrategy> taxStrategyMap(ApplicationContext applicationContext) {
        HashMap<String, TaxStrategy> stringTaxStrategyHashMap = new HashMap<>();
        TaxStrategy taxIndonesianStrategy = (TaxStrategy) applicationContext.getBean("taxIndonesianStrategy");
        TaxStrategy taxVietnamStrategy = (TaxStrategy) applicationContext.getBean("taxVietnamStrategy");
        stringTaxStrategyHashMap.put("IDR", taxIndonesianStrategy);
        stringTaxStrategyHashMap.put("VND", taxVietnamStrategy);
        return stringTaxStrategyHashMap;
    };

}
