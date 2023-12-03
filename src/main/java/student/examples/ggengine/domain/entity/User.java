package student.examples.ggengine.domain.entity;

import java.util.UUID;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	
	@NotNull
	@Pattern(regexp ="[A-Za-z]+ [A-Za-z]+")
	@Column(name = "user_name")
	private String username;
	
	@NotNull
//	@JsonIgnore
//	@Min(8)
//	@Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$") //[a-zA-Z0-9]+$
//	@Pattern(regexp ="[a-zA-Z0-9]")
    @Column(name = "password")
	private String password;
	
	@NotNull
	@Pattern(regexp ="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
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
