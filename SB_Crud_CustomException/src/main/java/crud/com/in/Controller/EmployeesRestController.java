package crud.com.in.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.com.in.Entity.Employees;
import crud.com.in.service.EmployeesServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeesRestController {

	@Autowired
	private EmployeesServiceImpl service;

	@PostMapping("/register")
	public ResponseEntity<String> saveEmpDetails(@RequestBody Employees e) {

		 String saveDetails = service.saveDetails(e);
		return new ResponseEntity<>(saveDetails, HttpStatus.OK);
	}

	@GetMapping("/showAllDetails")
	public ResponseEntity<?> showAllEmpDetails() {

		List<Employees> allEmpDetails = service.getAllEmpDetails();

		if (allEmpDetails != null) {

			return new ResponseEntity<List<Employees>>(allEmpDetails, HttpStatus.OK);
		} else {

			return new ResponseEntity<List<Employees>>(allEmpDetails, HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employees> showDetailsById(@PathVariable (value = "id") int id) {

		Employees empDetailsById = service.getEmpDetailsById(id);

		if (empDetailsById != null) {
			return ResponseEntity.ok(empDetailsById);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<String> updateEmployeesDetails(@PathVariable int id, @RequestBody Employees updateEmp) {
		
		String updateEmployees = service.updateEmployees(id, updateEmp);
		//return ResponseEntity.ok(service.updateEmployees(id, updateEmp));
		
		return new ResponseEntity<>(updateEmployees,HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmpId(@PathVariable(value = "id") int id) {

		String deletedById = service.deletedById(id);

		return new ResponseEntity<String>(deletedById, HttpStatus.OK);

	}

}
