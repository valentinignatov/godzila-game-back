package student.examples.ggengine.services;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.examples.ggengine.domain.entity.PasswordEncoder;
import student.examples.ggengine.domain.entity.User;
import student.examples.ggengine.domain.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerNewUserAccount(User user) {
		user.setId(UUID.randomUUID());
		user.setPassword(hashPassword(user.getPassword()));
		user.setToken(passwordEncoder.encoder().encode(user.getId().toString()));
		
		return userRepo.save(user);
	}

	public String signinUserAccount(String userName, String userPassword) {
		
		Optional<User> userFromDb = userRepo.findByUserNameAndPassword(userName,
				hashPassword(userPassword));
		
		if (userFromDb.isPresent()) {
			return hashPassword(userFromDb.get().getId().toString());
		}

		return null;
	}
	
	private String hashPassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
}
