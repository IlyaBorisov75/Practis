package SpringOnPractis.Practis.persistence;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import model.people;

@Repository
public interface PeopleRepository extends MongoRepository<people, String>{
List<people> findByName(String Name);
}

/*@Repository
public class PeopleRepository {
	@Autowired
	private MongoTemplate MongoTemplate;

	public List<people> findAll(){ 
		return MongoTemplate.findAll(people.class);
	}
}*/
