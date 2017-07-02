package org.ibayer.personal.talktome.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * @return
	 */
	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		return docket.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, Arrays.asList(
						new ResponseMessageBuilder().code(500).message("Internal Server Error")
								.responseModel(new ModelRef("Error")).build(),
						new ResponseMessageBuilder().code(404).message("Not found").responseModel(new ModelRef("Error"))
								.build(),
						new ResponseMessageBuilder().code(403).message("Forbidden!").build()))
				.select().apis(RequestHandlerSelectors.basePackage("org.ibayer.personal.talktome.controller")).build();

	}
}
