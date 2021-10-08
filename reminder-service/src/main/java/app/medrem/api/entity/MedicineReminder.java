package app.medrem.api.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import app.medrem.api.constant.Frequency;
import app.medrem.api.constant.Type;
import app.medrem.api.constant.Unit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Document(collection = "medicineReminder")
public class MedicineReminder {
    
    @Id
    private String id;
    
    @Length(min = 1, message = "not valid")
    private String name;
    
    @Length(min = 12, message = "not valid")
    private String accountNumber;
    
    @Length(min = 1, message = "not valid")
    private String medName;
    
    @Length(min = 1, message = "not valid")
    private Type medType;
    
    @Length(min = 1, message = "not valid")
    private Unit medUnit;
    
    @Length(min = 1, message = "not valid")
    private String illness;
    
    @Length(min = 1, message = "not valid")
    private Frequency medFrequency;
    
    private LocalDate fillingDate;
    private String instructions;
}
