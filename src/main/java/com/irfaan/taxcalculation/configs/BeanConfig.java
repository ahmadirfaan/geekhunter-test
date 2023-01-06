package com.irfaan.taxcalculation.configs;

import com.irfaan.taxcalculation.strategy.TaxIndonesianStrategy;
import com.irfaan.taxcalculation.strategy.TaxStrategy;
import com.irfaan.taxcalculation.strategy.TaxVietnamStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeanConfig {


    @Bean(value = "taxStrategyHashMap")
    public Map<String, TaxStrategy> taxStrategyMap(TaxIndonesianStrategy taxIndonesianStrategy, TaxVietnamStrategy taxVietnamStrategy) {
        Map<String, TaxStrategy> stringTaxStrategyHashMap = new HashMap<>();
        stringTaxStrategyHashMap.put("IDR", taxIndonesianStrategy);
        stringTaxStrategyHashMap.put("VND", taxVietnamStrategy);
        return stringTaxStrategyHashMap;
    }

}
