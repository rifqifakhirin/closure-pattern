package com.example.closure.pattern.configuration;

import com.example.closure.pattern.closures.HierarchyService;
import com.example.closure.pattern.entity.DepositApproval;
import com.example.closure.pattern.entity.DepositApprovalClosure;
import com.example.closure.pattern.service.TransferApprovalService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClosureConfiguration {

//    @Bean
//    @Qualifier("DepositClosurePatternService")
//    public ClosurePatternService getDepositApproval() {
//        return new ClosurePatternService<DepositApproval, DepositApprovalClosure, Long>();
//    }

    @Bean
    @Qualifier("DepositClosurePatternService")
    public HierarchyService getService() {
        return new HierarchyService<DepositApproval, DepositApprovalClosure, Long>();
    }

    @Bean
    @Qualifier("TransferService")
    public TransferApprovalService getServices() {
        return new TransferApprovalService();
    }

//    @Bean
//    @Qualifier("CashoutClosurePatternService")
//    public ClosurementPatternService<CashoutApproval, CashoutApprovalClosure, Long> getCashoutClosureService() {
//        return new ClosurementPatternService<>();
//    }



//    @Bean
//    @Qualifier("ServiceRestTemplate")
//    public RestTemplate getInterServiceRestTemplate() {
//        RestTemplate restTemplate = new RestTemplateBuilder()
//                .setReadTimeout(Duration.ofMillis(readTimeout))
//                .setConnectTimeout(Duration.ofMillis(connectionTimeout))
//                .build();
//        restTemplate.getMessageConverters().add(getMappingJackson2HttpMessageConverter());
//        return restTemplate;
//    }
}
