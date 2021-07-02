package pl.justifiction.springbootdemo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Arrays.asList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket SwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("justifiction-api")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("pl.justifiction.springbootdemo.controller"))
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,
                        asList(new ResponseMessageBuilder()
                                        .code(204)
                                        .message("No content to delete")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(404)
                                        .message("Word not found")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(400)
                                        .message("Input is wrong")
                                        .responseModel(new ModelRef("Error"))
                                        .build()));
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("REST Api with Spring Boot and Swagger2")
                .description("Simple REST Api with Spring Boot and Swagger. It allows to add or delete a word to/from a collection, " +
                        "to get the number of word's occurences and to get a list of unique words. It is also possible to see the entire collection (words and number of occurences)" +
                        " and to delete all the elements.")
                .contact(new Contact("Justyna Kotlarz",
                        "https://github.com/justifiction",
                        "justynakk5@wp.pl"))
                .version("1.0.1")
                .build();
    }


}
