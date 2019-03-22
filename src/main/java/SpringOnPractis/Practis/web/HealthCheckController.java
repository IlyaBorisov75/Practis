package SpringOnPractis.Practis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringOnPractis.Practis.service.HealthService;



@RestController
public class HealthCheckController {
	@Autowired
	private HealthService healthService;
	
	@RequestMapping("/check")
	public String CheckStatus() {
		healthService.clearattemp();
	return	healthService.getHealth();
	}
}
