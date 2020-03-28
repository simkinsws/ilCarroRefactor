package ilcarro.ilcarro.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ilcarro.ilcarro.entities.UserMongo;
import ilcarro.ilcarro.repository.ilCarroRepository;

@Service
public class JwtTokenService implements UserDetailsService {

	@Autowired
	private ilCarroRepository ilCarroRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserMongo userMongo = ilCarroRepository.findById(username).orElse(null);
		if (userMongo.getEmail().equals(username)) {
			return new User(username, userMongo.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
