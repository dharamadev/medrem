package app.medrem.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WaterUnit {

    ML("ml"),
    OUNCE("oz"),
    LITER("l"),
    CUP("cup"),
    GLASS("glass");
    
    private String unit;
}
