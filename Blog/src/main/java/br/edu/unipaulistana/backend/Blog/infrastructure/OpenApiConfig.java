package br.edu.unipaulistana.backend.Blog.infrastructure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Api de exemplo: Blog")
                        .version("1.0")
                        .description("Descrição do que o serviço irá fazer")
                );
    }
}
