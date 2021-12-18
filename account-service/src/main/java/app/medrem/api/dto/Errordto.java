package app.medrem.api.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Errordto {

    private String uri;
    private int status;
    private String message;
    private LocalDateTime time;
}
