package com.uggthon.team01.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

// Swagger 접속 주소
// http://localhost:8080/swagger-ui/index.html#/
// https://{ip-address}:8080/swagger-ui/index.html

@Configuration
public class SwaggerConfig {

  @Value("${server.servlet.context-path:}")
  private String contextPath;

  @Bean
  public OpenAPI customOpenAPI() {
    Server localServer = new Server();
    localServer.setUrl(contextPath);
    localServer.setDescription("Local Server");

    Server prodServer = new Server();
    prodServer.setUrl("https://16.171.3.150:8080/swagger-ui/index.html");
    prodServer.setDescription("Production Server");

    return new OpenAPI()
        .addServersItem(localServer)
        .addServersItem(prodServer)
        .info(new Info().title("UGGThon 명세서").version("1.0").description("UGGThon Swagger"));
  }

  @Bean
  public GroupedOpenApi customGroupedOpenApi() {
    return GroupedOpenApi.builder().group("api").pathsToMatch("/**").build();
  }
}
