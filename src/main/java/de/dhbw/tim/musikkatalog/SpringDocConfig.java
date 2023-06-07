package de.dhbw.tim.musikkatalog;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Musikkatalog API")
                                .description("Diese API stellt Informationen zu Musiktiteln zur Verfügung.")
                                .version("V1")
                                .contact(new Contact().name("Marcus Unglert").email("unglert.marcus-it22@it.dhbw-ravensburg.de"))
                                .license(new License().name("MIT"))
                );
    }
}
