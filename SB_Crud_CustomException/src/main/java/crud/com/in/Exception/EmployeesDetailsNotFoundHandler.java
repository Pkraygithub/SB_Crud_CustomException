package crud.com.in.Exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeesDetailsNotFoundHandler {
	
	@ExceptionHandler(EmployeesDetailsNotFound.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(EmployeesDetailsNotFound ednf){
		
		ErrorDetails error = new ErrorDetails();
		
		error.getLocaltime();
		return new ResponseEntity<>(
				new ErrorDetails(
						ednf.getMessage(),"Employees Details is Not Available", "Employees Details", LocalTime.now()
						)
				,HttpStatus.NOT_FOUND);
		
		
	}

}
