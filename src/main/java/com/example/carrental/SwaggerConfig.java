package com.example.carrental;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {




    @Bean
    public GroupedOpenApi api() {
        String[] packagesToScan = {"com.example.carrental"};
        return GroupedOpenApi.builder()
                .packagesToScan(packagesToScan)
                .group("api")
                .build();
    }

}
