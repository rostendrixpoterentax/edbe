package ru.kasovsky.edbe.hsql.cfg;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kasovsky.edbe.h2.res.SmallResource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDeployerApiDocket() {
        return getDocket(SmallResource.PATH, SmallResource.TAG, SmallResource.DESC);
    }

    private Docket getDocket(String path, String tag, String description) {

        String[] paths = path.split(";");

        StringBuilder sb = new StringBuilder();
        sb.append("/(");

        int i = 0;
        for (String p: paths) {
            i++;
            sb.append(p.replace("/", ""));
            sb.append("/");
            if (paths.length > 1 && i < paths.length)
                sb.append("|");
        }
        sb.append(").*");

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //.paths(PathSelectors.regex(sb.toString()))
                .build()
                .apiInfo(apiInfo(tag, description));
    }

    private ApiInfo apiInfo(String name, String description) {

        return new ApiInfoBuilder()
                .title(name + "TracePharm")
                .description(description)
                .version("v1")
                .termsOfServiceUrl("http://terms-of-services.url")
                .license("Apache License Version 2.0")
                .licenseUrl("https://apache.org/licenses/LICENSE-2.0.txt")
                .build();
    }
}
*/