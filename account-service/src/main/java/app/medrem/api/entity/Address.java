package app.medrem.api.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "account")
public class Address {

	@Size(min = 1, message = "not valid")
	private String line1;
	
	@Size(min = 1, message = "not valid")
	private String line2;
	private String line3;
	
	@Length(min = 1, message = "not valid")
	private String city;
	
	@Length(min = 1, message = "not valid")
	private String state;
	
	@Length(min = 1, message = "not valid")
	private String country;
	
	@Length(min = 4, max = 7, message = "not valid")
	private Integer pin;
}
