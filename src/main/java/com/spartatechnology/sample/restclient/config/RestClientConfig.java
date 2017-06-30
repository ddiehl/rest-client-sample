/**
 * Sparta Software Co.
 * 2017
 */
package com.spartatechnology.sample.restclient.config;

import java.security.KeyStore;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for The RestTemplate client.
 * Configures also two-way ssl certificates in case requested in the properties.
 * 
 * @author Daniel Conde Diehl - Sparta Technology
 *
 * History:
 *  Jun 30, 2017 - Daniel Conde Diehl
 */
@Configuration
public class RestClientConfig {
	
	
    @Value("${com.sparta.sample.two-way-ssl.enabled}")
    private boolean twoWayEnabled;
    
    @Value("${com.sparta.sample.two-way-ssl.trustStore.file:}")
    private Resource trustStore;

    @Value("${com.sparta.sample.two-way-ssl.trustStore.pass:}")
    private String trustStorePass;

    @Value("${com.sparta.sample.two-way-ssl.trustStore.type:}")
    private String trustStoreType;
    
    @Value("${com.sparta.sample.two-way-ssl.keyStore.file:}")
    private Resource clientCert;

    @Value("${com.sparta.sample.two-way-ssl.keyStore.pass:}")
    private String keyStorePass;

    @Value("${com.sparta.sample.two-way-ssl.keyStore.type:}")
    private String keyStoreType;

    @Value("${com.sparta.sample.two-way-ssl.enable-hostname-verifier}")
    private boolean enableHostnameVerifier;
    
    @Autowired
    private HttpComponentsClientHttpRequestFactory sender;
    
    
    /**
     * Creates http client using provided key and trust
     * 
     * @return the new HttpComponents client bean
     * @throws Exception In case something failed while creating the Bean
     */
    @Bean
    public HttpComponentsClientHttpRequestFactory httpComponentsSender() throws Exception {
        
        // Load client Key
        KeyStore keyStoreId = KeyStore.getInstance(keyStoreType);
        keyStoreId.load(clientCert.getInputStream(), keyStorePass.toCharArray());

        // Load trustStore
        KeyStore keyStoreTrust = KeyStore.getInstance(trustStoreType);
        keyStoreTrust.load(trustStore.getInputStream(), trustStorePass.toCharArray());

        // Configure SSL context
        SSLContext sslcontext = SSLContexts.custom().useProtocol(SSLConnectionSocketFactory.TLS)
                .loadTrustMaterial(keyStoreTrust, new TrustSelfSignedStrategy()).loadKeyMaterial(keyStoreId, keyStorePass.toCharArray()).build();

        // select what kind of hostname verifier
        HostnameVerifier hostnameVerifier;
        if (!enableHostnameVerifier) {
            hostnameVerifier = new NoopHostnameVerifier();
        } else {
            hostnameVerifier = new DefaultHostnameVerifier();
        }

        // Configure SSL Socket Factory
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hostnameVerifier);

        // Create the HttpClient
        CloseableHttpClient httpClient = HttpClients.custom()
                                            .setSSLSocketFactory(sslsf)
                                            .build();
        
        // return httpclient just built
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
	
	/**
	 * Creates a Rest Template Bean and adds to the context.
	 * 
	 * @param builder RestTemplateBuilder
	 * @return new generated bean
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.build();
		if (twoWayEnabled) {
			restTemplate.setRequestFactory(sender);
		} 
		return restTemplate;
	}
}
