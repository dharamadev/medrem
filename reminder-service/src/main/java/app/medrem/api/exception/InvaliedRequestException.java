package app.medrem.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvaliedRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvaliedRequestException(String msg) {
	super(msg);
    }
}
