package by.bsuir.aipos.springrest;

import by.bsuir.aipos.springrest.controller.converter.ArticleConverter;
import by.bsuir.aipos.springrest.controller.converter.ArticleConverterImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRestApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringRestApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

	@Bean
	public ArticleConverter articleConverter() {
		return new ArticleConverterImpl();
	}
}
