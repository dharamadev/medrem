package app.medrem.api.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Frequency {

    DAILY("Daily"),
    WEAKLY("Weakly"),
    MONTHLY("Monthly"),
    OTHER("Other");
    
    private String medFreq;
}
