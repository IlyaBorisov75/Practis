package SpringOnPractis.Practis.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HealthService {
	private RestTemplate restTemplate = new RestTemplate();
	private int attemp;
	
	public void clearattemp() {
		attemp=0;
	}
	
	@Retryable(maxAttempts = 10, value = RuntimeException.class, backoff = @Backoff(delay = 500, multiplier = 2))
	public String getHealth() {
		attemp++;
	return restTemplate.getForObject("http://localhost:8090/health", String.class) + "-" + attemp;
	}
	
	@Recover
	public String recover() {
	return "not OK";
	}
}
