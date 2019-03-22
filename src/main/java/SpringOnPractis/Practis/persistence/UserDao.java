package SpringOnPractis.Practis.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import SpringOnPractis.Practis.domain.User;
import lombok.NonNull;

@Component
public class UserDao {
	@Autowired
	private MongoTemplate mongotemplate;
	
	public Optional<User> fiendByUserName(String username) {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username)); 
		return Optional.ofNullable(
				mongotemplate.findOne(query, User.class));
}

	public void save(@NonNull User user) {
		mongotemplate.save(user);
	}
	
}
