package SpringOnPractis.Practis.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import SpringOnPractis.Practis.persistence.PeopleRepository;
import model.SiteDto;
import model.people;

@Service
public class PeopleService {
	@Autowired
	private PeopleRepository Repository;
	@Autowired
	private StackExchangeClient StackExchangeClient;
	
	/*private static List<people> items = new ArrayList<>();
	static {
		items.add(new people("132", "aasdasda", 4545));
		items.add(new people("133", "asd", 221));	
		items.add(new people("134", "d", 678));	
		items.add(new people("135", "jtyjyt", 233));	
	}
	@PostConstruct
	public void init() {
		Repository.saveAll(items);
	}*/
	
	public List<people> findAll() {
		return StackExchangeClient.getSitesAll()
				.stream()
				.map(this::toPeople)
				.collect(Collectors.toList());
	}
	
	private people toPeople(SiteDto input) {
		return new people(
				input.getAudience(),
				input.getName(),
				0);
	}
	//ВЕРНУТЬ ПОТОМ
	/*public List<people> findAll() {
		return Repository.findAll();
	}*/
}
