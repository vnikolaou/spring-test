package com.xyz.test.interceptor;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {
	private static final String X_USER_AGENT_HEADER = "X-User-Agent";
	private static final String X_USER_AGENT_HEADER_VALUE = "Test App";
	
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, 
    		ClientHttpRequestExecution execution) throws IOException {
    	
        HttpHeaders headers = request.getHeaders();
        headers.add(X_USER_AGENT_HEADER, X_USER_AGENT_HEADER_VALUE);
        
        return execution.execute(request, body);
    }
}
