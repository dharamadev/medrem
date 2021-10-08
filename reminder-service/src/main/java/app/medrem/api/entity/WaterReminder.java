package app.medrem.api.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Document(collection = "waterReminder")
public class WaterReminder {

    @Id
    private String id;
    
    @Length(min = 1, message = "not valid")
    private String name;
    
    @Length(min = 1, message = "not valid")
    private String gender;
    
    @Length(min = 12, message = "not valid")
    private String accountNumber;
    
    @Length(min = 1, message = "not valid")
    private Integer doseSize;
    
    @Length(min = 1, message = "not valid")
    private Integer frequency;
    
    @Length(min = 1, message = "not valid")
    private Integer waterIntake;
    
    @Length(min = 1, message = "not valid")
    private Integer consumed;
    
    @Length(min = 1, message = "not valid")
    private Date bedTime;
    
    @Length(min = 1, message = "not valid")
    private Date wakeupTime;
}
