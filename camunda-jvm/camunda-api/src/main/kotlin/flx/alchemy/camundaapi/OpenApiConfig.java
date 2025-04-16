package flx.alchemy.camundaapi;
//   import io.swagger.v3.oas.models.ExternalDocumentation;
//   import io.swagger.v3.oas.models.OpenAPI;
//   import io.swagger.v3.oas.models.info.Info;
//   import org.springdoc.core.GroupedOpenApi;
//   import org.springframework.context.annotation.Bean;
//   import org.springframework.context.annotation.Configuration;
//
//   @Configuration
//   public class OpenApiConfig {
//
//       @Bean
//       public OpenAPI customOpenAPI() {
//           return new OpenAPI()
//                   .info(new Info()
//                           .title("Camunda REST API")
//                           .version("1.0")
//                           .description("API documentation for Camunda REST endpoints"))
//                   .externalDocs(new ExternalDocumentation()
//                           .description("Camunda Documentation")
//                           .url("https://docs.camunda.org"));
//       }
//
//       @Bean
//       public GroupedOpenApi camundaApi() {
//           return GroupedOpenApi.builder()
//                   .group("camunda")
//                   .pathsToMatch("/engine-rest/**")
//                   .build();
//       }
//   }
