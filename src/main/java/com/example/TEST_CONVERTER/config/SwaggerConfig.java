//package com.example.TEST_CONVERTER.config;
//
//
//import com.example.TEST_CONVERTER.dto.ConverterDto;
//import com.fasterxml.classmate.TypeResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    private final TypeResolver typeResolver;
//
//    public SwaggerConfig(TypeResolver typeResolver){
//        this.typeResolver = typeResolver;
//    }
//
//    public static final String TAG = "Number Converter";
//
//    @Bean
//    public Docket api()
//    {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .useDefaultResponseMessages(false)
//                .additionalModels(typeResolver.resolve(ConverterDto.class))
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.ConverterTest"))
//                .paths(regex("/.*"))
//                .build();
//                //.tags(new Tag(TAG, "Конвертация"));
//    }
//
//    private ApiInfo apiInfo()
//    {
//        return new ApiInfoBuilder()
//                .title("Converter")
//                .description("Сервис для конвертации числа в строку и обратно")
//                .version("2.0")
//                .build();
//    }
//
//}
