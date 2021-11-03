package app.medrem.api.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import app.medrem.api.constant.WaterUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Component
@EqualsAndHashCode
@Document(collection = "reminder")
public class WaterDose {

    private Integer doseSize;
    private WaterUnit doseUnit;
}
