package app.medrem.api.entity;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.mapping.Document;

import app.medrem.api.constant.Frequency;
import app.medrem.api.constant.Type;
import app.medrem.api.constant.Unit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Qualifier("medicine")
@EqualsAndHashCode
@Document(collection = "reminder")
public class Medicine implements Tracker {
    
    private String medName;
    private Type medType;
    private Unit medUnit;
    private String illness;
    private Frequency medFreq;
    private LocalDate fillingDate;
    private String instructions;
}
