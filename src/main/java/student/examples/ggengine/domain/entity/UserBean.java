package student.examples.ggengine.domain.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserBean {
	private String username;
	private String password;
}
