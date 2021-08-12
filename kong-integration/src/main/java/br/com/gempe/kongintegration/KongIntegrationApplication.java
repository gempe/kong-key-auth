package br.com.gempe.kongintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class KongIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KongIntegrationApplication.class, args);
	}

}
