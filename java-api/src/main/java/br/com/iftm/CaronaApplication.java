package br.com.iftm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class CaronaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaronaApplication.class, args);
	}

}
