package app.medrem.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MedicineType {
    
    CAP("Capsule"),
    PILL("Pill"),
    INJ("Injection"),
    POWD("Powder"),
    DROPES("Dropes"),
    INHLR("Inheler"),
    OTH("Other");
  
    private String medType;
}
