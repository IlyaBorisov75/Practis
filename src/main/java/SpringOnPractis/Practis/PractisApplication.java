package SpringOnPractis.Practis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class PractisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractisApplication.class, args);
	}
	
}
