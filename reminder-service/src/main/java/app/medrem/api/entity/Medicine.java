package app.medrem.api.entity;

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
public class Medicine implements Tracker {

    @Id
    private String id;
}
