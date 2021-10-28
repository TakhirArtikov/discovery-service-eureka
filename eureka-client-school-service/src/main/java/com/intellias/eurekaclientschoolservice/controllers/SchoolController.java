package com.intellias.eurekaclientschoolservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class SchoolController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/school-details/{schoolName}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String schoolName)
    {
        System.out.println("Getting School details for " + schoolName);

        String response = restTemplate.exchange("http://server/student-details-for-school/{schoolName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolName).getBody();

        System.out.println("Response Received as " + response);

        return "School Name -  " + schoolName + " \n Student Details " + response;
    }

    @RequestMapping("/port")
    public String hi() {
        String hello = this.restTemplate.getForObject("http://server/port", String.class);
        return hello;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
