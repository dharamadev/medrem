package app.medrem.api.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import app.medrem.api.dto.Errordto;

@Component
public class ErrorResponseMap {

	public Errordto getError(String message, int status, String details) {
		return Errordto.builder().time(LocalDateTime.now()).message(message).status(status).uri(details).build();
	}
}
