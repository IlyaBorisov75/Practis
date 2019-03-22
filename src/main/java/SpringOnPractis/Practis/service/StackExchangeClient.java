package SpringOnPractis.Practis.service;

import java.net.*;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import model.SiteDto;
import model.SitesDto;

@Component
public class StackExchangeClient {
	HttpClient httpCkient = HttpClientBuilder.create().build();
	ClientHttpRequestFactory RequestFactory = new HttpComponentsClientHttpRequestFactory(httpCkient);
	private RestTemplate restTemplate = new RestTemplate(RequestFactory);
	public List<SiteDto> getSitesAll(){
		String Url ="https://api.stackexchange.com/2.2/sites?page=1&pagesize=99999&filter=!)Qpa1bGM81fD6w8NLXi88*.1";
		
		try {
			SitesDto response = restTemplate.getForObject(new URI(Url), SitesDto.class);
			return response.getItems();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
