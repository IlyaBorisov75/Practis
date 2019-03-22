package SpringOnPractis.Practis.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

import SpringOnPractis.Practis.domain.Role;
import SpringOnPractis.Practis.domain.User;
import SpringOnPractis.Practis.persistence.UserDao;
import lombok.NonNull;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	@PostConstruct
	public void init() {
		
		userDao.fiendByUserName("user").ifPresent(user -> {
			user.setPassword(new BCryptPasswordEncoder().encode("123"));
			userDao.save(user);
		});
		
/*		if (!userDao.fiendByUserName("user").isPresent()) {
			userDao.save(User.builder()
					.username("user")
					.password("{noop}123")
					.authorities(ImmutableList.of(Role.USER))
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.enabled(true)
					.build());
		}*/
	}
	
	@Override
	public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
		return userDao.fiendByUserName(username).orElseThrow(() -> 
		new UsernameNotFoundException("user" + username+  "not founde!"));
		/*return User.builder()
				.username(username)
				.password("{noop}123")
				.authorities(ImmutableList.of(Role.User))
				.accountNonExpired(true)
				.accountNonLocked(true)
				.credentialsNonExpired(true)
				.enabled(true)
				.build();*/
		
	}

}