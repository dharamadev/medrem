package app.medrem.api.constant;

public enum ErrorMessage {

	ACCOUNT_NOT_FOUND("Reminder not found"),
	INVALID_REQUEST("Invalid request"),
	ACCOUNT_EXISTS("Reminder already exists"),
	INTERNAL_SERVER_ERROR("Server Error");

	private String message;

	private ErrorMessage(String message) {
		this.message = message;
	}
	
	public String value() {
		return message;
	}
}
