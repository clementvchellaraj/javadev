package org.clmdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;

@SpringBootApplication
@EnableDiscoveryClient
public class CityRestCrudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityRestCrudServiceApplication.class, args);
	}
	
	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		Tracer tracer = Configuration.fromEnv().getTracer();
		return tracer;
	}

}
