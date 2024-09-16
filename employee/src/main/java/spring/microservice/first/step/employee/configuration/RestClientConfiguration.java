package spring.microservice.first.step.employee.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestClientConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
