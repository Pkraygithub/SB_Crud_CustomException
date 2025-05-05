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
	public String saveDetails(Employees emp) {
		repo.saveAndFlush(emp);
		return "Employees Details Inserted Successfully and Id is --> " + emp.getId();
	}
	
	@Override
	public List<Employees> getAllEmpDetails() {
		return repo.findAll();
	}

	@Override
	public Employees getEmpDetailsById(int id) {
		return repo.findById(id).orElseThrow(() -> new EmployeesDetailsNotFound("Employes Details not Found " + id));
	}

	@Override
	public String updateEmployees(int id, Employees updateEmp) {

		Employees updateEmps = repo.findById(id)
				.orElseThrow(() -> new EmployeesDetailsNotFound("Employes Details not Found " + id));

		updateEmps.setName(updateEmp.getName());
		updateEmps.setCity(updateEmp.getCity());
		updateEmps.setPhoNo(updateEmp.getPhoNo());
		updateEmps.setSalary(updateEmp.getSalary());
		updateEmps.setPincode(updateEmp.getPincode());

		repo.save(updateEmps);

		return "Employees Details Updated Successfully whose Id is --> " + updateEmps.getId();

	}

	@Override
	public String deletedById(int id) {

		Employees deleteId = repo.findById(id)
				.orElseThrow(() -> new EmployeesDetailsNotFound("Employes Details not Found " + id));
		repo.delete(deleteId);
		return "Employees Id : " + id + " is Deleted Successfully";
	}
}
