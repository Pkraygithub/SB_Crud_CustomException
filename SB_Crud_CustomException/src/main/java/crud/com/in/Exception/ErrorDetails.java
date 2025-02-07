package crud.com.in.Exception;

import java.time.LocalTime;

public class ErrorDetails {

	private LocalTime localtime;
	private String message;
	private String details;
	private String errorMessage;


	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String details, String message,String errorMessage,LocalTime localtime) {
		super();
		this.localtime = localtime;
		this.message = message;
		this.details = details;
		this.errorMessage = errorMessage;
	}
	
	
	public LocalTime getLocaltime() {
		return localtime;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ErrorDetails [localtime=" + localtime + ", message=" + message + ", details=" + details
				+ ", errorMessage=" + errorMessage + "]";
	}

	

}
