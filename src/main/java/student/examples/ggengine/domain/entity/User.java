package student.examples.ggengine.domain.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
@Table(name = "my_user_details")
public class User implements Serializable {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private UUID id;
	
	@Column(name = "user_name")
	private String username;
	
	@JsonIgnore
    @Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "token")
	private String token;
	
	@Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
