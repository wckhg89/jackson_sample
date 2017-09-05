package com.guppy.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanghonggu on 2017. 9. 5..
 */

@Configuration
public class RestConfig {


    @Bean(name = "jacksonObjectMapper")
    public ObjectMapper objectMapper () {
        return new ObjectMapper();
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter (ObjectMapper objectMapper) {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);

        return mappingJackson2HttpMessageConverter;

    }

    @Bean
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory () {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

        factory.setConnectTimeout(1000);
        factory.setReadTimeout(5000);

        return factory;
    }

    @Bean
    public RestTemplate restTemplate (HttpComponentsClientHttpRequestFactory factory, MappingJackson2HttpMessageConverter jackson2HttpMessageConverter) {
        RestTemplate restTemplate = new RestTemplate();


        List<HttpMessageConverter<?>> converters = new ArrayList();
        converters.add(jackson2HttpMessageConverter);

        restTemplate.setRequestFactory(factory);
        restTemplate.setMessageConverters(converters);

        return restTemplate;
    }


}
