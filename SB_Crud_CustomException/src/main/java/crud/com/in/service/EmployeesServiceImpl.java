package crud.com.in.service;

import java.util.List;

import crud.com.in.Entity.Employees;

public interface EmployeesServiceImpl {

	public String saveDetails(Employees emp);

	public List<Employees> getAllEmpDetails();

	public Employees getEmpDetailsById(int id);

	public String updateEmployees(int id, Employees updateEmp);

	public String deletedById(int id);

}
