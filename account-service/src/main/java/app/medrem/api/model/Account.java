package app.medrem.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "account")
public class Account {

	@Id
	private String id;

	@Length(min = 1, message = "not valid")
	private String firstName;

	private String lastName;

	@Length(min = 1, message = "not valid")
	private String gender;

	@Email(message = "not valid")
	private String email;

	@Indexed(unique = true)
	@Pattern(regexp = "(^$|[0-9]{10,10})", message = "not valid")
	private String contactNumber;

	@Indexed(unique = true)
	private String accountNumber;
}
