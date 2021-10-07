package app.medrem.api.exception;

public class InvaliedRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvaliedRequestException(String msg) {
		super(msg);
	}
}
