package app.medrem.api.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import app.medrem.api.entity.dto.Errordto;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@Autowired
	private ErrorResponseMap errorResponseMap;

	@Autowired
	private HttpServletRequest request;

	@ExceptionHandler(RecordNotFound.class)
	public final ResponseEntity<Errordto> recordNotFoundException(RecordNotFound e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseMap.getError(e.getMessage(),
				HttpStatus.NOT_FOUND.value(), request.getRequestURI().toString()));
	}

	@ExceptionHandler(ConflictException.class)
	public final ResponseEntity<Errordto> conflictRequest(ConflictException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseMap.getError(e.getMessage(),
				HttpStatus.CONFLICT.value(), request.getRequestURI().toString()));
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Errordto> genericException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseMap.getError(
				e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI().toString()));
	}
}
