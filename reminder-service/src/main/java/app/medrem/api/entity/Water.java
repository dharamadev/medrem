package app.medrem.api.entity;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Qualifier("water")
@EqualsAndHashCode
@Document(collection = "tracker")
public class Water implements Tracker {

    @Id
    private String id;
    private String name;
    private String gender;
    private LocalTime wakeupTime;
    private LocalTime bedTime;
    private Integer waterIntake;
    private Integer doseSize;
    private Integer frequency;
    private Integer consumption;
}
