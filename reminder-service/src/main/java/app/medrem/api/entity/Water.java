package app.medrem.api.entity;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Qualifier("water")
@EqualsAndHashCode
@Document(collection = "reminder")
public class Water implements Tracker {

    private String name;
    private String gender;
    private LocalTime wakeupTime;
    private LocalTime bedTime;    
    private Integer waterIntake;
    private Integer doseSize;
    private Integer frequency;
    private Integer consumption;
}
