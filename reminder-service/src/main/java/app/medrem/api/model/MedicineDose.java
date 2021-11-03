package app.medrem.api.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import app.medrem.api.constant.MedcineUnit;
import app.medrem.api.constant.MedicineType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Component
@EqualsAndHashCode
@Document(collection = "reminder")
public class MedicineDose {

    @Length(min = 1, message = "not valid")
    private String medName;
    
    @Length(min = 1, message = "not valid")
    private Integer doseSize;
    
    @Length(min = 1, message = "not valid")
    private MedcineUnit doseUnit;
    
    @Length(min = 1, message = "not valid")
    private MedicineType medicineType;
}
