package app.medrem.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RemType {

    WATER("Water"),
    MEDICINE("Medicine");
    
    private String remType;
}
