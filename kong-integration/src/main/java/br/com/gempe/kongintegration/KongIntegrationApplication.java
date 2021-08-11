package br.com.gempe.kongintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KongIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(KongIntegrationApplication.class, args);
	}

}
