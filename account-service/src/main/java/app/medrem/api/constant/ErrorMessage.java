package app.medrem.api.constant;

public enum ErrorMessage {

	ACCOUNT_NOT_FOUND("Account not found"),
	INVALID_REQUEST("Invalid request"),
	ACCOUNT_EXISTS("Account already exists"),
    	UNKNOWN_ERROR("Unknown Error");
    
	private String message;

	private ErrorMessage(String message) {
		this.message = message;
	}
	
	public String value() {
		return message;
	}
}
