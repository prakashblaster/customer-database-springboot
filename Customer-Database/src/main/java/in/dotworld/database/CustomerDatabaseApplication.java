package in.dotworld.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class CustomerDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDatabaseApplication.class, args);
		
	}

}
