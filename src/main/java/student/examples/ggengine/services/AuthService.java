package student.examples.ggengine.services;

import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import student.examples.ggengine.domain.entity.PasswordEncoder;
import student.examples.ggengine.domain.entity.User;
import student.examples.ggengine.domain.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Optional<User> registerNewUserAccount(User user) {
		user.setId(UUID.randomUUID());
		user.setPassword(hashPassword(user.getPassword()));
		user.setToken(passwordEncoder.encoder().encode(user.getId().toString()));
		
//		userRepo.saveAndFlush(user);
		
		return Optional.of(userRepo.saveAndFlush(user));
	}

	public User signinUserAccount(String userName, String userPassword) {
		return userRepo.findByUserNameAndPassword(userName,
				hashPassword(userPassword)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}
	
	private String hashPassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	public Object findAll() {
		return userRepo.findAll();
	}
}
