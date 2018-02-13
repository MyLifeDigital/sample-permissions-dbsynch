package io.consentric.connector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackageClasses = EffectiveConsentsConnectorApplication.class, basePackages = "io.consentric.connector")
@EnableScheduling
@EnableJpaRepositories
public class EffectiveConsentsConnectorApplication {
	public static void main(String[] args) {
		SpringApplication.run(EffectiveConsentsConnectorApplication.class, args);
	}
}
