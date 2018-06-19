package com.xyz.test.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.xyz.test.interceptor.RestTemplateInterceptor;
import com.xyz.test.service.TeamService;

@Configuration
@ComponentScan("com.xyz.test")
public class TestAppConfig {
	@Autowired
	private TeamService teamService;
	
	@Bean
	RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        restTemplate.setInterceptors(Collections.singletonList(new RestTemplateInterceptor()));
        
        return restTemplate;
	}
	  
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	System.out.println("onApplicationEvent...");
    	teamService.loadAllTeams(); 
    }
    
	private ClientHttpRequestFactory clientHttpRequestFactory() {
	    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
	    factory.setReadTimeout(2000);
	    factory.setConnectTimeout(2000);
	    
	    return factory;
	} 
}
