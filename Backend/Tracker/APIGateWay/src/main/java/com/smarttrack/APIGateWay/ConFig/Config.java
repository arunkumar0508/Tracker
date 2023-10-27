package com.smarttrack.APIGateWay.ConFig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

 @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/hospitals/**")
                        .uri("lb://user-hospital-service"))

                .route(p -> p
                        .path("/apii/doctor/**")
                        .uri("lb://user-doctor-service"))
                .build();


    }

}
