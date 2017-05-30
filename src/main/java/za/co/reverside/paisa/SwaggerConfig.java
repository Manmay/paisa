package za.co.reverside.paisa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import com.wordnik.swagger.model.ApiInfo;

@Configuration
@EnableSwagger
class SwaggerConfig  {
	
	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
				apiInfo()).includePatterns("/.*");
	}
	
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Insurance API", "API for Insurance",
				"Insurance API terms of service", "patlolla25@gmail.com",
				"Insurance API Licence Type", "Insurance API License URL");
		return apiInfo;
	}
   
}
