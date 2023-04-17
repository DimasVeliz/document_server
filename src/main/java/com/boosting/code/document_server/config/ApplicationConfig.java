package com.boosting.code.document_server.config;

import com.boosting.code.Config.WebConfig;
import com.boosting.code.Services.Impl.ProxyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {


    @Bean
    public WebConfig webConfig() {
        return new WebConfig();
    }
    @Bean
    public ProxyServiceImpl proxyServiceImpl() {
        return new ProxyServiceImpl(webConfig());
    }

}