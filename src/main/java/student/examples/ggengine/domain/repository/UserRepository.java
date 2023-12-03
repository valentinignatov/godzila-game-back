package student.examples.ggengine.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import student.examples.ggengine.domain.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	Optional<User> findByUsername(String username);
	
	@Query(value = "select * from my_user_details where user_name = ?1 and password = ?2", nativeQuery = true)
    Optional<User> findByUserNameAndPassword(String userName, String password);
}
