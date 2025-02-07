package crud.com.in.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeesDetailsNotFoundHandler {
	
	@ExceptionHandler(EmployeesDetailsNotFound.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(EmployeesDetailsNotFound ednf){
		
		ErrorDetails error = new ErrorDetails();
		
		return new ResponseEntity<ErrorDetails>(
				new ErrorDetails(ednf.getMessage(),
						"Employees Details is Not Available", "Employees", error.getLocaltime().now()
						)
				,HttpStatus.NOT_FOUND);
		
		
	}

}
