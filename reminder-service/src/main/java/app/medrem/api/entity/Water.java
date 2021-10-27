package app.medrem.api.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Document(collection = "reminder")
public class Water extends Reminder {

    @Indexed(unique = true)
    @Length(min = 1, message = "not valid")
    private String accountNumber;
    
    @Length(min = 1, message = "not valid")
    private Integer weight;
    
    @Length(min = 1, message = "not valid")
    private Dose dose;

    @Length(min = 1, message = "not valid")
    private Integer frequency;

    @Length(min = 1, message = "not valid")
    private Integer waterIntake;

    @Length(min = 1, message = "not valid")
    private Integer consumed;

    @Length(min = 1, message = "not valid")
    private String bedTime;
    
    @Length(min = 1, message = "not valid")
    private String wakeupTime;
}
