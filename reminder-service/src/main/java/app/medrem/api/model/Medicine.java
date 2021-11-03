package app.medrem.api.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;

import app.medrem.api.constant.Frequency;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@Document(collection = "reminder")
public class Medicine extends Reminder {

    @Length(min = 12, message = "not valid")
    private String accountNumber;
    
    @Length(min = 1, message = "not valid")
    private String illness;

    @Length(min = 1, message = "not valid")
    private Frequency medFrequency;

    @Length(min = 1, message = "not valid")
    private List<MedicineDose> medicineDetails;
    
    private LocalDate fillingDate;
    private String instructions;
}
