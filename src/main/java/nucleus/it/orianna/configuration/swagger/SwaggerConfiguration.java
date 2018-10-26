package nucleus.it.orianna.configuration.swagger;

import nucleus.it.orianna.configuration.ApplicationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration
 * @author sansajn
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private final ApplicationProperties applicationProperties;

    public SwaggerConfiguration(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("nucleus.it.orianna.web.rest"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfo(
                applicationProperties.getSwagger().getTitle(),
                applicationProperties.getSwagger().getDescription(),
                applicationProperties.getSwagger().getVersion(),
                applicationProperties.getSwagger().getTermsOfServiceUrl(),
                applicationProperties.getSwagger().getContactName(),
                applicationProperties.getSwagger().getLicense(),
                applicationProperties.getSwagger().getLicenseUrl()
        );
    }
}
