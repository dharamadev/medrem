package app.medrem.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Unit {
    
    MG("mg"),
    IU("IU"),
    MCG("mcg"),
    MEG("mEg");
    
    private String medUnit;
}
