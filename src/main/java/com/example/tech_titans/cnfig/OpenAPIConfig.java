package com.example.tech_titans.cnfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("Chill's Tunisie").description("Restaurant Chill's").contact(contactAPI());
    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Hatem Boudabra").email("hatem.boudabra@esprit.tn").url("https://www.linkedin.com/in/hatem-boudabra-3a17b8213/");
        return contact;
    }
}
