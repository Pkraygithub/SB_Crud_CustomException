package crud.com.in.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.com.in.Entity.Employees;
import crud.com.in.Exception.EmployeesDetailsNotFound;
import crud.com.in.repositery.EmployeesRepositery;

@Service
public class EmployeesService implements EmployeesServiceImpl {

	@Autowired
	private EmployeesRepositery repo;

	@Override
	public Employees saveDetails(Employees emp) {
		return repo.saveAndFlush(emp);
	}

	@Override
	public List<Employees> getAllEmpDetails() {
		return repo.findAll();
	}

	@Override
	public Employees updateEmployees(int id, Employees updateEmp) {
		
		Employees updateEmps = repo.findById(id)
				.orElseThrow(()->new EmployeesDetailsNotFound("Employes Details not Found "+id));
		
		updateEmps.setName(updateEmp.getName());
		updateEmps.setCity(updateEmp.getCity());
		updateEmps.setPhoNo(updateEmp.getPhoNo());
		updateEmps.setSalary(updateEmp.getSalary());
		updateEmps.setPincode(updateEmp.getPincode());
		
		return repo.save(updateEmps);
	}

	@Override
	public String deletedById(int id) {

		Employees deleteId = repo.findById(id)
				.orElseThrow(()-> new EmployeesDetailsNotFound("Employes Details not Found "+id));		
		repo.delete(deleteId);
		return "Employees Id"+id+ "is Deleted Successfully";
	}

	@Override
	public Employees getEmpDetailsById(int id) {
		return repo.findById(id).orElseThrow(()-> new EmployeesDetailsNotFound("Employes Details not Found "+id));
	}

}
