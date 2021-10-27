package app.medrem.api.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Component
@EqualsAndHashCode
@Document(collection = "reminder")
public class Dose {

    private Integer doseSize;
    private String doseUnit;
}
