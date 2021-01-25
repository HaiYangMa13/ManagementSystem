package com.springcloudt1.managerconsumer.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RibbonRule {
    @Bean
    public IRule ManagerRule(){
        return new RoundRobinRule();
    }
}
