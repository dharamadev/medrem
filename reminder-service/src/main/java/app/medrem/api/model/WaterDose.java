package app.medrem.api.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import app.medrem.api.constant.WaterUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Component
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reminder")
public class WaterDose {

    private Integer doseSize;
    private WaterUnit doseUnit;
}
