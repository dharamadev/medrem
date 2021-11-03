package app.medrem.api.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import app.medrem.api.constant.ReminderType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Document(collection = "reminder")
public class Reminder {

    @Id
    private String id;
    
    @Length(min = 1, message = "not valid")
    private String notes;
    
    @Length(min = 1, message = "not valid")
    private ReminderType reminderType;
}
