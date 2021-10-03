package app.medrem.api.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import app.medrem.api.constant.RemType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Qualifier("water")
@EqualsAndHashCode
@Document(collection = "account")
public class Reminder {

    @Id
    private String id;
    private String name;
    private RemType remType;
    private Tracker tracker;
}
